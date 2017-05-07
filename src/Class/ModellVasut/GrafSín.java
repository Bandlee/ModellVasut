package Class.ModellVasut;


import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * Grafikusan megjelen�tett s�neket megval�s�t� oszt�ly.
 * Created by Akos on 2017.05.02..
 */
public class GrafS�n implements IMegjelen�thet� {
    /** kirajzol�sn�l: elhelyez�shez, m�retez�shez �s forgat�shoz sz�ks�ges transzform�ci�*/
    private AffineTransform at;

    /** Az a lev�gott s�nk�p amit megjelen�t�nk */
    BufferedImage img;

    /**
     * Konstruktor, �sszek�t k�t csom�pontot l�that� s�nelemekkel
     * valamint be�ll�tja a kirajzol�shoz zs�ks�ges k�pet �s transzform�ci�t.
     * �sszek�t�sn�l a s�nelemeken v�gighaladva a true ir�ny jobbra halad�st fog jelk�pezni,
     * a false ir�nya balra halad�st.
     * @param cs1 a s�n egyik v�ge
     * @param cs2 a s�n m�sik v�ge
     */
    GrafS�n(Csom�pont cs1, Csom�pont cs2){

        /** �sszek�t�s ir�nyoknak megfelel�en*/
        if (cs1.getX()<=cs2.getX())
            S�nElem.�sszek�t(cs1,cs2,true);
        else
            S�nElem.�sszek�t(cs2,cs1,true);

        double x_dist = (cs2.getX()-cs1.getX());
        double y_dist = (cs2.getY()-cs1.getY());

        /**szakasz hossza*/
        double szh =  Math.sqrt(x_dist*x_dist + y_dist*y_dist);

        /**elforgat�si sz�g*/
        double rad = Math.atan(y_dist/x_dist);



        img = Ikonok.getIkon("sinek_temp.png");

        /** k�pb�l lev�gunk sz�ks�ges hossz�s�g� darabot*/
        img = img.getSubimage(0,0,(int)szh,img.getHeight());


            //http://stackoverflow.com/questions/4918482/rotating-bufferedimage-instances
        /** transzform�ci�, a transzform�ci� l�p�seit az utols�t�l kezdve kell n�zni*/
        at = new AffineTransform();

        /** k�p elhelyez�se k�t csom�pont k�z�*/
        at.translate(cs1.getX()+x_dist/2,cs1.getY()+y_dist/2);

        /** k�p forgat�sa*/
        at.rotate(rad);

        /** K�p m�retez�se, hosszt helybenhagyjuk */
        at.scale(1,Ikonok.getNagy�t�sVe());

        /** 1. K�p transzform�ci�s k�z�ppontja k�z�pre ker�l */
        at.translate(-img.getWidth()/2,-img.getHeight()/2);




    }

    /**
     * Kirajzolja a s�nt az ablakba a defini�lt transzform�cionak megfelel�en.
     * @param g objektum amivel kirajzolunk a k�perny�re.
     */
    @Override
    public void rajzol(Graphics g) {
            Graphics2D g2d= (Graphics2D) g;
            g2d.drawImage(img,at,null);
    }
}
