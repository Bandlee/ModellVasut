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
	 * Bel�p�s seg�t�s�hez l�trehozott konstruktor, nem kell minden ir�nyban j�rhat�nak lennie
	 * (csak true ir�nyba j�rhat�)
	 * @param csp Belp�si pont
	 */
	public S�nElem( Csom�pont csp){
		super(0,0);
		l�that� = false;
		s�nv�g1 = null;
		s�nv�g2 = csp;
		el�z� = null;
		k�vetkez� = null;
	}

	/**
	 * Bel�p�s seg�t�s�hez l�trehozott konstruktor, nem kell minden ir�nyban j�rhat�nak lennie
	 * (csak true ir�nyba j�rhat�)
	 * @param se a S�nElemek ami m�g� leteszz�k a k�vetkez�t
	 */
	public S�nElem( S�nElem se){
		super(0,0);
		l�that� = false;
		s�nv�g1 = null;
		s�nv�g2 = se.s�nv�g2;
		el�z� = null;
		k�vetkez� = se;

	}

	/**
	 * A S�nElem oszt�ly konstruktora.
	 * L�trehoz egy s�nelemet az adott l�that�s�ggal,
	 * ami a k�t megadott csom�pont k�z�tt tal�lhat�, x,y helyen.
	 * @param csp1 a S�nElemek alkotta s�n egyik v�gs� csom�pontja
	 * @param csp2 a S�nElemek alkotta s�n m�sik v�gs� csom�pontja
	 * @param l�th a S�nElem l�that�s�ga
	 * @param x a S�nElem x koordin�t�ja
	 * @param y a S�nElem y koordin�t�ja
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

	/**
	 * K�t csom�pont k�z�tt l�trehoz egym�st�l egyenl� t�vols�gra l�v�
	 * S�nElemekb�l �ll� egybef�gg� s�nt. cs1-b�l cs2-be vezet a true ir�ny.
	 * @param cs1 s�n egyik v�ge
	 * @param cs2 s�n m�sik v�ge
	 * @param l�th l�trehozand� s�nelemek l�that�s�ga
	 * @return l�trehozott s�nelemek list�ja
	 */
	public static List<S�nElem> �sszek�t(Csom�pont cs1, Csom�pont cs2, boolean l�th){

		/**t�vols�g s�nelemek k�z�tt*/
		double t�v = 40*Ikonok.getNagy�t�sVe();

		int x_dist = (cs2.getX()-cs1.getX());
		int y_dist = (cs2.getY()-cs1.getY());


		/** A k�t csom�pont k�zti szakasz hossza*/
		double szh =  Math.sqrt(x_dist*x_dist + y_dist*y_dist);

		/** H�ny darab s�nelem rakhat� le a k�t csom�pont k�z�tt (eg�sz db)*/
		int sedb = (int) ((szh/t�v));

		/** t�v illeszt�se a darabsz�mhoz*/
		t�v = szh/sedb;

		double x_szorz = x_dist/(double)szh;
		double y_szorz = y_dist/(double)szh;

		List<S�nElem> temp_se =new ArrayList<>();


		/** 1. s�nelem elhelyez�se a csom�pontt�l f�l t�vnyira, �gy
		 * az utols� is f�l t�vnyira lesz a hozz� k�zel es� csom�ponthoz
		 */
		double _x = cs1.getX() +0.5* t�v * x_szorz;
		double _y = cs1.getY() + 0.5* t�v * y_szorz;
		temp_se.add(new S�nElem(cs1, cs2, l�th,(int)Math.round(_x),(int) Math.round(_y)));

		/** s�nelemek l�trehoz�sa egym�s ut�n, szomsz�dok k�z�tt t�v t�vols�ggal */
		for (int i = 1; i < sedb; i++) {
			_x += t�v * x_szorz;
			_y +=  t�v * y_szorz;
			temp_se.add(new S�nElem(cs1, cs2, l�th,(int)Math.round(_x),(int) Math.round(_y)));
		}

		/** s�nelemek �sszek�t�se egym�ssal */
		for (int i = 0; i < temp_se.size() - 1; i++) {
			temp_se.get(i).setK�vetkez�(temp_se.get(i + 1));
		}

		/** s�nv�gek megad�sa a csom�pontoknak */
		cs1.setBefut�S�n(temp_se.get(0));
		cs2.setBefut�S�n(temp_se.get(temp_se.size()-1));

		return temp_se;
	}







}