package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public class Kocsi extends Class.ModellVasut.VonatElem {

	private Kocsi következõ;
	private boolean leszállhat;
	private String szín;
	private boolean utas;

	public Kocsi(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param s
	 */
	public boolean ellenõriz(String s){
		return false;
	}

	public void tickAkció(){

	}

}