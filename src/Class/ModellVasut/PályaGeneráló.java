package Class.ModellVasut;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public class P�lyaGener�l� {

	private static P�lyaGener�l� me = null;

	private File bemenet;
	private int szint;

	public P�lyaGener�l�(){
		szint = 0;
	}

	public void finalize() throws Throwable {

	}

	public static P�lyaGener�l� getInstance() {
		if(me == null) {
			me = new P�lyaGener�l�();
		}

		return me;
	}

	/**
	 * P�lya bet�lt�s�rt, felel�s f�ggv�ny.
	 * A Szkeletonban csak 2 Csom�pontot, az �ket �sszek�t� SinElemeket,
	 * kett� kocsit, �s az �ket huz� mozdonyt hozzuk l�tre, valamint az id�z�t�t,
	 * ami a vonatok mozgat�s��rt felel.
	 */

	public Id�z�t� kezd�s(){

        szint++;
	    bemenet = new File("TesztBe" + String.valueOf(szint) + ".txt");
        BufferedReader br = null;
        List<Csom�pont> csom�pontList= new ArrayList<>();
        csom�pontList.add(new Csom�pont());

        List<Mozdony> mozdonyList = new ArrayList<>();
        Id�z�t� id� = new Id�z�t�(mozdonyList);
        try {

            File file = new File("/kimenet/Kimenet"+szint+".txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            br=new BufferedReader(new FileReader(bemenet));
            String sor;
            while(!(sor=br.readLine()).equals("Start")){
                String parancs=sor.substring(0,3);

                if(parancs.equals("Csp")){
                    csom�pontList.add(new Csom�pont());
                    bw.write("�j Csom�pont j�tt l�tre "+csom�pontList.get(csom�pontList.size()-1).getId()+" ID-val\n");
                } else if(parancs.equals("Vlt")) {
                    csom�pontList.add(new V�lt�());
                    bw.write("�j V�lt� j�tt l�tre "+csom�pontList.get(csom�pontList.size()-1).getId()+"ID-val\n");
                } else if(parancs.equals("Als")) {
                    csom�pontList.add(new Alag�tSz�j());
                    bw.write("�j Alag�tSz�j j�tt l�tre "+csom�pontList.get(csom�pontList.size()-1).getId()+"ID-val\n");
                } else if(parancs.equals("Sel")) {
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
                        bw.write("�j S�nElem j�tt l�tre\n");
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
                    csom�pontList.add(new Keresztez�S�n());
                    bw.write("�j Keresztez�S�n j�tt l�tre "+csom�pontList.get(csom�pontList.size()-1).getId()+"ID-val\n");
                } else if(parancs.equals("All")) {
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
                    bw.write("�j "+sz�n+" �llom�s j�tt l�tre "+csom�pontList.get(csom�pontList.size()-1).getId()+"ID-val\n");
                } else if(parancs.equals("Mzd")) {
                    int csp1=Integer.parseInt(sor.substring(4,5));
                    Csom�pont cs1=null;
                    for (Csom�pont cs: csom�pontList) {
                        if(cs.getId()==csp1) cs1=cs;
                    }

                    int k=Integer.parseInt(sor.substring(6,7));

                    Mozdony m=new Mozdony(cs1, k);
                    bw.write("�j Mozdony j�tt l�tre\n");
                    m.setPoz�ci�(new S�nElem(csom�pontList.get(0), cs1,false));
                    m.setIr�ny(true);
                    mozdonyList.add(m);


                } else if(parancs.equals("Snk")) {
                    VonatElem iter = mozdonyList.get(mozdonyList.size() - 1);
                    while (iter.getK�vetkez�() != null) {
                        iter = iter.getK�vetkez�();
                    }

                    SzenesKocsi s=new SzenesKocsi();
                    bw.write("�j SzenesKocsi j�tt l�tre\n");
                    s.setPoz�ci�(new S�nElem(csom�pontList.get(0), mozdonyList.get(mozdonyList.size()-1).getBel�p�siPont(),false));
                    s.setIr�ny(true);
                    iter.getPoz�ci�().setK�vetkez�(s.getPoz�ci�());
                    iter.setK�vetkez�(s);



                } else if(parancs.equals("Smk")) {
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
                    bw.write("�j "+sz�n+" Szem�lyKocsi j�tt l�tre\n");
                    s.setPoz�ci�(new S�nElem(csom�pontList.get(0), mozdonyList.get(mozdonyList.size() - 1).getBel�p�siPont(), false));
                    s.setIr�ny(true);
                    iter.getPoz�ci�().setEl�z�(s.getPoz�ci�());
                    iter.setK�vetkez�(s);

                } else {
                    System.out.println("Nem megfelel� parancs.");
                }
            }


            while((sor=br.readLine())!=null){
                String parancs=sor.substring(0,3);
                String index = sor.substring(4,5);
                if(sor.equals("tick()")){
                    System.out.println("tick");
                    id�.tick();
                    bw.write("Tick\n");
                } else if(parancs.equals("Swc")) {
                    csom�pontList.get(Integer.parseInt(index)-1).felhaszn�l�Akci�();

                } else if(parancs.equals("Akt")) {
                    csom�pontList.get(Integer.parseInt(index)-1).felhaszn�l�Akci�();
                }
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return id�;
    }

}