package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public class S�nElem {

	private VonatElem aktu�lisVonatElem;
	private S�nElem el�z�;
	private S�nElem k�vetkez�;
	private boolean l�that�;
	private Csom�pont s�nv�g1;
	private Csom�pont s�nv�g2;

	public S�nElem(){

	}

	public void finalize() throws Throwable {

	}

	public VonatElem get�thalad�Elem(){
		return null;
	}

	/**
	 * Tov�bb k�ldi az ir�ny�nak megfelel� csom�pontba a v param�terben kapott VonatElemet
	 * @param i A vonat ir�nya
	 * @param v A vonatelem, amelyet mozgatni akarunk
	 */
	public boolean keresztez(boolean i, VonatElem v){
		System.out.println("Vonat �rkezett, ir�ny�nak megfelel�en adjuk tov�bb a csom�pontnak.");
		if(i) {
			return s�nv�g1.tov�bb(v, this);
		} else {
			return s�nv�g2.tov�bb(v, this);
		}
	}

	/**
	 * 
	 * @param �e
	 */
	public void set�thalad�Elem(VonatElem �e){

	}

	public boolean �tk�z�sEl�rejelez(){
		return false;
	}

	public S�nElem getK�vetkez�() {
		return k�vetkez�;
	}

	public S�nElem getEl�z�() {
		return el�z�;
	}
}