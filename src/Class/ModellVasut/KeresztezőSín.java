package Class.ModellVasut;

import java.awt.*;

/**
 * A keresztez� s�neket megval�s�t� oszt�ly
 * @author Peti
 * @version 1.0
 * @created 15-�pr.-2017 17:02:41
 */

/**
 * Az egym�st keresztez� s�nek kapcsol�d�si pontj�t megval�s�t� oszt�ly
 */
public class Keresztez�S�n extends Csom�pont {

    /** Megadja, hogy az adott ciklusban volt-e m�r haszn�lva a Keresztez�S�n */
    private boolean voltHaszn�lva;

    /**
     * A Keresztez�S�nt Csom�pontk�nt, annak konstruktor�val hozzuk l�tre.
     * A s�np�rokat azok index-�vel fogjuk azonos�tani:
     * �sszetartoznak a 0, 2 index� �s az 1, 3 index� S�nElemek
     */
    public Keresztez�S�n (int x, int y) {

        super(x,y);
        voltHaszn�lva = false;
    }


    /**
     * voltHaszn�lva �rt�ket hamisra �ll�tja, minden l�ptet�s el�tt h�vni kell.
     */
    public void reset(){
        voltHaszn�lva =false;
    }

    /**
     * A keresztez�d�sbe �rkez� vonatot tov�bb�tja a megfelel� kimenetre
     * visszat�r�si �rt�ke att�l f�gg, hogy siker�l-e be�ll�tani a a megfelel�
     * v�ltoztat�sokat.
     *
     * @param v a tov�bb�tand� vonatelem
     * @param s megmutatja, honnan is �rkezett a vonatelem
     */
    public boolean tov�bb(VonatElem v, S�nElem s){
        S�nElem hova = null;

        /** Ha m�r volt haszn�lva, akkor �tk�z�s t�r�nt ebben a ciklusban */
        if (voltHaszn�lva)
            return false;

        /** a forr�s s�nelem indexe alapj�n vizsg�lunk */
        int i = befut�S�nek.indexOf(s);

        /** ha az index 2-n�l kisebb, akkor a p�rja (index+2) lesz */
        if(i < 2){
            hova = befut�S�nek.get(i+2);
        }
        /** ha az index legal�bb 2, akkor a p�rja (index-2) lesz */
        else if(i >= 2){
            hova = befut�S�nek.get(i-2);
        }
        if(hova == null){
            return false;
        } else{
            v.setPoz�ci�(hova);
            if(hova.getS�nv�g1()==this) v.setIr�ny(true); else v.setIr�ny(false);
        }

        voltHaszn�lva = true;
        return true;
    }


    /**
     * Keresztez�S�n kirajzol�sa a k�perny�re (narancss�rga pont).
     * @param g Graphic objektum amivel kirajzolunk a k�perny�re.
     */
    @Override
    public void rajzol(Graphics g) {

        /** k�z�pre igaz�tott narancss�rga telik�r a sz�molt m�retekkel*/

        g.setColor(Color.orange);
        int w = (int) (40 * Ikonok.getNagy�t�sCsp());
        int h = (int) (40 * Ikonok.getNagy�t�sCsp());
        g.fillOval(x-w/2,y-h/2,w,h);

    }
}
