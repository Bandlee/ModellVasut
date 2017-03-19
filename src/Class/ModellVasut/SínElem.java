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
		s�nv�g1 = new Csom�pont();
		s�nv�g2 = new Csom�pont();
	}

	public void finalize() throws Throwable {

	}

	public void setK�vetkez�(){
		k�vetkez� = new S�nElem();
	}

	public VonatElem get�thalad�Elem(){
		System.out.println("<<S�nElem::get�thalad�Elem()::boolean");
		return new Kocsi();
	}

	/**
	 * Tov�bb k�ldi az ir�ny�nak megfelel� csom�pontba a v param�terben kapott VonatElemet
	 * @param i A vonat ir�nya
	 * @param v A vonatelem, amelyet mozgatni akarunk
	 */
	public boolean keresztez(boolean i, VonatElem v){
		System.out.println(">>S�nElem::keresztez(i,v)");
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
		System.out.println(">>S�nElem::�tk�z�stEl�rejelez()");
		el�z� = new S�nElem();
		k�vetkez� = new S�nElem();

		System.out.println(">>S�nElem::get�thalad�Elem()");
		el�z�.get�thalad�Elem();
		System.out.println(">>S�nElem::get�thalad�Elem()");
		k�vetkez�.get�thalad�Elem();
		System.out.println("<<S�nElem::�tk�z�stEl�rejelez()::boolean");
		return false;
	}

	public S�nElem getK�vetkez�() {
		return k�vetkez�;
	}

	public S�nElem getEl�z�() {
		return el�z�;
	}
}