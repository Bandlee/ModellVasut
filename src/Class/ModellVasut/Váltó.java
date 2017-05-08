package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * A váltót megvalósító osztály
 */
public class Váltó extends Csomópont implements IKattintható {

	private SínElem aktív;
	private SínElem rögzített;

	/**
	 * A konstruktorban beállítjuk a lista elsõ elemét rögzítettnek, a másodikat aktívnak.
	 * A Váltót Csomópontként, annak konstruktorával hozzuk létre.
	 */
	public Váltó(int x, int y){
		super(x, y);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * a felhasználó váltását kezelõ függvény.
	 * Az aktív végét a váltónak a sorban következõ
	 * (vagy az utolsót követve az elsõ) SínElemre változtatja.
	 */
	public void felhasználóAkció(){


		if (aktív.getÁthaladóElem() == null || rögzített.getÁthaladóElem() == null) {
			/** egy változó segítségével lépünk az elemek között*/
			int i = befutóSínek.indexOf(aktív);
			/** léptetjük a változónkat*/
			i++;
			/** ha túlléptünk a listán, elõrõl kezdjük (1-tõl, mivel a 0. a rögzített) */
			if (i >= befutóSínek.size())
				i = 1;
			/** ha léptetés után nem az aktívon állunk, akkor lecseréljük azt az aktuálisra */
			/** ha léptetés után is az aktív az aktuális, akkor nem változtatunk semmmit */
			if (befutóSínek.get(i) != aktív)
				aktív = befutóSínek.get(i);
		}
	}

	/**
	 * A váltóba érkezõ vonatot továbbítja a megfelelõ kimenetre
	 * visszatérési értéke attól függ, hogy sikerül-e beállítani a a megfelelõ
	 * változtatásokat.
	 *
	 * @param v a továbbítandó vonatelem
	 * @param s megmutatja, honnan is érkezett a vonatelem
	 */
	public boolean tovább(VonatElem v, SínElem s){
		try{
			SínElem hova = null;

			if(s == rögzített){
				hova = aktív;
			} else if(s == aktív){
				hova = rögzített;
			}
			if(hova == null){
				return false;
			} else{
				v.setPozíció(hova);
				if(hova.getSínvég1()==this) v.setIrány(true); else v.setIrány(false);
				return true;
			}
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * a váltóba befutó sínelekehez való hozzáadás.
	 * speciális szerepe miatt a váltóban különlegesebben mûködik, mint egy sima csomópontban
	 * @param s a hozzáadandó SínElem
	 */
	@Override
    public void setBefutóSín(SínElem s){
	    if (befutóSínek.size()==0){
	        befutóSínek.add(s);
	        rögzített=s;
        } else if(befutóSínek.size()==1){
            befutóSínek.add(s);
            aktív=s;
        } else {
            befutóSínek.add(s);
        }
    }

	/**
	 * Beállítja a váltó aktív kimenetét a paraméterben átadottra.
	 * @param s a beállítandó SínElem
	 */

	public void setAktív(SínElem s){aktív = s;}

	/**
	 * Visszatér a váltó aktív kimenetével
	 * @return az aktív SínElem
	 */
	public SínElem getAktív(){return aktív;}

	/**
	 * Beállítja a váltó rögzített kimenetét a paraméterben átadottra.
	 * @param s a beállítandó SínElem
	 */
	public void setRögzített(SínElem s){rögzített = s;}

	/**
	 * Visszaadja a váltó rögzített kimenetét
	 * @return  a visszaadott SínElem
	 */
	public SínElem getRögzített(){return rögzített;}


	/**
	 * Függvény megnézi, hogy a kattintás a váltonál történt-e,
	 * ha igen, akkor pedig végrehajtja a felhasznlóAkciót.
	 * @param e kattintást leíró érték
	 * @return kattintás okozott-e változást
	 */
	@Override
	public boolean voltKattintva(MouseEvent e) {

		/** r sugarú körön belül vizsgálunk */
		int r = (int) (50*Ikonok.getNagyításCsp());

		if(Math.sqrt((x-e.getX())*(x-e.getX())+(y-e.getY())*(y-e.getY())) < r) {
			felhasználóAkció();
			return true;
		}
		return false;
	}


	/**
	 * Váltó kirajzolása a képernyõre.
	 * A váltót ugyan úgy jelenik meg, mint a csomópont,a zzal a kiegészítéssel,
	 * hogy be vannak színezve az összekötött sínelemek.
	 * @param g Graphic objektum amivel kirajzolunk a képernyõre.
	 */
	@Override
	public void rajzol(Graphics g) {

		/** Csomópont kirajzolás */
		super.rajzol(g);

		int w = (int) (30 * Ikonok.getNagyításVe());
		int h = (int) (30 * Ikonok.getNagyításVe());

		/** aktív SínElemek jelölése a képernyõn*/
		g.setColor(Color.blue);
		g.fillOval(rögzített.getX()-w/2,rögzített.getY()-h/2,w,h);
		g.setColor(Color.green);
		g.fillOval(aktív.getX()-w/2,aktív.getY()-h/2,w,h);
	}
}












