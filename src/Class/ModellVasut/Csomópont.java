package Class.ModellVasut;


import java.util.ArrayList;
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
	private static int ids = 0;
	protected int id;

	/**
	 * Konstruktor a Csom�pont oszt�ly p�ld�nyos�t�s�hoz
	 *
	 */
	public Csom�pont(){
		befut�S�nek = new ArrayList<S�nElem>();
		id=ids;
		ids++;
    }

	public void felhaszn�l�Akci�(){

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
        S�nElem hova = null;
        if(befut�S�nek.get(0)!=s){
            hova = befut�S�nek.get(0);
        } else if(befut�S�nek.size()>1){
            if (befut�S�nek.get(1)!=s) {
                hova = befut�S�nek.get(1);
            }
        }
        if(hova == null){
            return false;
        } else{
            v.setPoz�ci�(hova);
            if(hova.getS�nv�g1()==this) v.setIr�ny(true); else v.setIr�ny(false);
            return true;
        }
	}

	/**
	 * A Csom�pontba fut� s�nek b�v�t�se, �j befut� S�nElem hozz�ad�sa
	 * @param s a hozz�adand� S�nElem
	 */
	public void setBefut�S�n(S�nElem s){
		befut�S�nek.add(s);
	}

    public void removeBefut�S�n(S�nElem s){
        befut�S�nek.remove(s);
    }

	public int getId(){return id;}

	public static void nullId(){
	    ids=0;
    }

}