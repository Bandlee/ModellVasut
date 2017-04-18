package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public class Mozdony extends VonatElem {

	private Csom�pont bel�p�sipont;
	private int k�sleltet�s;

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
		System.out.println("Mozdony �rajelet kapott");
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

}