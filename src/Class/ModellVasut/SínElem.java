package Class.ModellVasut;


import java.util.ArrayList;
import java.util.List;

/**
 * A S�nElemeket megval�s�t� oszt�ly. Feladataihoz tartozik az �tk�z�sdetekt�l�s �s a vonatelemtov�bb�t�s is.
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public class S�nElem extends Hely {

	private VonatElem aktu�lisVonatElem;
	private S�nElem el�z�;
	private S�nElem k�vetkez�;
	private boolean l�that�;
	private Csom�pont s�nv�g1;
	private Csom�pont s�nv�g2;

	/**
	 * A S�nElem oszt�ly konstruktora.
	 * Bel�p�s seg�t�s�hez l�trehozott konstruktor
	 * @param csp1 a S�nElemek alkotta s�n egyik v�gs� csom�pontja
	 * @param csp2 a S�nElemek alkotta s�n m�sik v�gs� csom�pontja
	 */
	public S�nElem( Csom�pont csp1, Csom�pont csp2){
		super(0,0);
		l�that� = false;
		s�nv�g1 = csp1;
		s�nv�g2 = csp2;
		el�z� = null;
		k�vetkez� = null;
	}


	/**
	 * A S�nElem oszt�ly konstruktora.
	 * @param l�th a S�nElem l�that�s�ga
	 * @param csp1 a S�nElemek alkotta s�n egyik v�gs� csom�pontja
	 * @param csp2 a S�nElemek alkotta s�n m�sik v�gs� csom�pontja
	 */
	public S�nElem( Csom�pont csp1, Csom�pont csp2, boolean l�th, int x, int y){
		super(x,y);
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
        VonatElem m�g�ttem=null;
	    if(el�z�!=null){
            if(el�z�.get�thalad�Elem()!=null){
                m�g�ttem=el�z�.get�thalad�Elem();
            }
        }

        VonatElem el�ttem=null;
        if(k�vetkez�!=null){
            if(k�vetkez�.get�thalad�Elem()!=null){
                el�ttem=k�vetkez�.get�thalad�Elem();
            }
        }

        if(el�ttem!=null){
            if(el�ttem.getIr�ny()!=aktu�lisVonatElem.getIr�ny()) return false;
        }

        if(m�g�ttem!=null){
            if(m�g�ttem.getIr�ny()!=aktu�lisVonatElem.getIr�ny()) return false;
        }

        return true;
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


	public static List<S�nElem> �sszek�t(Csom�pont cs1, Csom�pont cs2, boolean l�th){

		/**t�vols�g s�nelemek k�z�tt*/
		int t�v = 40;

		int x_dist = (cs2.getX()-cs1.getX());
		int y_dist = (cs2.getY()-cs1.getY());


		/** 2 csom�pont k�zti szakasz hossza*/
		int szh = (int) Math.sqrt(x_dist*x_dist + y_dist*y_dist);

		/** h�ny s�nelem f�r a k�t csom�pont k�z�, (az utols� a csom�pontba lenne, vagy nagyon k�zel) */
		int sedb = szh /t�v ;


		double x_szorz = x_dist/(double)szh;
		double y_szorz = y_dist/(double)szh;
		List<S�nElem> temp_se =new ArrayList<>();

		/** pont a k�t csom�pont k�z� ker�lj�n, ha kev�s a hely */
		if (sedb < 1) {
			int _x = (int) (cs1.getX() + Math.round(szh/2 * x_szorz));
			int _y = (int) (cs1.getY() + Math.round(szh/2 * y_szorz));
			temp_se.add(new S�nElem(cs1, cs2, l�th, _x, _y));

		}

		else {

			for (int i = 1; i <= sedb; i++) {

				int _x = (int) (cs1.getX() + Math.round(i * t�v * x_szorz));
				int _y = (int) (cs1.getY() + Math.round(i * t�v * y_szorz));
				temp_se.add(new S�nElem(cs1, cs2, l�th, _x, _y));
			}
			for (int i = 0; i < temp_se.size() - 1; i++) {
				temp_se.get(i).setK�vetkez�(temp_se.get(i + 1));
			}
		}

		cs1.setBefut�S�n(temp_se.get(0));
		cs2.setBefut�S�n(temp_se.get(temp_se.size()-1));

		return temp_se;
	}







}