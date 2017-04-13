package Class.ModellVasut;


import java.util.List;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */

/**
 * Az id� m�l�s�t megval�s�t� oszt�ly
 */
public class Id�z�t� {

	private List<Mozdony> mozdonyok;
	//public Mozdony m_Mozdony;

	/**
	 * Konstruktor az Id�z�t� oszt�ly p�ld�nyos�t�s�hoz
	 * @param list p�ly�n l�v� �sszes Mozdonyt tartalmaz� lista
	 */
	public Id�z�t�( List<Mozdony> list){
		mozdonyok = list;

	}

	public void finalize() throws Throwable {

	}

	/**
	 * az id� eltel�s�t szimboliz�lja, id�egys�genk�nt h�v�dik meg
	 */
	public void tick(){
		//System.out.println(">>Mozdony::tickAkci�()");
		for (Mozdony m : mozdonyok)
			m.mozgat();
	}

}