package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */

import java.util.List;

/**
 * A váltót megvalósító osztály
 */
public class Váltó extends Csomópont {

	private SínElem aktív;
	private SínElem rögzített;

	/**
	 * A konstruktorban beállítjuk a lista elsõ elemét rögzítettnek, a másodikat aktívnak.
	 * A Váltót Csomópontként, annak konstruktorával hozzuk létre.
	 */
	public Váltó(){
		super();
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
}












