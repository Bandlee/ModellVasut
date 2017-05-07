package Class.ModellVasut;


import java.util.List;
import java.util.Timer;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */

/**
 * Az id� m�l�s�t megval�s�t� oszt�ly
 */
public class Id�z�t� extends Timer {
	/** mozdonyok, amiknek �rajelet kell adni */
	private List<Mozdony> mozdonyok;

	/** keresztez� sinek, amiket �rajelenk�nt resetelni kell */
	private List<Keresztez�S�n> ks�nek;

	/** megadja, h�ny ms-onk�nt kap �rajelet a model*/
	private int ciklusid�;


	/**
	 * Konstruktor az Id�z�t� oszt�ly p�ld�nyos�t�s�hoz
	 * @param list p�ly�n l�v� �sszes Mozdonyt tartalmaz� lista
	 */
	public Id�z�t�( List<Mozdony> list){
		super();
		mozdonyok = list;
	}

	/**
	 * Konstruktor az Id�z�t� oszt�ly p�ld�nyos�t�s�hoz.
	 * @param list p�ly�n l�v� �sszes Mozdonyt tartalmaz� lista
	 * @param _ks�nek p�ly�n l�v� �sszes Keresztez�S�nt tartalmaz� lista
	 * @param sebess�g a j�t�k sebess�ge
	 */
	public Id�z�t�( List<Mozdony> list,List<Keresztez�S�n> _ks�nek,int sebess�g){
		super();
		mozdonyok = list;
		ks�nek = _ks�nek;
		ciklusid� = 480/sebess�g;

	}

	public void finalize() throws Throwable {

	}

	/**
	 * az id� eltel�s�t szimboliz�lja, id�egys�genk�nt h�v�dik meg
	 */
	public void tick() throws  VegException{
		for (Keresztez�S�n ksn : ks�nek )
			ksn.reset();
		for (Mozdony m : mozdonyok)
			m.tickAkci�();
	}

	/**
	 * Ciklusid� lek�rdez�s�re haszn�latos f�ggv�ny
	 * @return ciklusid�
	 */
	public int getCiklusid�(){
		return ciklusid�;
	}

}