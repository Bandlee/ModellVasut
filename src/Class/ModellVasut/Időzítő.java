package Class.ModellVasut;


import java.util.List;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */

/**
 * Az idõ múlását megvalósító osztály
 */
public class Idõzítõ {

	private List<Mozdony> mozdonyok;
	//public Mozdony m_Mozdony;

	/**
	 * Konstruktor az Idõzítõ osztály példányosításához
	 * @param list pályán lévõ összes Mozdonyt tartalmazó lista
	 */
	public Idõzítõ( List<Mozdony> list){
		mozdonyok = list;

	}

	public void finalize() throws Throwable {

	}

	/**
	 * az idõ eltelését szimbolizálja, idõegységenként hívódik meg
	 */
	public void tick(){
		//System.out.println(">>Mozdony::tickAkció()");
		for (Mozdony m : mozdonyok)
			m.mozgat();
	}

}