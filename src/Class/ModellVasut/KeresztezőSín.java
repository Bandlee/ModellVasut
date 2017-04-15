package Class.ModellVasut;

import java.util.List;

/**
 * @author Peti
 * @version 1.0
 * @created 15-�pr.-2017 17:02:41
 */

/**
 * Az egym�st keresztez� s�nek kapcsol�d�si pontj�t megval�s�t� oszt�ly
 */
public class Keresztez�S�n extends Csom�pont {

    /**
     * A Keresztez�S�nt Csom�pontk�nt, annak konstruktor�val hozzuk l�tre.
     * A s�np�rokat azok index-�vel fogjuk azonos�tani:
     * �sszetartoznak a 0, 2 index� �s az 1, 3 index� S�nElemek
     */
    public Keresztez�S�n (int a, int b, List<S�nElem> list) {
        super(a, b, list);
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
        try{
            S�nElem hova = null;

            // a forr�s s�nelem indexe alapj�n vizsg�lunk
            int i = befut�S�nek.indexOf(s);

            // ha az index 2-n�l kisebb, akkor a p�rja (index+2) lesz
            if(i < 2){
                hova = befut�S�nek.get(i+2);
            }
            // ha az index legal�bb 2, akkor a p�rja (index-2) lesz
            else if(i >= 2){
                hova = befut�S�nek.get(i-2);
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

}
