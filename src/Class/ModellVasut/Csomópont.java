package Class.ModellVasut;


import java.util.List;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:55
 */
public class Csom�pont {

	protected List<S�nElem> befut�S�nek;
	protected int x;
	protected int y;
	protected static int id = 0;

	/**
	 * Konstruktor a Csom�pont oszt�ly p�ld�nyos�t�s�hoz
	 * @param a a Csom�pont x koordin�t�ja
	 * @param b a Csom�pont x koordin�t�ja
	 * @param list a Csom�pontba fut� S�nElemek list�ja
	 */
	public Csom�pont(int a, int b, List<S�nElem> list){
		x = a;
		y = b;
		befut�S�nek = list;
		id +=1;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * a csom�pontra �rkez� vonatot tov�bb�tja a megfelel� kimenetre
     * visszat�r�si �rt�ke att�l f�gg, hogy siker�l-e be�ll�tani a a megfelel�
	 * v�ltoztat�sokat.
     *
	 * @param v a tov�bb�tand� vonatelem
	 * @param s megmutatja, honnan is �rkezett a vonatelem
	 */
	public boolean tov�bb(VonatElem v, S�nElem s){
		try{
			S�nElem hova = null;

			if(befut�S�nek.get(0)!=s){
				hova = befut�S�nek.get(0);
			} else if(befut�S�nek.get(1)!=s){
				hova = befut�S�nek.get(1);
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
	 * A Csom�pontba fut� s�nek b�v�t�se, �j befut� S�nElem hozz�ad�sa
	 * @param s a hozz�adand� S�nElem
	 */
	public void setBefut�S�n(S�nElem s){
		befut�S�nek.add(s);
	}

}