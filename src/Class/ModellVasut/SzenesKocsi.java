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


    public SzenesKocsi() {}

    /**
     *
     * Szem�lyKocsi konstruktor - belp�s�re v�r� Szem�lyKocsihoz
     * @param ve a vonat elem, ami ut�n ker�l a a kocsi
     */
    public SzenesKocsi( VonatElem ve) {
        ir�ny = true;
        setPoz�ci�(new S�nElem(ve.getPoz�ci�()));
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



    @Override
    public void rajzol(Graphics g) {
        if (tart�zkod�siHely!=null && tart�zkod�siHely.getL�that�()) {

            BufferedImage img;
            img = Ikonok.getIkon("Szenes.png");
            int w = (int) (img.getWidth() * Ikonok.getNagy�t�sVe());
            int h = (int) (img.getWidth() * Ikonok.getNagy�t�sVe());
            g.drawImage(img, tart�zkod�siHely.getX() - w / 2, tart�zkod�siHely.getY() - h / 2, w, h, null);

        }
    }
}
