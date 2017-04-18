package Class.ModellVasut;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:55
 */
public class Állomás extends Csomópont {

	private static int nemleszállt;
	private PályaGeneráló pg;
	private String szín;
	boolean felszálló;

	/**
	 * Konstruktor az Állomás osztály példányosításához
	 * @param szín az Állomás színe
	 * @param felszálló megadja, hogy az Állomáson várakoznak-e utasok felszállásra
	 * @param pg pályageneráló, amit az állomás értesít, ha sikeresen teljesül a szint
	 */
	public Állomás(String szín, boolean felszálló){
		this.szín = szín;
		this.felszálló = felszálló;
		this.pg = PályaGeneráló.getInstance();
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * A függvényt akkor hívjuk meg, amikor egy VonatElemrõl (SzemélyKocsiról) leszállás történt.
	 * Regisztráljuk a válozást, majd megnézzük, hogy van-e még utas a pályán lévö vonatokban.
	 * Amennyiben azok kiürültek, jelezzük hogy a pályát sikeresen teljesítettük.
	 *
	 * @param v: Az állomáson áthaladó VonatElemet jelöli.
	 */
	public boolean leszáll(VonatElem v){
		nemleszállt--;
		if (nemleszállt == 0) {
			pályaTeljesít();
		}
		return true;

	}

	/**
	 * A függvényt akkor hívjuk meg, amikor egy VonatElemre (SzemélyKocsira) felszálláss történt.
	 * Regisztráljuk a válozást, beállítjuk a felszálló értéket hamisra.
	 *
	 * @param v: Az állomáson áthaladó VonatElemet jelöli.
	 */
	public boolean felszáll(VonatElem v){
		felszálló = false;
		return true;
	}


	/**
	 * Játék sikeres teljesítése esetén meghívandó függvény.
	 * PályaGenerálóva betölteti az új pályát, és az elindítja a játékot.
	 */
	public void pályaTeljesít(){
		pg.kezdés();
	}

	/**
	 * Csomóponthoz hasonlóan továbbadja az áthaladó VonatElem-et a következõ SínElemre,
	 * ez után ellenözi, hogy szálltak-e le utasok az áthaladó VonatElemrõl, illetve,
	 * hogy szálltak-e fel rá. Történteket az Állomás a megfelelõ függvényeivel
	 * (leszáll/felszáll) regisztrálja magának. Visszatérési értéke azonos a Csomópont
	 * tovább függvényével.
	 *
	 * @param v: Az állomáson áthaladó VonatElemet jelöli.
	 * @param s: Azt a SínElemet jelöli, amirõl a v VonatElem érkezik.
	 *
	 */
	public boolean tovább(VonatElem v, SínElem s){

		boolean ret;

		ret = super.tovább(v, s);

		if ( v.ellenõriz(szín)) {
			leszáll(v);
		}

		if ( v.felEllenõriz(szín)) {
			felszáll(v);

		}



		return ret;
	}

	/**
	 * Az állomáshoz várakozó utasokat rendelünk.
	 */
	public void addUtas() {
		felszálló = true;
	}
}