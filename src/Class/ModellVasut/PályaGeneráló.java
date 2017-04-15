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

	private PályaGeneráló(){

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

		/** csomópontok létrehozása */
		System.out.println(">>Csomópont::Csomópont()");
		Csomópont cs1 = new Csomópont();
		System.out.println(">>Csomópont::Csomópont()");
		Csomópont cs2 = new Csomópont();

		/** Létrehozott csomópontokat összekötõ SínElemek létrehozása */
		System.out.println(">>SínElem::SínElem()");
		SínElem se1 = new SínElem();
		System.out.println(">>SínElem::SínElem()");
		SínElem se2 = new SínElem();

		/** Pályán lévõ kocsik létrehozása */
		System.out.println(">> Kocsi:: Kocsi()");
		Kocsi k1 = new Kocsi();
		System.out.println(">> Kocsi:: Kocsi()");
		Kocsi k2 = new Kocsi();

 		/** Pályán lévõ mozdonyok létrehozása */
		System.out.println(">> Mozdony::Mozdony()");
		Mozdony m = new Mozdony();

		/** Idõzítõ létrehozása */
		System.out.println(">>Idõzítõ::Idõzítõ()");
		Idõzítõ i = new Idõzítõ();

		System.out.println("A pálya felépült.");


		System.out.println("<<Pályageneráló::kezdés()::Idõzítõ");
		return i;
	}

}