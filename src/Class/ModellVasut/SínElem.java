package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public class SínElem {

	private VonatElem aktuálisVonatElem;
	private SínElem elõzõ;
	private SínElem következõ;
	private boolean látható;
	private Csomópont sínvég1;
	private Csomópont sínvég2;

	/**
	 * sínelem konstruktor
	 * jelenleg csak a tesztesetekhez szükséges elemeket hozza létre
	 */
	public SínElem(){
		sínvég1 = new Csomópont();
		sínvég2 = new Csomópont();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * segédfüggvény a tesztesetekhez
	 * alapból a konstruktor jelenleg nullázza a következõ sínelemre mutató referenciát, mivel ha újat hoznék létre, végtelen ciklusba kerülne
	 * viszont bizonyos esetekben szükség van arra, hogy legyen beállítva követezõ sínelem, ezt kezeli ez a függvény
	 * a rendes mûködés közben erre nem lesz ilyen formában szükség
	 */
	public void setKövetkezõ(){
		következõ = new SínElem();
	}

	/**
	 * visszatér az aktuálisan a sínelemen tartózkodó vonatelemmel
	 * jelenleg mivel nincsenek elõre felépített objektumaink, itt hoz létre egy elemet, amit visszaad, de ez a rendes kódban nem így fog majd kinézni
	 * @return a sínelemen tartózkodó vonatelem
	 */
	public VonatElem getÁthaladóElem(){
		System.out.println("<<SínElem::getÁthaladóElem()::boolean");
		return new Kocsi();
	}

	/**
	 * Tovább küldi az irányának megfelelõ csomópontba a v paraméterben kapott VonatElemet
	 * @param i A vonat iránya
	 * @param v A vonatelem, amelyet mozgatni akarunk
	 */
	public boolean keresztez(boolean i, VonatElem v){
		System.out.println(">>SínElem::keresztez(i,v)");
		if(i) {

			return sínvég1.tovább(v, this);
		} else {
			return sínvég2.tovább(v, this);
		}
	}

	/**
	 * beállítja  a sínelemen áthaladó vonatelemet
	 * @param áe a beállított paraméter
	 */
	public void setÁthaladóElem(VonatElem áe){

	}

	/**
	 * a függvény kezeli azt az esetét a vonatütközésnek, mikor egymással két szembenálló mozdony "átugraná egymást"
	 *
	 * jelenlegi visszatérési értéke a tesztesetek mûködését szolgálja, az éles programban nem így lesz meghatározva
	 * @return megmutatja, hogy fennáll e az ütközésnek a lehetõsége
	 */
	public boolean ütközésElõrejelez(){
		System.out.println(">>SínElem::ütközéstElõrejelez()");
		elõzõ = new SínElem();
		következõ = new SínElem();

		System.out.println(">>SínElem::getÁthaladóElem()");
		elõzõ.getÁthaladóElem();
		System.out.println(">>SínElem::getÁthaladóElem()");
		következõ.getÁthaladóElem();
		System.out.println("<<SínElem::ütközéstElõrejelez()::boolean");
		return false;
	}

	/**
	 * a sínelemhez kapcsolódó, következõ elemet adja vissza
	 * @return a keresett elem
	 */
	public SínElem getKövetkezõ() {
		return következõ;
	}
	/**
	 * a sínelemhez kapcsolódó, elõzõ elemet adja vissza
	 * @return a keresett elem
	 */
	public SínElem getElõzõ() {
		return elõzõ;
	}
}