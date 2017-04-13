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
	public SínElem( VonatElem v, SínElem el, SínElem köv, boolean láth, Csomópont csp1, Csomópont csp2){
		aktuálisVonatElem = v;
		elõzõ = el;
		következõ = köv;
		látható = láth;
		sínvég1 = csp1;
		sínvég2 = csp2;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * segédfüggvény a tesztesetekhez
	 * alapból a konstruktor jelenleg nullázza a következõ sínelemre mutató referenciát, mivel ha újat hoznék létre, végtelen ciklusba kerülne
	 * viszont bizonyos esetekben szükség van arra, hogy legyen beállítva követezõ sínelem, ezt kezeli ez a függvény
	 * a rendes mûködés közben erre nem lesz ilyen formában szükség
	 */
	public void setKövetkezõ(SínElem se){
		következõ = se;
		következõ.elõzõ = this;
	}

	/**
	 * visszatér az aktuálisan a sínelemen tartózkodó vonatelemmel
	 * jelenleg mivel nincsenek elõre felépített objektumaink, itt hoz létre egy elemet, amit visszaad, de ez a rendes kódban nem így fog majd kinézni
	 * @return a sínelemen tartózkodó vonatelem
	 */
	public VonatElem getÁthaladóElem(){
		return aktuálisVonatElem;
	}

	/**
	 * Tovább küldi az irányának megfelelõ csomópontba a v paraméterben kapott VonatElemet
	 * @param i A vonat iránya
	 * @param v A vonatelem, amelyet mozgatni akarunk
	 */
	public boolean keresztez(boolean i, VonatElem v){
		if(i) {
			if(this.következõ==null){
				return sínvég1.tovább(aktuálisVonatElem,this);
			}
		} else {
			if(this.elõzõ ==null){
				return sínvég2.tovább(aktuálisVonatElem,this);
			}
		}
		return false;
	}

	/**
	 * beállítja  a sínelemen áthaladó vonatelemet
	 * @param áe a beállított paraméter
	 */
	public void setÁthaladóElem(VonatElem áe){
		aktuálisVonatElem = áe;
	}

	/**
	 * a függvény kezeli azt az esetét a vonatütközésnek, mikor egymással két szembenálló mozdony "átugraná egymást"
	 *
	 * jelenlegi visszatérési értéke a tesztesetek mûködését szolgálja, az éles programban nem így lesz meghatározva
	 * @return megmutatja, hogy fennáll e az ütközésnek a lehetõsége
	 */
	public boolean ütközésElõrejelez(){

		VonatElem elõttem = elõzõ.getÁthaladóElem();
		VonatElem mögöttem = következõ.getÁthaladóElem();
		if(elõttem!=null && elõttem.getIrány()!=aktuálisVonatElem.getIrány()){
			return false;
		} else if(mögöttem != null && mögöttem.getIrány()!= aktuálisVonatElem.getIrány()){
			return false;
		} else return true;

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

	public boolean getLátható(){ return látható; }

	public Csomópont getSínvég1() { return sínvég1; }

	public Csomópont getSínvég2() { return sínvég2; }
}