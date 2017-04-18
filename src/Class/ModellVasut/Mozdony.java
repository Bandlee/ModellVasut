package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public class Mozdony extends VonatElem {

	private Csomópont belépésipont;
	private int késleltetés;

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
		System.out.println("Mozdony órajelet kapott");
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

}