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
	 * A SínElem osztály konstruktora.
	 * @param v a SínElemen áthaladó aktuális VonatElem
	 * @param el a SínElemet megelõzõ SínElem
	 * @param köv a SínElemet követõ SínElem
	 * @param láth a SínElem láthatósága
	 * @param csp1 a SínElemek alkotta sín egyik végsõ csomópontja
	 * @param csp2 a SínElemek alkotta sín másik végsõ csomópontja
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
	 * a SínElemet követõ SínElem beállítása
	 * @param se a SínElemnek beállítandó következõ SínElem
	 */
	public void setKövetkezõ(SínElem se){
		következõ = se;
		következõ.elõzõ = this;
	}

	/**
	 * a SínElemet megelõzõ SínElem beállítása
	 * @param se a SínElemnek beállítandó elõzõ SínElem
	 */
	public void setElõzõ(SínElem se){
		elõzõ = se;
		elõzõ.következõ = this;
	}

	/**
	 * visszatér az aktuálisan a sínelemen tartózkodó vonatelemmel
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

	/**
	 * a SínElem láthatóságát mutatja meg
	 * @return a SínElem látható attribútuma
	 */
	public boolean getLátható(){ return látható; }

	/**
	 * visszaadja a SínElemek alkotta sín egyik végpontját
	 * @return a SínElem sínvég1 attribútumával
	 */
	public Csomópont getSínvég1() { return sínvég1; }

	/**
	 * visszaadja a SínElemek alkotta sín másik végpontját
	 * @return a SínElem sínvég2 attribútumával
	 */
	public Csomópont getSínvég2() { return sínvég2; }


}