package Class.ModellVasut;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * SzenesKocsikat megval�s�t� oszt�ly. R�la nem sz�llhatnak le utasok.
 * Created by rolac on 2017. 04. 15..
 */
public class SzenesKocsi extends Kocsi {


    /**
     *
     * Szem�lyKocsi konstruktor - belp�s�re v�r� SzenesKocsihoz
     * @param ve a vonat elem, ami ut�n ker�l a a kocsi
     */
    public SzenesKocsi( VonatElem ve) {
        ir�ny = true;
        lesz�llhat = true;

        /** l�thatatlan S�nElem amir�l tov�bb l�pve egyszer eljut a mozdony bel�p�si pontj�hoz */
        setPoz�ci�(new S�nElem(ve.getPoz�ci�()));

        /** Bek�tia Szem�lyKocsit a megadott VonatElem m�g� */
        ve.setK�vetkez�(this);
    }


    /**
     * Be�ll�tja a szeneskocsi lesz�llhat �rt�k�t.
     * �res szemelykocsihoz hasonloan tov�bbadja a be�l�tott jogot a k�vetkez� kocsinak.
     *
     * @param lesz�llhat erre az �rt�kre �ll�tjuk be a szeneskocsi lesz�llhat �rt�k�t
     */
    @Override
    protected void setLesz�llhat(boolean lesz�llhat) {
        this.lesz�llhat = lesz�llhat;
        if (k�vetkez� != null) {
            k�vetkez�.setLesz�llhat(lesz�llhat);
        }
    }

    /**
     * Megmutatja, hogy sz�llhatnak-e le r�la utasok - nem.
     * @return hamis
     */
    public boolean getLesz�llhat(){
        return false;
    }


    /**
     * Hozz�k�ti a szeneskocsihoz a megadott kocsit, ez fog ut�na k�vetkezni.
     * Be�ll�tja a kocsinak a lesz�llhat jogosults�g�t a szeneskocsi lesz�llhat
     * jogosults�g�ra.
     *
     * @param k�vetkez� a kocsi, ami a szeneskocsihoz lesz k�tve.
     */
    @Override
    public void setK�vetkez�(Kocsi k�vetkez�) {
        this.k�vetkez� = k�vetkez�;
        k�vetkez�.setLesz�llhat(lesz�llhat);
    }


    /**
     * SzenesKocsi kirajzol�sa a k�perny�re
     * @param g Graphic objektum amivel kirajzolunk a k�perny�re.
     */
    @Override
    public void rajzol(Graphics g) {

        /** kirajzol�s csak ha l�that� S�nElemen tartozkodik*/
        if (tart�zkod�siHely!=null && tart�zkod�siHely.getL�that�()) {
            BufferedImage img;
            img = Ikonok.getIkon("Szenes.png");

            /** m�retez�s */
            int w = (int) (img.getWidth() * Ikonok.getNagy�t�sVe());
            int h = (int) (img.getWidth() * Ikonok.getNagy�t�sVe());

            /** kirajzol�s k�z�pre igaz�tva, az sz�molt m�retekkel*/
            g.drawImage(img, tart�zkod�siHely.getX() - w / 2, tart�zkod�siHely.getY() - h / 2, w, h, null);

        }
    }

}
