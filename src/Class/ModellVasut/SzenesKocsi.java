package Class.ModellVasut;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * SzenesKocsikat megvalósító osztály. Róla nem szállhatnak le utasok.
 * Created by rolac on 2017. 04. 15..
 */
public class SzenesKocsi extends Kocsi {


    /**
     * Beállítja a szeneskocsi leszállhat értékét.
     * Üres szemelykocsihoz hasonloan továbbadja a beálított jogot a következõ kocsinak.
     *
     * @param leszállhat erre az értékre állítjuk be a szeneskocsi leszállhat értékét
     */
    @Override
    protected void setLeszállhat(boolean leszállhat) {
        this.leszállhat = leszállhat;
        if (következõ != null) {
            következõ.setLeszállhat(leszállhat);
        }
    }

    /**
     * Megmutatja, hogy szállhatnak-e le róla utasok - nem.
     * @return hamis
     */
    public boolean getLeszállhat(){
        return false;
    }


    /**
     * Hozzáköti a szeneskocsihoz a megadott kocsit, ez fog utána következni.
     * Beállítja a kocsinak a leszállhat jogosultságát a szeneskocsi leszállhat
     * jogosultságára.
     *
     * @param következõ a kocsi, ami a szeneskocsihoz lesz kötve.
     */
    @Override
    public void setKövetkezõ(Kocsi következõ) {
        this.következõ = következõ;
        következõ.setLeszállhat(leszállhat);
    }



    @Override
    public void rajzol(Graphics g) {
        try {

            if (tartózkodásiHely!=null && tartózkodásiHely.getLátható()) {
                //System.out.println(tartózkodásiHely.getX()+" , " +tartózkodásiHely.getY());
                BufferedImage img;
                img = ImageIO.read(new File("ikonok/szenes.png"));


                g.drawImage(img, tartózkodásiHely.getX()-img.getWidth()/2, tartózkodásiHely.getY()-img.getHeight()/2, null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
