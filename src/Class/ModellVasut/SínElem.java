package Class.ModellVasut;


import java.util.ArrayList;
import java.util.List;

/**
 * A SínElemeket megvalósító osztály. Feladataihoz tartozik az ütközésdetektálás és a vonatelemtovábbítás is.
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public class SínElem extends Hely {

	private VonatElem aktuálisVonatElem;
	private SínElem elõzõ;
	private SínElem következõ;
	private boolean látható;
	private Csomópont sínvég1;
	private Csomópont sínvég2;

	/**
	 * A SínElem osztály konstruktora.
	 * Belépés segítéséhez létrehozott konstruktor
	 * @param csp1 a SínElemek alkotta sín egyik végsõ csomópontja
	 * @param csp2 a SínElemek alkotta sín másik végsõ csomópontja
	 */
	public SínElem( Csomópont csp1, Csomópont csp2){
		super(0,0);
		látható = false;
		sínvég1 = csp1;
		sínvég2 = csp2;
		elõzõ = null;
		következõ = null;
	}


	/**
	 * A SínElem osztály konstruktora.
	 * @param láth a SínElem láthatósága
	 * @param csp1 a SínElemek alkotta sín egyik végsõ csomópontja
	 * @param csp2 a SínElemek alkotta sín másik végsõ csomópontja
	 */
	public SínElem( Csomópont csp1, Csomópont csp2, boolean láth, int x, int y){
		super(x,y);
		látható = láth;
		sínvég1 = csp1;
		sínvég2 = csp2;
		elõzõ = null;
		következõ = null;
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
				return sínvég2.tovább(v,this);
			}
		} else {
			if(this.elõzõ ==null){
				return sínvég1.tovább(v,this);
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
        VonatElem mögöttem=null;
	    if(elõzõ!=null){
            if(elõzõ.getÁthaladóElem()!=null){
                mögöttem=elõzõ.getÁthaladóElem();
            }
        }

        VonatElem elõttem=null;
        if(következõ!=null){
            if(következõ.getÁthaladóElem()!=null){
                elõttem=következõ.getÁthaladóElem();
            }
        }

        if(elõttem!=null){
            if(elõttem.getIrány()!=aktuálisVonatElem.getIrány()) return false;
        }

        if(mögöttem!=null){
            if(mögöttem.getIrány()!=aktuálisVonatElem.getIrány()) return false;
        }

        return true;
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


	public static List<SínElem> összeköt(Csomópont cs1, Csomópont cs2, boolean láth){

		/**távolság sínelemek között*/
		int táv = 40;

		int x_dist = (cs2.getX()-cs1.getX());
		int y_dist = (cs2.getY()-cs1.getY());


		/** 2 csomópont közti szakasz hossza*/
		int szh = (int) Math.sqrt(x_dist*x_dist + y_dist*y_dist);

		/** hány sínelem fér a két csomópont közé, (az utolsó a csomópontba lenne, vagy nagyon közel) */
		int sedb = szh /táv ;


		double x_szorz = x_dist/(double)szh;
		double y_szorz = y_dist/(double)szh;
		List<SínElem> temp_se =new ArrayList<>();

		/** pont a két csomópont közé kerüljön, ha kevés a hely */
		if (sedb < 1) {
			int _x = (int) (cs1.getX() + Math.round(szh/2 * x_szorz));
			int _y = (int) (cs1.getY() + Math.round(szh/2 * y_szorz));
			temp_se.add(new SínElem(cs1, cs2, láth, _x, _y));

		}

		else {

			for (int i = 1; i <= sedb; i++) {

				int _x = (int) (cs1.getX() + Math.round(i * táv * x_szorz));
				int _y = (int) (cs1.getY() + Math.round(i * táv * y_szorz));
				temp_se.add(new SínElem(cs1, cs2, láth, _x, _y));
			}
			for (int i = 0; i < temp_se.size() - 1; i++) {
				temp_se.get(i).setKövetkezõ(temp_se.get(i + 1));
			}
		}

		cs1.setBefutóSín(temp_se.get(0));
		cs2.setBefutóSín(temp_se.get(temp_se.size()-1));

		return temp_se;
	}







}