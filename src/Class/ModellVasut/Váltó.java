package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */

import java.util.List;

/**
 * A v�lt�t megval�s�t� oszt�ly
 */
public class V�lt� extends Csom�pont {

	private S�nElem akt�v;
	private S�nElem r�gz�tett;

	/**
	 * A konstruktorban be�ll�tjuk a lista els� elem�t r�gz�tettnek, a m�sodikat akt�vnak.
	 * A V�lt�t Csom�pontk�nt, annak konstruktor�val hozzuk l�tre.
	 */
	public V�lt�(int a, int b, List<S�nElem> list){
		super(a, b, list);
		r�gz�tett = list.get(0);
		akt�v = list.get(1);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * a felhaszn�l� v�lt�s�t kezel� f�ggv�ny.
	 * Az akt�v v�g�t a v�lt�nak a sorban k�vetkez�
	 * (vagy az utols�t k�vetve az els�) S�nElemre v�ltoztatja.
	 */
	public void felhaszn�l�Akci�(){
		//egy v�ltoz� seg�ts�g�vel l�p�nk az elemek k�z�tt
		int i = befut�S�nek.indexOf(akt�v);
		// l�ptetj�k a v�ltoz�nkat
		i++;
		// ha t�ll�pt�nk a list�n, el�r�l kezdj�k (1-t�l, mivel a 0. a r�gz�tett)
		if (i >= befut�S�nek.size())
			i = 1;
		// ha l�ptet�s ut�n nem az akt�von �llunk, akkor lecser�lj�k azt az aktu�lisra
		// ha l�ptet�s ut�n is az akt�v az aktu�lis, akkor nem v�ltoztatunk semmit
		if (befut�S�nek.get(i) != akt�v)
			akt�v = befut�S�nek.get(i);
	}

}












