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
	 * Tovább küldi az irányának megfelelõ csomópontba a v paraméterben kapott VonatElemet
	 * @param i A vonat iránya
	 * @param v A vonatelem, amelyet mozgatni akarunk
	 */
	public boolean keresztez(boolean i, VonatElem v){
		System.out.println("Vonat érkezett, irányának megfelelõen adjuk tovább a csomópontnak.");
		if(i) {
			return sínvég1.tovább(v, this);
		} else {
			return sínvég2.tovább(v, this);
		}
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

	public SínElem getKövetkezõ() {
		return következõ;
	}

	public SínElem getElõzõ() {
		return elõzõ;
	}
}