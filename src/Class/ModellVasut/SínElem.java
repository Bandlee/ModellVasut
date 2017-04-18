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
	 * A S�nElem oszt�ly konstruktora.
	 * @param l�th a S�nElem l�that�s�ga
	 * @param csp1 a S�nElemek alkotta s�n egyik v�gs� csom�pontja
	 * @param csp2 a S�nElemek alkotta s�n m�sik v�gs� csom�pontja
	 */
	public S�nElem( Csom�pont csp1, Csom�pont csp2, boolean l�th){
		System.out.println("�j S�nElem j�tt l�tre");
		l�that� = l�th;
		s�nv�g1 = csp1;
		s�nv�g2 = csp2;
		el�z� = null;
		k�vetkez� = null;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * a S�nElemet k�vet� S�nElem be�ll�t�sa
	 * @param se a S�nElemnek be�ll�tand� k�vetkez� S�nElem
	 */
	public void setK�vetkez�(S�nElem se){
		k�vetkez� = se;
		k�vetkez�.el�z� = this;
	}

	/**
	 * a S�nElemet megel�z� S�nElem be�ll�t�sa
	 * @param se a S�nElemnek be�ll�tand� el�z� S�nElem
	 */
	public void setEl�z�(S�nElem se){
		el�z� = se;
		el�z�.k�vetkez� = this;
	}

	/**
	 * visszat�r az aktu�lisan a s�nelemen tart�zkod� vonatelemmel
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
				return s�nv�g2.tov�bb(v,this);
			}
		} else {
			if(this.el�z� ==null){
				return s�nv�g1.tov�bb(v,this);
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
	 * @return megmutatja, hogy fenn�ll e az �tk�z�snek a lehet�s�ge
	 */
	public boolean �tk�z�sEl�rejelez(){
		VonatElem el�ttem = null;
		if(el�z�==null) el�ttem = null;
		else el�ttem = el�z�.get�thalad�Elem();
		VonatElem m�g�ttem = null;
		if(k�vetkez�==null) m�g�ttem = null;
		else m�g�ttem = k�vetkez�.get�thalad�Elem();
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

	/**
	 * a S�nElem l�that�s�g�t mutatja meg
	 * @return a S�nElem l�that� attrib�tuma
	 */
	public boolean getL�that�(){ return l�that�; }

	/**
	 * visszaadja a S�nElemek alkotta s�n egyik v�gpontj�t
	 * @return a S�nElem s�nv�g1 attrib�tum�val
	 */
	public Csom�pont getS�nv�g1() { return s�nv�g1; }

	/**
	 * visszaadja a S�nElemek alkotta s�n m�sik v�gpontj�t
	 * @return a S�nElem s�nv�g2 attrib�tum�val
	 */
	public Csom�pont getS�nv�g2() { return s�nv�g2; }


}