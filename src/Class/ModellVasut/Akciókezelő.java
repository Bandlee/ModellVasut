package Class.ModellVasut;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-m?rc.-2017 3:39:54
 */
public class Akci�kezel�{

	public Akci�kezel�(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param cs: Megadja, hogy melyik csom�pont t�pus� elemen szeretne a felhaszn�l� akci�t v�grehajtani.
	 */
	public void akci�(Csom�pont cs){
	    /**Csak a Szkeletonban t�rt�n� ki�rat�s miatt k�rj�k le a t�pus�t csom�pont objektumnak.
         * A v�gs� programban erre nem lesz sz�ks�g.
         * A csom�pont rendelkezik egy felhaszn�l�Akci� f�ggv�nnyel.
         * A programban, ha egy olyan csom�pontra kattitunk majd, ami nem v�lt� vagy alag�sz�j, akkor nem fog t�rt�nni semmi.
         * V�lt� �s Alag�tSz�j lesz�rmazott oszt�ly eset�n pedig fel�l van �rva a f�ggv�ny.
         * */
	    if (cs.getClass()==V�lt�.class){
            System.out.println(">>V�lt�::felhaszn�l�Akci�()");
        }
        if (cs.getClass()==Alag�tSz�j.class){
            System.out.println(">>Alag�tSt�j::felhaszn�l�Akci�()");
        }

        /**L�tszik, hogy nem kell tudnunk a t�pus�t a csom�pontnak, hogy a megfelel� t�pus� objektunon h�vjuk meg a felhaszn�l�Akci� f�ggv�nyt */
        cs.felhaszn�l�Akci�();
	}

}