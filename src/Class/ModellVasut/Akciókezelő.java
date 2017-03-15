package Class.ModellVasut;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-m?rc.-2017 3:39:54
 */
public class Akciókezelõ{

	public Akciókezelõ(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param cs: Megadja, hogy melyik csomópont típusú elemen szeretne a felhasználó akciót végrehajtani.
	 */
	public void akció(Csomópont cs){
	    /**Csak a Szkeletonban történõ kiíratás miatt kérjük le a típusát csomópont objektumnak.
         * A végsõ programban erre nem lesz szükség.
         * A csomópont rendelkezik egy felhasználóAkció függvénnyel.
         * A programban, ha egy olyan csomópontra kattitunk majd, ami nem váltó vagy alagúszáj, akkor nem fog történni semmi.
         * Váltó és AlagútSzáj leszármazott osztály esetén pedig felül van írva a függvény.
         * */
	    if (cs.getClass()==Váltó.class){
            System.out.println(">>Váltó::felhasználóAkció()");
        }
        if (cs.getClass()==AlagútSzáj.class){
            System.out.println(">>AlagútStáj::felhasználóAkció()");
        }

        /**Látszik, hogy nem kell tudnunk a típusát a csomópontnak, hogy a megfelelõ típusú objektunon hívjuk meg a felhasználóAkció függvényt */
        cs.felhasználóAkció();
	}

}