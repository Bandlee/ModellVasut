package Class.ModellVasut;


import java.util.List;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public class Idõzítõ {

	private List<Mozdony> mozdonyok;
	public Mozdony m_Mozdony;

	/**
	 * saját, tesztesetekhez használt változó
	 */
	public Idõzítõ(){
		m_Mozdony = new Mozdony();

	}

	public void finalize() throws Throwable {

	}

	/**
	 * az idõ eltelését szimbolizálja, idõegységenként hívódik meg
	 */
	public void tick(){
		System.out.println(">>Mozdony::tickAkció()");
		m_Mozdony.tickAkció();
	}

}