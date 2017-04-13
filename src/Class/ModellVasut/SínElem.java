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
	public S�nElem( VonatElem v, S�nElem el, S�nElem k�v, boolean l�th, Csom�pont csp1, Csom�pont csp2){
		aktu�lisVonatElem = v;
		el�z� = el;
		k�vetkez� = k�v;
		l�that� = l�th;
		s�nv�g1 = csp1;
		s�nv�g2 = csp2;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * seg�df�ggv�ny a tesztesetekhez
	 * alapb�l a konstruktor jelenleg null�zza a k�vetkez� s�nelemre mutat� referenci�t, mivel ha �jat hozn�k l�tre, v�gtelen ciklusba ker�lne
	 * viszont bizonyos esetekben sz�ks�g van arra, hogy legyen be�ll�tva k�vetez� s�nelem, ezt kezeli ez a f�ggv�ny
	 * a rendes m�k�d�s k�zben erre nem lesz ilyen form�ban sz�ks�g
	 */
	public void setK�vetkez�(S�nElem se){
		k�vetkez� = se;
		k�vetkez�.el�z� = this;
	}

	/**
	 * visszat�r az aktu�lisan a s�nelemen tart�zkod� vonatelemmel
	 * jelenleg mivel nincsenek el�re fel�p�tett objektumaink, itt hoz l�tre egy elemet, amit visszaad, de ez a rendes k�dban nem �gy fog majd kin�zni
	 * @return a s�nelemen tart�zkod� vonatelem
	 */
	public VonatElem get�thalad�Elem(){
		return aktu�lisVonatElem;
	}

	/**
	 * Tov�bb k�ldi az ir�ny�nak megfelel� csom�pontba a v param�terben kapott VonatElemet
	 * @param i A vonat ir�nya
	 * @param v A vonatelem, amelyet mozgatni akarunk
	 */
	public boolean keresztez(boolean i, VonatElem v){
		if(i) {
			if(this.k�vetkez�==null){
				return s�nv�g1.tov�bb(aktu�lisVonatElem,this);
			}
		} else {
			if(this.el�z� ==null){
				return s�nv�g2.tov�bb(aktu�lisVonatElem,this);
			}
		}
		return false;
	}

	/**
	 * be�ll�tja  a s�nelemen �thalad� vonatelemet
	 * @param �e a be�ll�tott param�ter
	 */
	public void set�thalad�Elem(VonatElem �e){
		aktu�lisVonatElem = �e;
	}

	/**
	 * a f�ggv�ny kezeli azt az eset�t a vonat�tk�z�snek, mikor egym�ssal k�t szemben�ll� mozdony "�tugran� egym�st"
	 *
	 * jelenlegi visszat�r�si �rt�ke a tesztesetek m�k�d�s�t szolg�lja, az �les programban nem �gy lesz meghat�rozva
	 * @return megmutatja, hogy fenn�ll e az �tk�z�snek a lehet�s�ge
	 */
	public boolean �tk�z�sEl�rejelez(){

		VonatElem el�ttem = el�z�.get�thalad�Elem();
		VonatElem m�g�ttem = k�vetkez�.get�thalad�Elem();
		if(el�ttem!=null && el�ttem.getIr�ny()!=aktu�lisVonatElem.getIr�ny()){
			return false;
		} else if(m�g�ttem != null && m�g�ttem.getIr�ny()!= aktu�lisVonatElem.getIr�ny()){
			return false;
		} else return true;

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

	public boolean getL�that�(){ return l�that�; }

	public Csom�pont getS�nv�g1() { return s�nv�g1; }

	public Csom�pont getS�nv�g2() { return s�nv�g2; }
}