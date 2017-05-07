package Class.ModellVasut;


import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * Grafikusan megjelenített síneket megvalósító osztály.
 * Created by Akos on 2017.05.02..
 */
public class GrafSín implements IMegjeleníthetõ {
    /** kirajzolásnál: elhelyezéshez, méretezéshez és forgatáshoz szükséges transzformáció*/
    private AffineTransform at;

    /** Az a levágott sínkép amit megjelenítünk */
    BufferedImage img;

    /**
     * Konstruktor, összeköt két csomópontot látható sínelemekkel
     * valamint beállítja a kirajzoláshoz zsükséges képet és transzformációt.
     * Összekötésnél a sínelemeken végighaladva a true irány jobbra haladást fog jelképezni,
     * a false iránya balra haladást.
     * @param cs1 a sín egyik vége
     * @param cs2 a sín másik vége
     */
    GrafSín(Csomópont cs1, Csomópont cs2){

        /** összekötés irányoknak megfelelõen*/
        if (cs1.getX()<=cs2.getX())
            SínElem.összeköt(cs1,cs2,true);
        else
            SínElem.összeköt(cs2,cs1,true);

        double x_dist = (cs2.getX()-cs1.getX());
        double y_dist = (cs2.getY()-cs1.getY());

        /**szakasz hossza*/
        double szh =  Math.sqrt(x_dist*x_dist + y_dist*y_dist);

        /**elforgatási szög*/
        double rad = Math.atan(y_dist/x_dist);



        img = Ikonok.getIkon("sinek_temp.png");

        /** képbõl levágunk szükséges hosszúságú darabot*/
        img = img.getSubimage(0,0,(int)szh,img.getHeight());


            //http://stackoverflow.com/questions/4918482/rotating-bufferedimage-instances
        /** transzformáció, a transzformáció lépéseit az utolsótól kezdve kell nézni*/
        at = new AffineTransform();

        /** kép elhelyezése két csomópont közé*/
        at.translate(cs1.getX()+x_dist/2,cs1.getY()+y_dist/2);

        /** kép forgatása*/
        at.rotate(rad);

        /** Kép méretezése, hosszt helybenhagyjuk */
        at.scale(1,Ikonok.getNagyításVe());

        /** 1. Kép transzformációs középpontja középre kerül */
        at.translate(-img.getWidth()/2,-img.getHeight()/2);




    }

    /**
     * Kirajzolja a sínt az ablakba a definiált transzformácionak megfelelõen.
     * @param g objektum amivel kirajzolunk a képernyõre.
     */
    @Override
    public void rajzol(Graphics g) {
            Graphics2D g2d= (Graphics2D) g;
            g2d.drawImage(img,at,null);
    }
}
