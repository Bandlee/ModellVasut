package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */

/** A játék végét megvalósító osztály */
public class JátékVége {

	public JátékVége(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * játék végét jelentõ függvény
	 * ezesetben a felhasználó vesztett, ezt fogja majd kezelni
	 */
	public void vég(){
		System.out.println(">>JátékVége::vég()");
	}

}