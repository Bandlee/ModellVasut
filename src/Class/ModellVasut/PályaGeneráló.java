package Class.ModellVasut;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public class PályaGeneráló {

	private static PályaGeneráló me = null;

	private File bemenet;
	private int szint;

	public PályaGeneráló(){
		szint = 0;
	}

	public void finalize() throws Throwable {

	}

	public static PályaGeneráló getInstance() {
		if(me == null) {
			me = new PályaGeneráló();
		}

		return me;
	}

	/**
	 * Pálya betöltésért, felelõs függvény.
	 * A Szkeletonban csak 2 Csomópontot, az öket összekötõ SinElemeket,
	 * kettõ kocsit, és az õket huzú mozdonyt hozzuk létre, valamint az idõzítõt,
	 * ami a vonatok mozgatásáért felel.
	 */

	public Idõzítõ kezdés(){
        szint++;
	    bemenet = new File("TesztBe" + String.valueOf(szint) + ".txt");
        BufferedReader br = null;
        List<Csomópont> csomópontList= new ArrayList<>();
        csomópontList.add(new Csomópont());

        List<Mozdony> mozdonyList = new ArrayList<>();
        Idõzítõ idõ = new Idõzítõ(mozdonyList);
        try {
            br=new BufferedReader(new FileReader(bemenet));
            String sor;
            while(!(sor=br.readLine()).equals("Start")){
                String parancs=sor.substring(0,3);

                if(parancs.equals("Csp")){
                    csomópontList.add(new Csomópont());
                    System.out.println("Új Csomópont jött létre "+id+" ID-val");
                } else if(parancs.equals("Vlt")) {
                    csomópontList.add(new Váltó());

                } else if(parancs.equals("Als")) {
                    csomópontList.add(new AlagútSzáj());

                } else if(parancs.equals("Sel")) {
                    int csp1=Integer.parseInt(sor.substring(4,5));
                    Csomópont cs1=null;
                    for (Csomópont cs: csomópontList) {
                        if(cs.getId()==csp1) cs1=cs;
                    }

                    int csp2=Integer.parseInt(sor.substring(6,7));
                    Csomópont cs2=null;
                    for (Csomópont cs: csomópontList) {
                        if(cs.getId()==csp2) cs2=cs;
                    }

                    int db=Integer.parseInt(sor.substring(8,9));

                    List<SínElem> temp_se =new ArrayList<>();
                    for(int i=0;i<db;i++) temp_se.add(new SínElem(cs1, cs2, true));

                    if (temp_se.size()>1) {
                        for (int i = 0; i < temp_se.size() - 1; i++) {
                            temp_se.get(i).setKövetkezõ(temp_se.get(i+1));
                            System.out.println(temp_se.get(i));
                        }
                        System.out.println(temp_se.get(temp_se.size()-1));
                    }
                    cs1.setBefutóSín(temp_se.get(0));
                    cs2.setBefutóSín(temp_se.get(temp_se.size()-1));

                } else if(parancs.equals("Ksn")) {
                    csomópontList.add(new KeresztezõSín());

                } else if(parancs.equals("All")) {
                    int db=4;
                    String szín=null;
                    boolean utas;
                    szín= sor.substring(4, sor.indexOf(','));

                    if (sor.substring(db,db+1)=="1"){
                        utas=true;
                    } else {
                        utas=false;
                    }

                    csomópontList.add(new Állomás(szín, utas));

                } else if(parancs.equals("Mzd")) {
                    int csp1=Integer.parseInt(sor.substring(4,5));
                    Csomópont cs1=null;
                    for (Csomópont cs: csomópontList) {
                        if(cs.getId()==csp1) cs1=cs;
                    }

                    int k=Integer.parseInt(sor.substring(6,7));

                    Mozdony m=new Mozdony(cs1, k);
                    m.setPozíció(new SínElem(csomópontList.get(0), cs1,false));
                    m.setIrány(true);
                    mozdonyList.add(m);


                } else if(parancs.equals("Snk")) {
                    VonatElem iter = mozdonyList.get(mozdonyList.size() - 1);
                    while (iter.getKövetkezõ() != null) {
                        iter = iter.getKövetkezõ();
                    }

                    SzenesKocsi s=new SzenesKocsi();
                    s.setPozíció(new SínElem(csomópontList.get(0), mozdonyList.get(mozdonyList.size()-1).getBelépésiPont(),false));
                    s.setIrány(true);
                    iter.getPozíció().setKövetkezõ(s.getPozíció());
                    iter.setKövetkezõ(s);



                } else if(parancs.equals("Smk")) {
                    int db=4;
                    String szín=null;
                    boolean utas;
                    szín= sor.substring(4, sor.indexOf(','));

                    if (sor.substring(db,db+1)=="1"){
                        utas=true;
                    } else {
                        utas=false;
                    }

                    VonatElem iter = mozdonyList.get(mozdonyList.size() - 1);
                    while (iter.getKövetkezõ() != null) {
                        iter = iter.getKövetkezõ();
                    }

                    SzemélyKocsi s = new SzemélyKocsi(szín, utas);
                    s.setPozíció(new SínElem(csomópontList.get(0), mozdonyList.get(mozdonyList.size() - 1).getBelépésiPont(), false));
                    s.setIrány(true);
                    iter.getPozíció().setElõzõ(s.getPozíció());
                    iter.setKövetkezõ(s);

                } else {
                    System.out.println("Nem megfelelõ parancs.");
                }
            }


            while((sor=br.readLine())!=null){
                String parancs=sor.substring(0,3);
                String index = sor.substring(4,5);
                if(sor.equals("tick()")){
                    System.out.println("tick");
                    idõ.tick();
                } else if(parancs.equals("Swc")) {
                    csomópontList.get(Integer.parseInt(index)-1).felhasználóAkció();
                } else if(parancs.equals("Akt")) {
                    csomópontList.get(Integer.parseInt(index)-1).felhasználóAkció();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return idõ;
    }

}