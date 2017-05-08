package Class.ModellVasut;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A mozdonyokat megval�s�t� oszt�ly. A vonatelem lesz�rmazottja
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public class Mozdony extends VonatElem {

	private Csom�pont bel�p�sipont;
	private int k�sleltet�s;

	/**
	 * Mozdony oszt�ly konstruktora
	 * @param b a mozdony bel�p�si pontja
	 * @param k a mozdony k�sleltet�se
	 */
	public Mozdony(Csom�pont b, int k){
		k�sleltet�s = k;
		bel�p�sipont = b;
		ir�ny = true;
		/**l�thatatlan S�nElem amir�l tov�bb l�p a bel�p�si pontba, ha elindulhat*/
		setPoz�ci�(new S�nElem(b));
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * K�zvetlen�l a j�t�k lefoly�s�t kezel� oszt�lyb�l h�v�dik. Megh�vja a vonat mozgat�s��rt felel�s f�ggv�nyt, ha
	 * annak m�r a p�ly�n kellene lennie (k�sleltet�s == 0), k�l�nben cs�kkenti a k�sleltet�st
	 */
	public void tickAkci�()throws VegException{
		if(k�sleltet�s == 0) {
			mozgat();
			if(k�vetkez� != null) k�vetkez�.tickAkci�();
		} else {
			k�sleltet�s--;
		}
	}


	/**
	 * Hozz�k�ti a mozdonyhoz a megadott kocsit, ez fog ut�na k�vetkezni.
	 *
	 * @param k�vetkez� a kocsi, ami a mozdonyhoz lesz k�tve.
	 */
	@Override
	public void setK�vetkez�(Kocsi k�vetkez�) {
		this.k�vetkez� = k�vetkez�;
	}

	/**
	 * Visszaadja a mozdony k�sleltet�s�t.
	 * @return k�sleltet�s
	 */
	public int getK�sleltet�s(){return k�sleltet�s;}

	/**
	 * Visszaadja a mozdony bel�p�si pontj�t
	 * @return bel�p�si pont
	 */
	public Csom�pont getBel�p�siPont(){
		return bel�p�sipont;
	}

	/**
	 * Mozdony kirajzol�sa a k�perny�re
	 * @param g Graphic objektum amivel kirajzolunk a k�perny�re.
	 */
	@Override
	public void rajzol(Graphics g) {

		/** kirajzol�s csak ha l�that� S�nElemen tartozkodik*/
		if (tart�zkod�siHely!=null && tart�zkod�siHely.getL�that�()) {
			BufferedImage img;
			/** ir�ny szerint k�pv�laszt�s*/
			if (ir�ny) img = Ikonok.getIkon("Mozdony_jobb.png");
			else img = Ikonok.getIkon("Mozdony_bal.png");

			/** m�retez�s */
			int w = (int) (img.getWidth() * Ikonok.getNagy�t�sVe());
			int h = (int) (img.getWidth() * Ikonok.getNagy�t�sVe());

			/** kirajzol�s k�z�pre igaz�tva, az sz�molt m�retekkel*/
			g.drawImage(img, tart�zkod�siHely.getX() - w / 2, tart�zkod�siHely.getY() - h / 2, w, h, null);
		}

	}

}