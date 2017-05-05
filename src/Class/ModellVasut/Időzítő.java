package Class.ModellVasut;


import java.util.List;
import java.util.Timer;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */

/**
 * Az idõ múlását megvalósító osztály
 */
public class Idõzítõ extends Timer {

	private List<Mozdony> mozdonyok;
	private int ciklusidõ;
	/**
	 * Konstruktor az Idõzítõ osztály példányosításához
	 * @param list pályán lévõ összes Mozdonyt tartalmazó lista
	 */
	public Idõzítõ( List<Mozdony> list){
		super();
		mozdonyok = list;
	}

	public Idõzítõ( List<Mozdony> list,int sebesség){
		super();
		mozdonyok = list;
		ciklusidõ = 480/sebesség;

	}

	public void finalize() throws Throwable {

	}

	/**
	 * az idõ eltelését szimbolizálja, idõegységenként hívódik meg
	 */
	public void tick() throws  VegException{
		for (Mozdony m : mozdonyok)
			m.tickAkció();
	}

	public int getCiklusidõ(){
		return ciklusidõ;
	}

}