package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public class SínElem {

	private VonatElem aktuálisVonatElem;
	private SínElem elõzõ;
	private SínElem következõ;
	private boolean látható;
	private Csomópont sínvég1;
	private Csomópont sínvég2;

	public SínElem(){

	}

	public void finalize() throws Throwable {

	}

	public VonatElem getÁthaladóElem(){
		return null;
	}

	/**
	 * 
	 * @param i
	 * @param v
	 */
	public boolean keresztez(boolean i, VonatElem v){
		return false;
	}

	/**
	 * 
	 * @param áe
	 */
	public void setÁthaladóElem(VonatElem áe){

	}

	public boolean ütközésElõrejelez(){
		return false;
	}

}