package Class.ModellVasut;


import java.io.File;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public class P�lyaGener�l� {

	private static P�lyaGener�l� me = null;

	private File bemenet;
	private int szint;

	public P�lyaGener�l�(){

	}

	public void finalize() throws Throwable {

	}

	public static P�lyaGener�l� getInstance() {
		if(me == null) {
			me = new P�lyaGener�l�();
		}

		return me;
	}

	/**
	 * P�lya bet�lt�s�rt, felel�s f�ggv�ny.
	 * A Szkeletonban csak 2 Csom�pontot, az �ket �sszek�t� SinElemeket,
	 * kett� kocsit, �s az �ket huz� mozdonyt hozzuk l�tre, valamint az id�z�t�t,
	 * ami a vonatok mozgat�s��rt felel.
	 */

	public Id�z�t� kezd�s(){

	}

}