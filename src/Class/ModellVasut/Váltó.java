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

	private int aktív;
	private SínElem rögzített;

	public Váltó(int x, int y, List<SínElem> se){
		super(x, y, se);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * a felhasználó váltását kezelõ függvény
	 */
	public void felhasználóAkció(){
		System.out.println(">>Váltó::vált()");
		this.vált();

	}

	private void vált(){

	}
}