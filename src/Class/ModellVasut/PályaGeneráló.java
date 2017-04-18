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
        bemenet = new File("tesztbe" + String.valueOf(szint));
        BufferedReader br = null;
        List<Csomópont> csomópontList= new ArrayList<>();
        List<Mozdony> mozdonyList = new ArrayList<>();
        Idõzítõ idõ = new Idõzítõ(mozdonyList);
        try {
            br=new BufferedReader(new FileReader(bemenet));
            String sor;
            while((sor=br.readLine()).equals("Start")){
                String parancs=sor.substring(0,3);

                if(parancs.equals("Csp")){
                    csomópontList.add(new Csomópont());
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
                        }
                    }

                } else if(parancs.equals("Ksn")) {
                    csomópontList.add(new KeresztezõSín());

                } else if(parancs.equals("All")) {
                    int db=4;
                    String szín;
                    boolean utas;

                    char[] temp = new char[20];
                    while(sor.charAt(db++) != ','){
                        temp[db-4]=sor.charAt(db);
                    }
                    szín=temp.toString();

                    if (sor.substring(db,db+1)=="1"){
                        utas=true;
                    } else {
                        utas=false;
                    }

                    csomópontList.add(new Állomás(szín, utas));

                } else if(parancs.equals("Mzd")) {

                } else if(parancs.equals("Snk")) {


                } else if(parancs.equals("Smk")) {

                } else {
                    System.out.println("Nem megfelelõ parancs.");
                }
            }



            while((sor=br.readLine())!=null){
                String parancs=sor.substring(0,3);
                String index = sor.substring(5,6);
                if(sor.equals("tick")){
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