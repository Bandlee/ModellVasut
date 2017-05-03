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
        try {

            if (tart�zkod�siHely!=null && tart�zkod�siHely.getL�that�()) {
                //System.out.println(tart�zkod�siHely.getX()+" , " +tart�zkod�siHely.getY());
                BufferedImage img;
                img = ImageIO.read(new File("ikonok/szenes.png"));


                g.drawImage(img, tart�zkod�siHely.getX()-img.getWidth()/2, tart�zkod�siHely.getY()-img.getHeight()/2, null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
