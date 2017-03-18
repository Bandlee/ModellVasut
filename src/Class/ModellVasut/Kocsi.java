package Class.ModellVasut;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public class Kocsi extends VonatElem {

	private Kocsi következõ;
	private boolean leszállhat;
	private String szín;
	private boolean utas;

	public Kocsi(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 *
	 * @param s: Az állomás színét jelöli a paraméter, ez alapján fogjuk a végsõ programban eldönteni,
	 *           hogy szállnak-e le az adott kocsiról a megadott színû állomáson.
	 */
	@Override
	public boolean ellenõriz(String s){

		System.out.println("Szállnak le utasok a kocsiról?(i/n)");
		BufferedReader be= new BufferedReader(new InputStreamReader(System.in));
		String leszállnak;
		boolean leszálltak = false;
		try {
			leszállnak=be.readLine();
			if (leszállnak.equals("i"))
				leszálltak = true;

			else if ( !leszállnak.equals("n") )
				System.out.println("Nem megfelelõ válasz.");

		} catch(IOException e) {e.getMessage();}


		System.out.println("<<Kocsi::ellenõriz(String s)::boolean");
		return leszálltak;

	}

	public void tickAkció(){

	}

}