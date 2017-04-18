package Class.ModellVasut;


/**
 * A mozdonyokat megval�s�t� oszt�ly. A vonatelem lesz�rmazottja
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public class Mozdony extends VonatElem {

	private Csom�pont bel�p�sipont;
	private int k�sleltet�s;

	/**
	 * Mozdony oszt�ly konstruktora
	 * @param b a mozdony bel�p�si pontja
	 * @param k a mozdony k�sleltet�se
	 */
	public Mozdony(Csom�pont b, int k){
		k�sleltet�s = k;
		bel�p�sipont = b;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * K�zvetlen�l a j�t�k lefoly�s�t kezel� oszt�lyb�l h�v�dik. Megh�vja a vonat mozgat�s��rt felel�s f�ggv�nyt, ha
	 * annak m�r a p�ly�n kellene lennie (k�sleltet�s == 0), k�l�nben cs�kkenti a k�sleltet�st
	 */
	public void tickAkci�(){
		if(k�sleltet�s == 0) {
			mozgat();
			if(k�vetkez� != null) k�vetkez�.tickAkci�();
		} else {
			k�sleltet�s--;
		}
	}


	/**
	 * Hozz�k�ti a mozdonyhoz a megadott kocsit, ez fog ut�na k�vetkezni.
	 *
	 * @param k�vetkez� a kocsi, ami a mozdonyhoz lesz k�tve.
	 */
	@Override
	public void setK�vetkez�(Kocsi k�vetkez�) {
		this.k�vetkez� = k�vetkez�;
	}

	/**
	 * Visszaadja a mozdony k�sleltet�s�t.
	 * @return k�sleltet�s
	 */
	public int getK�sleltet�s(){return k�sleltet�s;}

	/**
	 * Visszaadja a mozdony bel�p�si pontj�t
	 * @return bel�p�si pont
	 */
	public Csom�pont getBel�p�siPont(){
		return bel�p�sipont;
	}
}