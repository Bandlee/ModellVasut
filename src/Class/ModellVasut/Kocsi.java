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
	 * A metódus megadja, hogy adott színû állomás mellett elhaladva szállnak-e le a kocsiról utasok.
	 * Amennyiben igen, ezt jelzi az utas tulajdonság beállításával, valamit engedélyezi az utána következõ
	 * kocsinak a leszállást (ez a szkeletonban nincs megvalósítva, a végsõ programban lesz szerepe).
	 *
	 * @param s: Az állomás színét jelöli a paraméter, ez alapján fogjuk a végsõ programban eldönteni,
	 *           hogy szállnak-e le az adott kocsiról a megadott színû állomáson.
	 */
	@Override
	public boolean ellenõriz(String s){

		/**
		 * Szkeletonban nem szín egyezeés és leszállási engedély alapján történik annak megállapítása hogy szálltak-e le utasok.
		 * Ez nyilvánvalóan másképp lesz megvalósítva a végsõ programban.
		 */
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

	/**
	 * A metódus meghívódik minden alkalommal, mikor az elõtte lévõ vonat elem átadja neki az órajelet
	 * Meghívja az elem mozgatásáért felelõs függvényt, és továbbadja a jelet a következõ vonat elemnek, ha létezik.
	 */
	public void tickAkció(){
		System.out.println("Kocsi órajelet kapott");
		mozgat();
		if(következõ != null) következõ.tickAkció();
	}

}