package Class.ModellVasut;


import java.util.List;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public class Id�z�t� {

	private List<Mozdony> mozdonyok;
	public Mozdony m_Mozdony;

	/**
	 * saj�t, tesztesetekhez haszn�lt v�ltoz�
	 */
	public Id�z�t�(){
		m_Mozdony = new Mozdony();

	}

	public void finalize() throws Throwable {

	}

	/**
	 * az id� eltel�s�t szimboliz�lja, id�egys�genk�nt h�v�dik meg
	 */
	public void tick(){
		System.out.println(">>Mozdony::tickAkci�()");
		m_Mozdony.tickAkci�();
	}

}