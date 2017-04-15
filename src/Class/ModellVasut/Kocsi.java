package Class.ModellVasut;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public class Kocsi extends VonatElem {

	private Kocsi k�vetkez�;
	private boolean lesz�llhat;
	private boolean utas;

	public Kocsi(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * A met�dus megadja, hogy adott sz�n� �llom�s mellett elhaladva sz�llnak-e le a kocsir�l utasok.
	 * Amennyiben igen, ezt jelzi az utas tulajdons�g be�ll�t�s�val, valamit enged�lyezi az ut�na k�vetkez�
	 * kocsinak a lesz�ll�st (ez a szkeletonban nincs megval�s�tva, a v�gs� programban lesz szerepe).
	 *
	 * @param s: Az �llom�s sz�n�t jel�li a param�ter, ez alapj�n fogjuk a v�gs� programban eld�nteni,
	 *           hogy sz�llnak-e le az adott kocsir�l a megadott sz�n� �llom�son.
	 */
	@Override
	public boolean ellen�riz(String s){
		System.out.println("<<Kocsi::ellen�riz(String s)::boolean");
		return false;

	}

	/**
	 * A met�dus megh�v�dik minden alkalommal, mikor az el�tte l�v� vonat elem �tadja neki az �rajelet
	 * Megh�vja az elem mozgat�s��rt felel�s f�ggv�nyt, �s tov�bbadja a jelet a k�vetkez� vonat elemnek, ha l�tezik.
	 */
	public void tickAkci�(){
		System.out.println(">>Kocsi �rajelet kapott");
		mozgat();
		if(k�vetkez� != null) k�vetkez�.tickAkci�();
	}

}