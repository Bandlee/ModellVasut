package Class.ModellVasut;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:55
 */
public class Állomás extends Csomópont {

	private static int nemleszállt;
	private PályaGeneráló pg;
	private String szín;
	public PályaGeneráló m_PályaGeneráló;

	public Állomás(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * A függvényt akkor hívjuk meg, amikor egy VonatElemrõl (Kocsiról) leszállás történt.
	 * Regisztráljuk a válozást, majd megnézzük, hogy van-e még utas a pályán lévö vonatokban.
	 * Amennyiben azok kiürültek, jelezzük hogy a pályát sikeresen teljesítettük.
	 *
	 * @param v: Az állomáson áthaladó VonatElemet jelöli.
	 */
	public boolean leszáll(VonatElem v){

		System.out.println("Kiürültek a vonatok?(i/n)");
		BufferedReader be= new BufferedReader(new InputStreamReader(System.in));
		String üres;
		try {
			üres=be.readLine();
			if (üres.equals("i")) {

				/** Nincs több utas, pálya sikeresen teljesítve*/

				System.out.println(">>Állomás::pályaTeljesít()");
				pályaTeljesít();
			}

			else if (üres.equals("n")) {

				/** Van még utas a pályán lévõ vonatokban, nem ér véget a pálya */
				System.out.println("A játék folytatódik");
			}

			else {
				System.out.println("Nem megfelelõ válasz.");
			}

		} catch(IOException e) {e.getMessage();}

		return true;
	}

	/**
	 * Játék sikeres teljesítése esetén meghívabdó függvény.
	 * PályaGenerálóva betölteti az új pályát, és az elindítja a játékot.
	 */
	public void pályaTeljesít(){
		/** Következõ pálya indítása*/
		System.out.println(">>PályaGeneráló::kezdés()");
		m_PályaGeneráló = new PályaGeneráló();
		m_PályaGeneráló.kezdés();
		System.out.println("Következõ pálya betöltve");
	}

	/**
	 * Csomóponthoz hasonlóan továbbadja az áthaladó VonatElem-et a következõ SínElemre,
	 * ez után ellenözi, hogy szálltak a le utasok az áthaladó VonatElemrõl.
	 *
	 * @param v: Az állomáson áthaladó VonatElemet jelöli.
	 * @param s: Azt a SínElemet jelöli, amirõl a v VonatElem érkezik.
	 *
	 */
	public boolean tovább(VonatElem v, SínElem s){

		/** visszatérési érték */
		boolean ret;

		/** Csomóponttal azonosan mûködõ továbbadás */
		ret = super.tovább(v, s);

		/** Szkeleton függvényhivásának pontos követésére létrehozott rész*/
		if (v.getClass() == Kocsi.class) {
			System.out.println(">>Kocsi::ellenõriz(String s)");
		}
		else {
			System.out.println(">>VonatElem::ellenõriz(String s)");
		}

		/** Történt-e leszállás - ellenörzés*/
		if ( v.ellenõriz(szín)) {

			/** Történt leszállás*/
			System.out.println(">>Állomás::leszáll()");
			leszáll(v);
		}
		System.out.println("<<Állomás::tovább(VonatElem v, SínElem s)::boolean");
		return ret;
	}

}