package Class.ModellVasut;


import java.io.*;

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
		try {
			br=new BufferedReader(new FileReader(bemenet));
			String sor;
			while((sor=br.readLine()).equals("Start")){
				char[] temp = null;
				for (int i = 0; i < 3; i++) temp[i] = sor.charAt(i);
				String parancs= temp.toString();
				if(parancs.equals("Csp")){

				} else if(parancs.equals("Vlt")) {

				} else if(parancs.equals("Als")) {

				} else if(parancs.equals("Sel")) {

				} else if(parancs.equals("Ksn")) {

				} else if(parancs.equals("All")) {

				} else if(parancs.equals("Mzd")) {

				} else if(parancs.equals("Snk")) {

				} else if(parancs.equals("Smk")) {

				} else {
					System.out.println("Nem megfelelõ parancs.");
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