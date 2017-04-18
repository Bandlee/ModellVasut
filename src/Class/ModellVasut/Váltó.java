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
	public V�lt�(){
		super();
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
		/** egy v�ltoz� seg�ts�g�vel l�p�nk az elemek k�z�tt*/
		int i = befut�S�nek.indexOf(akt�v);
		/** l�ptetj�k a v�ltoz�nkat*/
		i++;
		/** ha t�ll�pt�nk a list�n, el�r�l kezdj�k (1-t�l, mivel a 0. a r�gz�tett) */
		if (i >= befut�S�nek.size())
			i = 1;
		/** ha l�ptet�s ut�n nem az akt�von �llunk, akkor lecser�lj�k azt az aktu�lisra */
		/** ha l�ptet�s ut�n is az akt�v az aktu�lis, akkor nem v�ltoztatunk semmmit */
		if (befut�S�nek.get(i) != akt�v)
			akt�v = befut�S�nek.get(i);
	}

	/**
	 * A v�lt�ba �rkez� vonatot tov�bb�tja a megfelel� kimenetre
	 * visszat�r�si �rt�ke att�l f�gg, hogy siker�l-e be�ll�tani a a megfelel�
	 * v�ltoztat�sokat.
	 *
	 * @param v a tov�bb�tand� vonatelem
	 * @param s megmutatja, honnan is �rkezett a vonatelem
	 */
	public boolean tov�bb(VonatElem v, S�nElem s){
		try{
			S�nElem hova = null;

			if(s == r�gz�tett){
				hova = akt�v;
			} else if(s == akt�v){
				hova = r�gz�tett;
			}
			if(hova == null){
				return false;
			} else{
				v.setPoz�ci�(hova);
				if(hova.getS�nv�g1()==this) v.setIr�ny(true); else v.setIr�ny(false);
				return true;
			}
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * Be�ll�tja a v�lt� akt�v kimenet�t a param�terben �tadottra.
	 * @param s a be�ll�tand� S�nElem
	 */
	public void setAkt�v(S�nElem s){akt�v = s;}

	/**
	 * Visszat�r a v�lt� akt�v kimenet�vel
	 * @return az akt�v S�nElem
	 */
	public S�nElem getAkt�v(){return akt�v;}

	/**
	 * Be�ll�tja a v�lt� r�gz�tett kimenet�t a param�terben �tadottra.
	 * @param s a be�ll�tand� S�nElem
	 */
	public void setR�gz�tett(S�nElem s){r�gz�tett = s;}

	/**
	 * Visszaadja a v�lt� r�gz�tett kimenet�t
	 * @return  a visszaadott S�nElem
	 */
	public S�nElem getR�gz�tett(){return r�gz�tett;}
}












