package Class.ModellVasut;


import javax.crypto.Cipher;
import javax.smartcardio.CardTerminal;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A bemeneti és kimeneti fájlok kezeléséért felelõs osztály.
 * A bemeneti fájlok alapján építi fel a pályát, beolvas néhány elvégzendõ parancsot, majd végre is hajtja õket.
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public class PályaGeneráló {

	private static PályaGeneráló me = null;
	static private Controller ctrl;
	private int szint;
	private int sebesség;

    //private BufferedWriter bw;
    /**
     * Konstruktor. Mivel csak egyetlen példány létezik az osztályból, a konstruktor privát.
     */
	private PályaGeneráló(){
		szint =0;
	}

	public void finalize() throws Throwable {

	}

    /**
     * Csak egy példány létezik a PályaGenerálóból, ez a metódus biztosítja ennek a lekérését.
     * Amennyiben még nem létezik az adott példány, létrehozza mert õ hozzáfér a konstruktorhoz.
     * @return a pályageneráló példánya
     */
	public static PályaGeneráló getInstance() {
		if(me == null) {
			me = new PályaGeneráló();
		}

		return me;
	}



	public Idõzítõ kezdés() {
		szint++;
		Idõzítõ idõ= null;
		try {
			idõ = kezdés(szint,sebesség);
		} catch (IOException e) {
			ctrl.játékVége();
		}
		return idõ;
	}

	//graf version
	public Idõzítõ kezdés(int _szint, int _sebesség) throws IOException {

		szint = _szint;
		sebesség = _sebesség;
		File pályaFile = new File("Palya" +szint +".txt");

		//elejére szurunk be mindig
		List<VonatElem> vonatelemek = new LinkedList<>(); //->elemekbe majd

		List<Mozdony> mozdonyok = new LinkedList<>(); //->idõzítõnek csak
		List<Csomópont> csomópontok = new ArrayList<>(); //->elemekbe majd + pályagenhez kell (noid)

		List<IMegjeleníthetõ> elemek = new LinkedList<>(); //->Controllernek
		List<IKattintható> kattinthatók = new LinkedList<>(); //->Controllernek


		BufferedReader br = null;
		String sor;


		br = new BufferedReader(new FileReader(pályaFile));
		sor = br.readLine();
		while(sor != null) {
			sor = sor.replaceAll("\\s","");
			String parancs=sor.substring(0,3);
			String params[] = getParams(sor);
			switch (parancs) {



				case "Csp":
					csomópontok.add(new Csomópont(
							Integer.parseInt(params[0]),
							Integer.parseInt(params[1])
					));
					break;

				case "Ksn":
					csomópontok.add(new KeresztezõSín(
							Integer.parseInt(params[0]),
							Integer.parseInt(params[1])
					));
					break;

				case "Vlt":
					Váltó vlt = new Váltó(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
					csomópontok.add(vlt);
					kattinthatók.add(vlt);
					break;

				case "Asz":
					AlagútSzáj asz = new AlagútSzáj(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
					csomópontok.add(asz);
					kattinthatók.add(asz);
					break;

				case "All":
					csomópontok.add(new Állomás(
							params[0],
							params[1].equals("1"),
							Integer.parseInt(params[2]),
							Integer.parseInt(params[3])
					));
					break;

					//harmadik paramétert nem veszi még figyelembe
				case "Sel":
					elemek.add(new GrafSín(
						csomópontok.get(Integer.parseInt(params[0])-1),
						csomópontok.get(Integer.parseInt(params[1])-1)
					));
					break;

				case "Mzd":
					Mozdony mzd = new Mozdony(
							csomópontok.get(Integer.parseInt(params[0])-1),
							Integer.parseInt(params[1])
					);
					vonatelemek.add(0,mzd);
					mozdonyok.add(mzd);
					break;

				case "Snk":
					vonatelemek.add(0,new SzenesKocsi(vonatelemek.get(0)));
					break;

				case "Smk":
					vonatelemek.add(0,new SzemélyKocsi(
							params[0],
							params[1].equals("1"),
							vonatelemek.get(0)
					));
					break;
			}
			sor = br.readLine();
		}
		for (Csomópont csp : csomópontok)
			elemek.add(csp);

		for (VonatElem ve : vonatelemek)
			elemek.add(ve);

		Idõzítõ idõ = new Idõzítõ(mozdonyok,sebesség);

		ctrl.setElemek(elemek);
		ctrl.setKattinthatók(kattinthatók);
		ctrl.setIdõzítõ(idõ);
		ctrl.start();



		return idõ;
	}

	private String[] getParams(String sor){
		int start = sor.indexOf('(')+1;
		int end = sor.indexOf(')');
		return sor.substring(start,end).split(",");
	}


	static public void setController(Controller _ctrl){
		ctrl = _ctrl;
	}

	/**
	 * Bemeneti fájlok feldolgozása és kimeneti fájlok készítése.
     * A bemeneti fájlokból soronként állítjuk elõ a parancsokat, majd ennek megfelelõen elkészítjük a megfelelõ alkotóelemeket
     * Ezek után a start beolvasása után parancsokat olvasunk és hajtunk végre
     * Mellette a kimeneti fájlban jelezzük, hogy éppen mi történik.
	 */


	public Idõzítõ kezdés(boolean auto){

	    // ctrl + slash uncommenthez
//	    /** OLvasás és írás inicializálása */
//        Csomópont.nullId();
//        szint++;
//        if(auto) {
//            bemenet = new File("bemenet/TesztBe" + String.valueOf(szint) + ".txt");
//        } else {
//            bemenet = new File("SajatBemenet.txt");
//        }
//	    int összutas=0;
//        BufferedReader br = null;
//        List<Csomópont> csomópontList= new ArrayList<>();
//        csomópontList.add(new Csomópont());
//
//        List<Mozdony> mozdonyList = new ArrayList<>();
//        Idõzítõ idõ = new Idõzítõ(mozdonyList);
//
//        /** A beolvasást és kiírást bennfoglaló try blokk.
//         *  Benne a fájlok sorokénti feldolgozása
//         */
//        try {
//            File file=null;
//            if(auto) {
//                 file = new File("kimenet/Kimenet" + szint + ".txt");
//            } else {
//                file = new File("SajatKimenet.txt");
//            }
//
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//
//            FileWriter fw = new FileWriter(file.getAbsoluteFile());
//            bw = new BufferedWriter(fw);
//
//            br=new BufferedReader(new FileReader(bemenet));
//            String sor;
//
//            /** a start parancsig olvasunk. a beolvasottakból épül fel a pálya */
//            while(!(sor=br.readLine()).equals("Start")){
//                String parancs=sor.substring(0,3);
//
//                if(parancs.equals("Csp")){
//                    /** csomópont elõállítása */
//                    csomópontList.add(new Csomópont());
//                    bw.write("Új Csomópont jött létre "+csomópontList.get(csomópontList.size()-1).getId()+" ID-val");
//                    bw.newLine();
//                } else if(parancs.equals("Vlt")) {
//                    /** váltó elõállítása */
//                    csomópontList.add(new Váltó());
//                    bw.write("Új Váltó jött létre "+csomópontList.get(csomópontList.size()-1).getId()+" ID-val");
//                    bw.newLine();
//                } else if(parancs.equals("Asz")) {
//                    /** alagútszáj elõállítása */
//                    csomópontList.add(new AlagútSzáj());
//                    bw.write("Új AlagútSzáj jött létre "+csomópontList.get(csomópontList.size()-1).getId()+" ID-val");
//                    bw.newLine();
//                } else if(parancs.equals("Sel")) {
//                    /** sínelem elõállítása, sínelemek bekapcsoláa a csomópontok közé */
//                    int csp1=Integer.parseInt(sor.substring(4,5));
//                    Csomópont cs1=null;
//                    for (Csomópont cs: csomópontList) {
//                        if(cs.getId()==csp1) cs1=cs;
//                    }
//
//                    int csp2=Integer.parseInt(sor.substring(6,7));
//                    Csomópont cs2=null;
//                    for (Csomópont cs: csomópontList) {
//                        if(cs.getId()==csp2) cs2=cs;
//                    }
//
//                    int db=Integer.parseInt(sor.substring(8,9));
//
//                    List<SínElem> temp_se =new ArrayList<>();
//                    for(int i=0;i<db;i++) {
//                        temp_se.add(new SínElem(cs1, cs2, true));
//                        bw.write("Új SínElem jött létre");
//                        bw.newLine();
//                    }
//
//                    if (temp_se.size()>1) {
//                        for (int i = 0; i < temp_se.size() - 1; i++) {
//                            temp_se.get(i).setKövetkezõ(temp_se.get(i+1));
//                            //System.out.println(temp_se.get(i));
//                        }
//                    }
//                    //System.out.println(temp_se.get(temp_se.size()-1));
//
//                    cs1.setBefutóSín(temp_se.get(0));
//                    cs2.setBefutóSín(temp_se.get(temp_se.size()-1));
//
//                } else if(parancs.equals("Ksn")) {
//                    /** keresztezõsín elõállítása */
//                    csomópontList.add(new KeresztezõSín());
//                    bw.write("Új KeresztezõSín jött létre "+csomópontList.get(csomópontList.size()-1).getId()+" ID-val");
//                    bw.newLine();
//                } else if(parancs.equals("All")) {
//                    /** állomás elõállítása */
//                    String szín=null;
//                    boolean utas;
//                    int db=sor.indexOf(',');
//                    szín= sor.substring(4, db);
//
//                    if (sor.substring(db+1,db+2).equals("1")){
//                        utas=true;
//                        összutas++;
//                    } else {
//                        utas=false;
//                    }
//
//                    csomópontList.add(new Állomás(szín, utas));
//                    bw.write("Új "+szín+" Állomás jött létre "+csomópontList.get(csomópontList.size()-1).getId()+" ID-val");
//                    bw.newLine();
//                } else if(parancs.equals("Mzd")) {
//                    /** mozdony elõállítása */
//                    int csp1=Integer.parseInt(sor.substring(4,5));
//                    Csomópont cs1=null;
//                    for (Csomópont cs: csomópontList) {
//                        if(cs.getId()==csp1) cs1=cs;
//                    }
//
//                    int k=Integer.parseInt(sor.substring(6,7));
//
//                    Mozdony m=new Mozdony(cs1, k);
//                    bw.write("Új Mozdony jött létre");
//                    bw.newLine();
//                    m.setPozíció(new SínElem(csomópontList.get(0), cs1,false));
//                    m.setIrány(true);
//                    mozdonyList.add(m);
//
//
//                } else if(parancs.equals("Snk")) {
//                    /** szeneskocsi elõállítása */
//                    VonatElem iter = mozdonyList.get(mozdonyList.size() - 1);
//                    while (iter.getKövetkezõ() != null) {
//                        iter = iter.getKövetkezõ();
//                    }
//
//                    SzenesKocsi s=new SzenesKocsi();
//                    bw.write("Új SzenesKocsi jött létre");
//                    bw.newLine();
//                    s.setPozíció(new SínElem(csomópontList.get(0), mozdonyList.get(mozdonyList.size()-1).getBelépésiPont(),false));
//                    s.setIrány(true);
//                    iter.getPozíció().setKövetkezõ(s.getPozíció());
//                    iter.setKövetkezõ(s);
//
//
//
//                } else if(parancs.equals("Smk")) {
//                    /** személykocsi elõállítása */
//                    String szín=null;
//                    boolean utas;
//                    int db=sor.indexOf(',');
//                    szín= sor.substring(4, db);
//
//                    if (sor.substring(db+1,db+2).equals("1")){
//                        utas=true;
//                        összutas++;
//                    } else {
//                        utas=false;
//                    }
//
//                    VonatElem iter = mozdonyList.get(mozdonyList.size() - 1);
//                    while (iter.getKövetkezõ() != null) {
//                        iter = iter.getKövetkezõ();
//                    }
//
//                    SzemélyKocsi s = new SzemélyKocsi(szín, utas);
//                    bw.write("Új "+szín+" SzemélyKocsi jött létre");
//                    bw.newLine();
//                    s.setPozíció(new SínElem(csomópontList.get(0), mozdonyList.get(mozdonyList.size() - 1).getBelépésiPont(), false));
//                    s.setIrány(true);
//                    iter.getPozíció().setElõzõ(s.getPozíció());
//                    iter.setKövetkezõ(s);
//
//                } else {
//                    System.out.println("Nem megfelelõ parancs.");
//                }
//            }
//
//            for (Mozdony m: mozdonyList) {
//                if (m.getKövetkezõ()!=null){
//                    m.getKövetkezõ().setLeszállhat(true);
//                }
//            }
//            Állomás.setNemleszállt(összutas);
//            bw.write("Start");
//            bw.newLine();
//
//            /** fájl végéig a parancsok beolvasása és feldolgozása */
//
//            try {
//                while ((sor = br.readLine()) != null) {
//                    String parancs = sor.substring(0, 3);
//                    String index = sor.substring(4, 5);
//                    if (sor.equals("tick()")) {
//                        /** tick parancs */
//                        bw.write("tick");
//                        bw.newLine();
//                        idõ.tick();
//                    } else if (parancs.equals("Swc")) {
//                        csomópontList.get(Integer.parseInt(index)).felhasználóAkció();
//                        /** váltó állítása */
//                        bw.write("Váltás történt");
//                        bw.newLine();
//                    } else if (parancs.equals("Akt")) {
//                        /** alagútszáj-aktivitás állítása */
//                        csomópontList.get(Integer.parseInt(index)).felhasználóAkció();
//                        bw.write("Alagútszáj aktivitás változott");
//                        bw.newLine();
//                    }
//                }
//            } catch (VegException v){
//                bw.write(v.getMessage());
//            }
//
//            br.close();
//            bw.close();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        return idõ;
        return null;
    }

    /**
     * a tesztesetek kimenetelének kiírásához használatos, visszaadja a használt bufferedreadert
     * @return bw
     */
    //public BufferedWriter getBw(){return bw;}

}