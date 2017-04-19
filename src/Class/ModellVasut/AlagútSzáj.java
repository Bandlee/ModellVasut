package Class.ModellVasut;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Alag�tsz�jakat megval�s�t� oszt�ly
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:55
 */
public class Alag�tSz�j extends Csom�pont {

	private boolean akt�v;
	private static List<Alag�tSz�j> akt�vak;
	private Alag�t alag�t;

	/**
	 * A konstruktorban alap�rtelmezettk�nt inakt�vra �ll�tjuk az alag�t sz�jat.
	 * Az Alag�tSz�jat Csom�pontk�nt, annak konstruktor�val hozzuk l�tre.
	 */
	public Alag�tSz�j(){
		super();
		akt�v = false;
		akt�vak = new ArrayList<>();
	}

	public void finalize() throws Throwable {
		super.finalize();
	}


	/**
	 *  Ez a f�ggv�ny gondoskodik r�la, hogy �t�ll�tsa az alag�t sz�j aktivit�s�t.
	 *  Amelyik akt�v lesz, berakja az akt�vak list�ba, amelyik inakt�vv� v�lik, azt kiveszi onnan.
	 *  Nem hagyja, hogy egy harmadik alag�t sz�j is akt�v legyen.
	 *  Megvizsg�lja az akt�vakat:
	 *  Ha a m�sodik alag�t sz�j is akt�v lett, megh�vja az �p�t�s f�ggv�ny�t.
	 *  Ha 2 al� cs�kken az akt�v alag�t sz�jak sz�ma,
	 *  a rombol�s f�ggv�ny�t megh�vva leromboltatja a megl�v� alagutat,
	 *  felt�ve, hogy nincs �ppen vonat az alag�tban.
	 */
	public void felhaszn�l�Akci�(){
		// ha inakt�v volt:
		if (!akt�v){
			// max. 2 akt�v lehet
			if (akt�vak.size() >= 2)
				System.out.println("Nem hozhat� l�tre t�bb alag�t!");
			else {
				// hozz�adjuk a list�hoz �s aktiv�ljuk
				akt�vak.add(this);
				akt�v = true;
				// ha akt�v lett 2, �p�t�nk
				if (akt�vak.size() == 2)
					�p�t();
			}

		}
		// ha akt�v volt:
		else {
			// ha 2-r�l lecs�kkent az akt�vak sz�ma, t�r�lj�k az alagutat
			if (akt�vak.size() == 2) {
				// ha az alag�t �res
				if (alag�t.get�resAlag�t()){
					rombol();
					// t�r�lj�k a list�b�l �s inakt�vv� tessz�k
					akt�vak.remove(this);
					akt�v = false;
				}
				// ha nem �res, nem t�rl�nk
				else {
					System.out.println("Az alag�t nem sz�ntethet� meg, mivel vonat halad benne!");
				}
			}

		}
	}

	/**
	 * L�trehoz egy Alag�t p�ld�nyt,
	 * majd az akt�vak list�j�ban l�v� (2) alag�t sz�jakn�l be�ll�tja az �j alagutat,
	 * illetve az �j alag�tn�l a bej�ratait (ut�bbit a konstruktora seg�ts�g�vel)
	 */
	private void �p�t(){
		//l�trehozzuk az alagutat a k�t v�g�vel
		alag�t = new Alag�t(akt�vak.get(0), akt�vak.get(1));
        akt�vak.get(0).setBefut�S�n(alag�t.getAlag�telem().get(0));
        akt�vak.get(1).setBefut�S�n(alag�t.getAlag�telem().get(alag�t.getAlag�telem().size()-1));

		//be�ll�tjuk az alag�t sz�jaknak a friss alagutunkat
		for (Alag�tSz�j actual : akt�vak) {
		    actual.alag�t=alag�t;
        }
	}

	/**
	 * Megsz�nteti (null pointerre cser�li) a l�tez� alagutat mindk�t v�g�n�l.
	 */
	private void rombol(){
        akt�vak.get(0).removeBefut�S�n(alag�t.getAlag�telem().get(0));
        akt�vak.get(1).removeBefut�S�n(alag�t.getAlag�telem().get(alag�t.getAlag�telem().size()-1));
	    for (Alag�tSz�j actual : akt�vak)
			actual.alag�t = null;
	}

}