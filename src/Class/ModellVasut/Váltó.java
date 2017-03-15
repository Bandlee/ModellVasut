package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public class Váltó extends Csomópont {

	private int aktív;
	private SínElem rögzített;

	public Váltó(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void felhasználóAkció(){
		System.out.println("Váltás történik.");
	}

	/**
	 * 
	 * @param v
	 * @param s
	 */

	@Override
	public boolean tovább(VonatElem v, SínElem s){
		return false;
	}

}