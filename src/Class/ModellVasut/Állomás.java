package Class.ModellVasut;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Az állomásokat megvalósító osztály, a Csomópont leszármazottja.
 * Az állomáson utasok szállhatnak fel, illetve le a megfelelõ szabályok szerint
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:55
 */
public class Állomás extends Csomópont {

	private static int nemleszállt=0;
	private PályaGeneráló pg;
	private String szín;
	boolean felszálló;

	/**
	 * Konstruktor az Állomás osztály példányosításához
	 * @param szín az Állomás színe
	 * @param felszálló megadja, hogy az Állomáson várakoznak-e utasok felszállásra
	 * @param pg pályageneráló, amit az állomás értesít, ha sikeresen teljesül a szint
	 */
	public Állomás(String szín, boolean felszálló, int x, int y){
		super(x,y);
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
			return true;
		}


		return false;

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
	@Override
	public boolean tovább(VonatElem v, SínElem s){

		boolean ret;

		ret = super.tovább(v, s);

		if ( v.ellenõriz(szín)) {
			leszáll(v);
		}

		if (felszálló!=false && v.felEllenõriz(szín)) {
			felszáll(v);

		}

		return ret;
	}

	public static void setNemleszállt(int n){
	    nemleszállt = n;
    }


	@Override
	public void rajzol(Graphics g) {


		BufferedImage img;
		img = Ikonok.getIkon("Allomas_" + szín + (felszálló ? "_tele.png" : "_ures.png"));

		if (img == null) {
			//ha a kép nem lett beolvasva
			g.setColor(Color.MAGENTA);
			g.drawRect(x - 15, y - 15, 30, 30);
			return;
		}

		int w = (int) (img.getWidth() * Ikonok.getNagyításCsp());
		int h = (int) (img.getHeight() * Ikonok.getNagyításCsp());
		g.drawImage(img, x - w / 2, y - h / 2, w, h, null);


	}
}