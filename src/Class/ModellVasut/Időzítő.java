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
	/** mozdonyok, amiknek órajelet kell adni */
	private List<Mozdony> mozdonyok;

	/** keresztezõ sinek, amiket órajelenként resetelni kell */
	private List<KeresztezõSín> ksínek;

	/** megadja, hány ms-onként kap órajelet a model*/
	private int ciklusidõ;


	/**
	 * Konstruktor az Idõzítõ osztály példányosításához
	 * @param list pályán lévõ összes Mozdonyt tartalmazó lista
	 */
	public Idõzítõ( List<Mozdony> list){
		super();
		mozdonyok = list;
	}

	/**
	 * Konstruktor az Idõzítõ osztály példányosításához.
	 * @param list pályán lévõ összes Mozdonyt tartalmazó lista
	 * @param _ksínek pályán lévõ összes KeresztezõSínt tartalmazó lista
	 * @param sebesség a játék sebessége
	 */
	public Idõzítõ( List<Mozdony> list,List<KeresztezõSín> _ksínek,int sebesség){
		super();
		mozdonyok = list;
		ksínek = _ksínek;
		ciklusidõ = 480/sebesség;

	}

	public void finalize() throws Throwable {

	}

	/**
	 * az idõ eltelését szimbolizálja, idõegységenként hívódik meg
	 */
	public void tick() throws  VegException{
		for (KeresztezõSín ksn : ksínek )
			ksn.reset();
		for (Mozdony m : mozdonyok)
			m.tickAkció();
	}

	/**
	 * Ciklusidõ lekérdezésére használatos függvény
	 * @return ciklusidõ
	 */
	public int getCiklusidõ(){
		return ciklusidõ;
	}

}