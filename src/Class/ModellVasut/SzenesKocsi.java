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
     *
     * SzemélyKocsi konstruktor - belpésére váró SzenesKocsihoz
     * @param ve a vonat elem, ami után kerül a a kocsi
     */
    public SzenesKocsi( VonatElem ve) {
        irány = true;
        leszállhat = true;

        /** láthatatlan SínElem amirõl tovább lépve egyszer eljut a mozdony belépési pontjához */
        setPozíció(new SínElem(ve.getPozíció()));

        /** Bekötia SzemélyKocsit a megadott VonatElem mögé */
        ve.setKövetkezõ(this);
    }


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


    /**
     * SzenesKocsi kirajzolása a képernyõre
     * @param g Graphic objektum amivel kirajzolunk a képernyõre.
     */
    @Override
    public void rajzol(Graphics g) {

        /** kirajzolás csak ha látható SínElemen tartozkodik*/
        if (tartózkodásiHely!=null && tartózkodásiHely.getLátható()) {
            BufferedImage img;
            img = Ikonok.getIkon("Szenes.png");

            /** méretezés */
            int w = (int) (img.getWidth() * Ikonok.getNagyításVe());
            int h = (int) (img.getWidth() * Ikonok.getNagyításVe());

            /** kirajzolás középre igazítva, az számolt méretekkel*/
            g.drawImage(img, tartózkodásiHely.getX() - w / 2, tartózkodásiHely.getY() - h / 2, w, h, null);

        }
    }

}
