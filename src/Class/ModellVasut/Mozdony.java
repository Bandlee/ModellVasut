package Class.ModellVasut;


/**
 * A mozdonyokat megvalósító osztály. A vonatelem leszármazottja
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public class Mozdony extends VonatElem {

	private Csomópont belépésipont;
	private int késleltetés;

	/**
	 * Mozdony osztály konstruktora
	 * @param b a mozdony belépési pontja
	 * @param k a mozdony késleltetése
	 */
	public Mozdony(Csomópont b, int k){
		késleltetés = k;
		belépésipont = b;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * Közvetlenül a játék lefolyását kezelõ osztályból hívódik. Meghívja a vonat mozgatásáért felelõs függvényt, ha
	 * annak már a pályán kellene lennie (késleltetés == 0), különben csökkenti a késleltetést
	 */
	public void tickAkció(){
		if(késleltetés == 0) {
			mozgat();
			if(következõ != null) következõ.tickAkció();
		} else {
			késleltetés--;
		}
	}


	/**
	 * Hozzáköti a mozdonyhoz a megadott kocsit, ez fog utána következni.
	 *
	 * @param következõ a kocsi, ami a mozdonyhoz lesz kötve.
	 */
	@Override
	public void setKövetkezõ(Kocsi következõ) {
		this.következõ = következõ;
	}

	/**
	 * Visszaadja a mozdony késleltetését.
	 * @return késleltetés
	 */
	public int getKésleltetés(){return késleltetés;}

	/**
	 * Visszaadja a mozdony belépési pontját
	 * @return belépési pont
	 */
	public Csomópont getBelépésiPont(){
		return belépésipont;
	}
}