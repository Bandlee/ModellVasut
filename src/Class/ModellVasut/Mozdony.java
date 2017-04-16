package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public class Mozdony extends VonatElem {

	private Csomópont belépésipont;
	private int késleltetés;

	/**
	 * jelenleg csak a tesztesethez állítunk be egy kezdõértéket
	 * az éles programban nem így fog kinézni
	 */
	public Mozdony(){
		késleltetés = 10;
	}

	public Mozdony(int k, Csomópont b){
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

}