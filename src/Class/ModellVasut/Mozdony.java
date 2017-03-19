package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public class Mozdony extends VonatElem {

	private Csom�pont bel�p�sipont;
	private Kocsi els�;
	private int k�sleltet�s;
	public Csom�pont m_Csom�pont;
	public Kocsi m_Kocsi;

	public Mozdony(){
		k�sleltet�s = 10;
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
			els�.tickAkci�();
		} else {
			k�sleltet�s--;
		}
	}

}