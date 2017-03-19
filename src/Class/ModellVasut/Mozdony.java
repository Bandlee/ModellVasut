package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public class Mozdony extends VonatElem {

	private Csomópont belépésipont;
	private Kocsi elsõ;
	private int késleltetés;
	public Csomópont m_Csomópont;
	public Kocsi m_Kocsi;

	public Mozdony(){
		késleltetés = 10;
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
			elsõ.tickAkció();
		} else {
			késleltetés--;
		}
	}

}