package Class.ModellVasut;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public abstract class Kocsi extends VonatElem {

	//l�trehoz�skor legyen true, l�ncol�sn�l majd be�ll�t�dik.
	protected boolean lesz�llhat;


	public void finalize() throws Throwable {
		super.finalize();
	}


	/**
	 * A met�dus megh�v�dik minden alkalommal, mikor az el�tte l�v� vonat elem �tadja neki az �rajelet
	 * Megh�vja az elem mozgat�s��rt felel�s f�ggv�nyt, �s tov�bbadja a jelet a k�vetkez� vonat elemnek, ha l�tezik.
	 */
	public void tickAkci�() throws VegException{
		mozgat();
		if(k�vetkez� != null) k�vetkez�.tickAkci�();
	}




	/**
	 * Kocsi lesz�llhat �rt�k�nek be�ll�it�s�ra haszn�land�.
	 *
	 * @param lesz�llhat erre az �rt�kre �ll�tjuk be a kocsi lesz�llhat �rt�k�t
	 */
	protected abstract void setLesz�llhat(boolean lesz�llhat);

}