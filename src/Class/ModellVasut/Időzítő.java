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

	public Id�z�t�(){
		m_Mozdony = new Mozdony();

	}

	public void finalize() throws Throwable {

	}

	public void tick(){
		System.out.println(">>Mozdony::tickAkci�()");
		m_Mozdony.tickAkci�();
	}

}