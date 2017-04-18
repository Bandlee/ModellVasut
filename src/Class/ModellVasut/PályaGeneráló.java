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
		bemenet = new File("tesztbe" + String.valueOf(szint));
		BufferedReader br = null;
		List<Csomópont> csomópontList= new ArrayList<>();
		List<Mozdony> mozdonyList = new ArrayList<>();
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
					int csp2=Integer.parseInt(sor.substring(6,7));
					int db=Integer.parseInt(sor.substring(8,9));

					List<SínElem> temp_se =new ArrayList<>();
					for(int i=0;i<db;i++)
						temp_se.add(new SínElem(csp1, csp2, true));
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

			Idõzítõ idõ = new Idõzítõ(mozdonyList);

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

	}

}