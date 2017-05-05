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

	private List<Mozdony> mozdonyok;
	private int ciklusid�;
	/**
	 * Konstruktor az Id�z�t� oszt�ly p�ld�nyos�t�s�hoz
	 * @param list p�ly�n l�v� �sszes Mozdonyt tartalmaz� lista
	 */
	public Id�z�t�( List<Mozdony> list){
		super();
		mozdonyok = list;
	}

	public Id�z�t�( List<Mozdony> list,int sebess�g){
		super();
		mozdonyok = list;
		ciklusid� = 480/sebess�g;

	}

	public void finalize() throws Throwable {

	}

	/**
	 * az id� eltel�s�t szimboliz�lja, id�egys�genk�nt h�v�dik meg
	 */
	public void tick() throws  VegException{
		for (Mozdony m : mozdonyok)
			m.tickAkci�();
	}

	public int getCiklusid�(){
		return ciklusid�;
	}

}