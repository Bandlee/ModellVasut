package Class.ModellVasut;

import java.awt.*;

/**
 * A keresztezõ síneket megvalósító osztály
 * @author Peti
 * @version 1.0
 * @created 15-ápr.-2017 17:02:41
 */

/**
 * Az egymást keresztezõ sínek kapcsolódási pontját megvalósító osztály
 */
public class KeresztezõSín extends Csomópont {

    /** Megadja, hogy az adott ciklusban volt-e már használva a KeresztezõSín */
    private boolean voltHasználva;

    /**
     * A KeresztezõSínt Csomópontként, annak konstruktorával hozzuk létre.
     * A sínpárokat azok index-ével fogjuk azonosítani:
     * Összetartoznak a 0, 2 indexû és az 1, 3 indexû SínElemek
     */
    public KeresztezõSín (int x, int y) {

        super(x,y);
        voltHasználva = false;
    }


    /**
     * voltHasználva értéket hamisra állítja, minden léptetés elõtt hívni kell.
     */
    public void reset(){
        voltHasználva =false;
    }

    /**
     * A keresztezõdésbe érkezõ vonatot továbbítja a megfelelõ kimenetre
     * visszatérési értéke attól függ, hogy sikerül-e beállítani a a megfelelõ
     * változtatásokat.
     *
     * @param v a továbbítandó vonatelem
     * @param s megmutatja, honnan is érkezett a vonatelem
     */
    public boolean tovább(VonatElem v, SínElem s){
        SínElem hova = null;

        /** Ha már volt használva, akkor ütközés törént ebben a ciklusban */
        if (voltHasználva)
            return false;

        /** a forrás sínelem indexe alapján vizsgálunk */
        int i = befutóSínek.indexOf(s);

        /** ha az index 2-nél kisebb, akkor a párja (index+2) lesz */
        if(i < 2){
            hova = befutóSínek.get(i+2);
        }
        /** ha az index legalább 2, akkor a párja (index-2) lesz */
        else if(i >= 2){
            hova = befutóSínek.get(i-2);
        }
        if(hova == null){
            return false;
        } else{
            v.setPozíció(hova);
            if(hova.getSínvég1()==this) v.setIrány(true); else v.setIrány(false);
        }

        voltHasználva = true;
        return true;
    }


    /**
     * KeresztezõSín kirajzolása a képernyõre (narancssárga pont).
     * @param g Graphic objektum amivel kirajzolunk a képernyõre.
     */
    @Override
    public void rajzol(Graphics g) {

        /** középre igazított narancssárga telikör a számolt méretekkel*/

        g.setColor(Color.orange);
        int w = (int) (40 * Ikonok.getNagyításCsp());
        int h = (int) (40 * Ikonok.getNagyításCsp());
        g.fillOval(x-w/2,y-h/2,w,h);

    }
}
