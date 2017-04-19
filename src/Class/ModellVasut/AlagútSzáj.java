package Class.ModellVasut;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Alagútszájakat megvalósító osztály
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:55
 */
public class AlagútSzáj extends Csomópont {

	private boolean aktív;
	private static List<AlagútSzáj> aktívak;
	private Alagút alagút;

	/**
	 * A konstruktorban alapértelmezettként inaktívra állítjuk az alagút szájat.
	 * Az AlagútSzájat Csomópontként, annak konstruktorával hozzuk létre.
	 */
	public AlagútSzáj(){
		super();
		aktív = false;
		aktívak = new ArrayList<>();
	}

	public void finalize() throws Throwable {
		super.finalize();
	}


	/**
	 *  Ez a függvény gondoskodik róla, hogy átállítsa az alagút száj aktivitását.
	 *  Amelyik aktív lesz, berakja az aktívak listába, amelyik inaktívvá válik, azt kiveszi onnan.
	 *  Nem hagyja, hogy egy harmadik alagút száj is aktív legyen.
	 *  Megvizsgálja az aktívakat:
	 *  Ha a második alagút száj is aktív lett, meghívja az építés függvényét.
	 *  Ha 2 alá csökken az aktív alagút szájak száma,
	 *  a rombolás függvényét meghívva leromboltatja a meglévõ alagutat,
	 *  feltéve, hogy nincs éppen vonat az alagútban.
	 */
	public void felhasználóAkció(){
		// ha inaktív volt:
		if (!aktív){
			// max. 2 aktív lehet
			if (aktívak.size() >= 2)
				System.out.println("Nem hozható létre több alagút!");
			else {
				// hozzáadjuk a listához és aktiváljuk
				aktívak.add(this);
				aktív = true;
				// ha aktív lett 2, építünk
				if (aktívak.size() == 2)
					épít();
			}

		}
		// ha aktív volt:
		else {
			// ha 2-rõl lecsökkent az aktívak száma, töröljük az alagutat
			if (aktívak.size() == 2) {
				// ha az alagút üres
				if (alagút.getÜresAlagút()){
					rombol();
					// töröljük a listából és inaktívvá tesszük
					aktívak.remove(this);
					aktív = false;
				}
				// ha nem üres, nem törlünk
				else {
					System.out.println("Az alagút nem szüntethetõ meg, mivel vonat halad benne!");
				}
			}

		}
	}

	/**
	 * Létrehoz egy Alagút példányt,
	 * majd az aktívak listájában lévõ (2) alagút szájaknál beállítja az új alagutat,
	 * illetve az új alagútnál a bejáratait (utóbbit a konstruktora segítségével)
	 */
	private void épít(){
		//létrehozzuk az alagutat a két végével
		alagút = new Alagút(aktívak.get(0), aktívak.get(1));
        aktívak.get(0).setBefutóSín(alagút.getAlagútelem().get(0));
        aktívak.get(1).setBefutóSín(alagút.getAlagútelem().get(alagút.getAlagútelem().size()-1));

		//beállítjuk az alagút szájaknak a friss alagutunkat
		for (AlagútSzáj actual : aktívak) {
		    actual.alagút=alagút;
        }
	}

	/**
	 * Megszünteti (null pointerre cseréli) a létezõ alagutat mindkét végénél.
	 */
	private void rombol(){
        aktívak.get(0).removeBefutóSín(alagút.getAlagútelem().get(0));
        aktívak.get(1).removeBefutóSín(alagút.getAlagútelem().get(alagút.getAlagútelem().size()-1));
	    for (AlagútSzáj actual : aktívak)
			actual.alagút = null;
	}

}