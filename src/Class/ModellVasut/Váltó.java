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
	public Váltó(int a, int b, List<SínElem> list){
		super(a, b, list);
		rögzített = list.get(0);
		aktív = list.get(1);
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
		//egy változó segítségével lépünk az elemek között
		int i = befutóSínek.indexOf(aktív);
		// léptetjük a változónkat
		i++;
		// ha túlléptünk a listán, elõrõl kezdjük (1-tõl, mivel a 0. a rögzített)
		if (i >= befutóSínek.size())
			i = 1;
		// ha léptetés után nem az aktívon állunk, akkor lecseréljük azt az aktuálisra
		// ha léptetés után is az aktív az aktuális, akkor nem változtatunk semmit
		if (befutóSínek.get(i) != aktív)
			aktív = befutóSínek.get(i);
	}

}












