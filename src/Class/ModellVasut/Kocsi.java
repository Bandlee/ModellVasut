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
		System.out.println("<<Kocsi::ellenõriz(String s)::boolean");
		return false;

	}

	/**
	 * A metódus meghívódik minden alkalommal, mikor az elõtte lévõ vonat elem átadja neki az órajelet
	 * Meghívja az elem mozgatásáért felelõs függvényt, és továbbadja a jelet a következõ vonat elemnek, ha létezik.
	 */
	public void tickAkció(){
		System.out.println(">>Kocsi órajelet kapott");
		mozgat();
		if(következõ != null) következõ.tickAkció();
	}

}