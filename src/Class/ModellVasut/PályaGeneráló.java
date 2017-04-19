package Class.ModellVasut;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A bemeneti �s kimeneti f�jlok kezel�s��rt felel�s oszt�ly.
 * A bemeneti f�jlok alapj�n �p�ti fel a p�ly�t, beolvas n�h�ny elv�gzend� parancsot, majd v�gre is hajtja �ket.
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public class P�lyaGener�l� {

	private static P�lyaGener�l� me = null;

	private File bemenet;
	private int szint;

    private BufferedWriter bw;
    /**
     * Konstruktor. Mivel csak egyetlen p�ld�ny l�tezik az oszt�lyb�l, a konstruktor priv�t.
     */
	private P�lyaGener�l�(){
		szint = 0;
	}

	public void finalize() throws Throwable {

	}

    /**
     * Csak egy p�ld�ny l�tezik a P�lyaGener�l�b�l, ez a met�dus biztos�tja ennek a lek�r�s�t.
     * Amennyiben m�g nem l�tezik az adott p�ld�ny, l�trehozza mert � hozz�f�r a konstruktorhoz.
     * @return a p�lyagener�l� p�ld�nya
     */
	public static P�lyaGener�l� getInstance() {
		if(me == null) {
			me = new P�lyaGener�l�();
		}

		return me;
	}

	/**
	 * Bemeneti f�jlok feldolgoz�sa �s kimeneti f�jlok k�sz�t�se.
     * A bemeneti f�jlokb�l soronk�nt �ll�tjuk el� a parancsokat, majd ennek megfelel�en elk�sz�tj�k a megfelel� alkot�elemeket
     * Ezek ut�n a start beolvas�sa ut�n parancsokat olvasunk �s hajtunk v�gre
     * Mellette a kimeneti f�jlban jelezz�k, hogy �ppen mi t�rt�nik.
	 */

	public Id�z�t� kezd�s(){
	    /** OLvas�s �s �r�s inicializ�l�sa */
        Csom�pont.nullId();
        szint++;
	    bemenet = new File("bemenet/TesztBe" + String.valueOf(szint) + ".txt");
        BufferedReader br = null;
        List<Csom�pont> csom�pontList= new ArrayList<>();
        csom�pontList.add(new Csom�pont());

        List<Mozdony> mozdonyList = new ArrayList<>();
        Id�z�t� id� = new Id�z�t�(mozdonyList);

        /** A beolvas�st �s ki�r�st bennfoglal� try blokk.
         *  Benne a f�jlok sorok�nti feldolgoz�sa
         */
        try {

            File file = new File("kimenet/Kimenet"+szint+".txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);

            br=new BufferedReader(new FileReader(bemenet));
            String sor;

            /** a start parancsig olvasunk. a beolvasottakb�l �p�l fel a p�lya */
            while(!(sor=br.readLine()).equals("Start")){
                String parancs=sor.substring(0,3);

                if(parancs.equals("Csp")){
                    /** csom�pont el��ll�t�sa */
                    csom�pontList.add(new Csom�pont());
                    bw.write("�j Csom�pont j�tt l�tre "+csom�pontList.get(csom�pontList.size()-1).getId()+" ID-val");
                    bw.newLine();
                } else if(parancs.equals("Vlt")) {
                    /** v�lt� el��ll�t�sa */
                    csom�pontList.add(new V�lt�());
                    bw.write("�j V�lt� j�tt l�tre "+csom�pontList.get(csom�pontList.size()-1).getId()+"ID-val");
                    bw.newLine();
                } else if(parancs.equals("Asz")) {
                    /** alag�tsz�j el��ll�t�sa */
                    csom�pontList.add(new Alag�tSz�j());
                    bw.write("�j Alag�tSz�j j�tt l�tre "+csom�pontList.get(csom�pontList.size()-1).getId()+"ID-val");
                    bw.newLine();
                } else if(parancs.equals("Sel")) {
                    /** s�nelem el��ll�t�sa, s�nelemek bekapcsol�a a csom�pontok k�z� */
                    int csp1=Integer.parseInt(sor.substring(4,5));
                    Csom�pont cs1=null;
                    for (Csom�pont cs: csom�pontList) {
                        if(cs.getId()==csp1) cs1=cs;
                    }

                    int csp2=Integer.parseInt(sor.substring(6,7));
                    Csom�pont cs2=null;
                    for (Csom�pont cs: csom�pontList) {
                        if(cs.getId()==csp2) cs2=cs;
                    }

                    int db=Integer.parseInt(sor.substring(8,9));

                    List<S�nElem> temp_se =new ArrayList<>();
                    for(int i=0;i<db;i++) {
                        temp_se.add(new S�nElem(cs1, cs2, true));
                        bw.write("�j S�nElem j�tt l�tre");
                        bw.newLine();
                    }

                    if (temp_se.size()>1) {
                        for (int i = 0; i < temp_se.size() - 1; i++) {
                            temp_se.get(i).setK�vetkez�(temp_se.get(i+1));
                            System.out.println(temp_se.get(i));
                        }
                        System.out.println(temp_se.get(temp_se.size()-1));
                    }
                    cs1.setBefut�S�n(temp_se.get(0));
                    cs2.setBefut�S�n(temp_se.get(temp_se.size()-1));

                } else if(parancs.equals("Ksn")) {
                    /** keresztez�s�n el��ll�t�sa */
                    csom�pontList.add(new Keresztez�S�n());
                    bw.write("�j Keresztez�S�n j�tt l�tre "+csom�pontList.get(csom�pontList.size()-1).getId()+"ID-val");
                    bw.newLine();
                } else if(parancs.equals("All")) {
                    /** �llom�s el��ll�t�sa */
                    int db=4;
                    String sz�n=null;
                    boolean utas;
                    sz�n= sor.substring(4, sor.indexOf(','));

                    if (sor.substring(db,db+1)=="1"){
                        utas=true;
                    } else {
                        utas=false;
                    }

                    csom�pontList.add(new �llom�s(sz�n, utas));
                    bw.write("�j "+sz�n+" �llom�s j�tt l�tre "+csom�pontList.get(csom�pontList.size()-1).getId()+"ID-val");
                    bw.newLine();
                } else if(parancs.equals("Mzd")) {
                    /** mozdony el��ll�t�sa */
                    int csp1=Integer.parseInt(sor.substring(4,5));
                    Csom�pont cs1=null;
                    for (Csom�pont cs: csom�pontList) {
                        if(cs.getId()==csp1) cs1=cs;
                    }

                    int k=Integer.parseInt(sor.substring(6,7));

                    Mozdony m=new Mozdony(cs1, k);
                    bw.write("�j Mozdony j�tt l�tre");
                    bw.newLine();
                    m.setPoz�ci�(new S�nElem(csom�pontList.get(0), cs1,false));
                    m.setIr�ny(true);
                    mozdonyList.add(m);


                } else if(parancs.equals("Snk")) {
                    /** szeneskocsi el��ll�t�sa */
                    VonatElem iter = mozdonyList.get(mozdonyList.size() - 1);
                    while (iter.getK�vetkez�() != null) {
                        iter = iter.getK�vetkez�();
                    }

                    SzenesKocsi s=new SzenesKocsi();
                    bw.write("�j SzenesKocsi j�tt l�tre");
                    bw.newLine();
                    s.setPoz�ci�(new S�nElem(csom�pontList.get(0), mozdonyList.get(mozdonyList.size()-1).getBel�p�siPont(),false));
                    s.setIr�ny(true);
                    iter.getPoz�ci�().setK�vetkez�(s.getPoz�ci�());
                    iter.setK�vetkez�(s);



                } else if(parancs.equals("Smk")) {
                    /** szem�lykocsi el��ll�t�sa */
                    int db=4;
                    String sz�n=null;
                    boolean utas;
                    sz�n= sor.substring(4, sor.indexOf(','));

                    if (sor.substring(db,db+1)=="1"){
                        utas=true;
                    } else {
                        utas=false;
                    }

                    VonatElem iter = mozdonyList.get(mozdonyList.size() - 1);
                    while (iter.getK�vetkez�() != null) {
                        iter = iter.getK�vetkez�();
                    }

                    Szem�lyKocsi s = new Szem�lyKocsi(sz�n, utas);
                    bw.write("�j "+sz�n+" Szem�lyKocsi j�tt l�tre");
                    bw.newLine();
                    s.setPoz�ci�(new S�nElem(csom�pontList.get(0), mozdonyList.get(mozdonyList.size() - 1).getBel�p�siPont(), false));
                    s.setIr�ny(true);
                    iter.getPoz�ci�().setEl�z�(s.getPoz�ci�());
                    iter.setK�vetkez�(s);

                } else {
                    System.out.println("Nem megfelel� parancs.");
                }
            }

            /** f�jl v�g�ig a parancsok beolvas�sa �s feldolgoz�sa */

            try {
                while ((sor = br.readLine()) != null) {
                    String parancs = sor.substring(0, 3);
                    String index = sor.substring(4, 5);
                    if (sor.equals("tick()")) {
                        /** tick parancs */
                        System.out.println("tick");
                        id�.tick();
                    } else if (parancs.equals("Swc")) {
                        csom�pontList.get(Integer.parseInt(index)).felhaszn�l�Akci�();
                        /** v�lt� �ll�t�sa */
                        bw.write("V�lt�s t�rt�nt");
                        bw.newLine();
                    } else if (parancs.equals("Akt")) {
                        /** alag�tsz�j-aktivit�s �ll�t�sa */
                        csom�pontList.get(Integer.parseInt(index)).felhaszn�l�Akci�();
                        bw.write("Alag�tsz�j aktivit�s v�ltozott");
                        bw.newLine();
                    }
                }
            }catch (VegException v){
                bw.write(v.getMessage());
            }

            br.close();
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return id�;
    }

    /**
     * a tesztesetek kimenetel�nek ki�r�s�hoz haszn�latos, visszaadja a haszn�lt bufferedreadert
     * @return bw
     */
    public BufferedWriter getBw(){return bw;}

}