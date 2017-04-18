package Class.ModellVasut;


import java.io.File;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public class PályaGeneráló {

	private static PályaGeneráló me = null;

	private File bemenet;
	private int szint;

	public PályaGeneráló(){

	}

	public void finalize() throws Throwable {

	}

	public static PályaGeneráló getInstance() {
		if(me == null) {
			me = new PályaGeneráló();
		}

		return me;
	}

	/**
	 * Pálya betöltésért, felelõs függvény.
	 * A Szkeletonban csak 2 Csomópontot, az öket összekötõ SinElemeket,
	 * kettõ kocsit, és az õket huzú mozdonyt hozzuk létre, valamint az idõzítõt,
	 * ami a vonatok mozgatásáért felel.
	 */

	public Idõzítõ kezdés(){

	}

}