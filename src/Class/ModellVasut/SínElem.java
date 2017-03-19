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

	/**
	 * s�nelem konstruktor
	 * jelenleg csak a tesztesetekhez sz�ks�ges elemeket hozza l�tre
	 */
	public S�nElem(){
		s�nv�g1 = new Csom�pont();
		s�nv�g2 = new Csom�pont();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * seg�df�ggv�ny a tesztesetekhez
	 * alapb�l a konstruktor jelenleg null�zza a k�vetkez� s�nelemre mutat� referenci�t, mivel ha �jat hozn�k l�tre, v�gtelen ciklusba ker�lne
	 * viszont bizonyos esetekben sz�ks�g van arra, hogy legyen be�ll�tva k�vetez� s�nelem, ezt kezeli ez a f�ggv�ny
	 * a rendes m�k�d�s k�zben erre nem lesz ilyen form�ban sz�ks�g
	 */
	public void setK�vetkez�(){
		k�vetkez� = new S�nElem();
	}

	/**
	 * visszat�r az aktu�lisan a s�nelemen tart�zkod� vonatelemmel
	 * jelenleg mivel nincsenek el�re fel�p�tett objektumaink, itt hoz l�tre egy elemet, amit visszaad, de ez a rendes k�dban nem �gy fog majd kin�zni
	 * @return a s�nelemen tart�zkod� vonatelem
	 */
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
	 * be�ll�tja  a s�nelemen �thalad� vonatelemet
	 * @param �e a be�ll�tott param�ter
	 */
	public void set�thalad�Elem(VonatElem �e){

	}

	/**
	 * a f�ggv�ny kezeli azt az eset�t a vonat�tk�z�snek, mikor egym�ssal k�t szemben�ll� mozdony "�tugran� egym�st"
	 *
	 * jelenlegi visszat�r�si �rt�ke a tesztesetek m�k�d�s�t szolg�lja, az �les programban nem �gy lesz meghat�rozva
	 * @return megmutatja, hogy fenn�ll e az �tk�z�snek a lehet�s�ge
	 */
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

	/**
	 * a s�nelemhez kapcsol�d�, k�vetkez� elemet adja vissza
	 * @return a keresett elem
	 */
	public S�nElem getK�vetkez�() {
		return k�vetkez�;
	}
	/**
	 * a s�nelemhez kapcsol�d�, el�z� elemet adja vissza
	 * @return a keresett elem
	 */
	public S�nElem getEl�z�() {
		return el�z�;
	}
}