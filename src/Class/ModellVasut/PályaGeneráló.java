package Class.ModellVasut;


import java.io.*;

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
					System.out.println("Nem megfelel� parancs.");
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
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

	}

}