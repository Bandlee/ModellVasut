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

	private P�lyaGener�l�(){

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

		/** csom�pontok l�trehoz�sa */
		System.out.println(">>Csom�pont::Csom�pont()");
		Csom�pont cs1 = new Csom�pont();
		System.out.println(">>Csom�pont::Csom�pont()");
		Csom�pont cs2 = new Csom�pont();

		/** L�trehozott csom�pontokat �sszek�t� S�nElemek l�trehoz�sa */
		System.out.println(">>S�nElem::S�nElem()");
		S�nElem se1 = new S�nElem();
		System.out.println(">>S�nElem::S�nElem()");
		S�nElem se2 = new S�nElem();

		/** P�ly�n l�v� kocsik l�trehoz�sa */
		System.out.println(">> Kocsi:: Kocsi()");
		Kocsi k1 = new Kocsi();
		System.out.println(">> Kocsi:: Kocsi()");
		Kocsi k2 = new Kocsi();

 		/** P�ly�n l�v� mozdonyok l�trehoz�sa */
		System.out.println(">> Mozdony::Mozdony()");
		Mozdony m = new Mozdony();

		/** Id�z�t� l�trehoz�sa */
		System.out.println(">>Id�z�t�::Id�z�t�()");
		Id�z�t� i = new Id�z�t�();

		System.out.println("A p�lya fel�p�lt.");


		System.out.println("<<P�lyagener�l�::kezd�s()::Id�z�t�");
		return i;
	}

}