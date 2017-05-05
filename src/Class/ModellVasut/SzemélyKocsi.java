package Class.ModellVasut;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Utasokat szállító kocsikat megvalósító osztály, a kocsi osztály leszármazottja
 * Created by rolac on 2017. 04. 15..
 */
public class SzemélyKocsi extends Kocsi {

    private String szín;
    private boolean utas;

    /**
     * SzemélyKocsi konstruktor
     * @param _szin a kocsi színe
     * @param utasok megmutatja, hogy vannak-e utasok a kocsin
     */
    public SzemélyKocsi(String _szin, boolean utasok) {
        szín = _szin;
        utas = utasok;
    }

    /**
     *
     * SzemélyKocsi konstruktor - belpésére váró SzemályKocsihoz
     * @param _szin a kocsi színe
     * @param utasok megmutatja, hogy vannak-e utasok a kocsin
     * @param ve a vonat elem, ami után kerül a a kocsi
     */
    public SzemélyKocsi(String _szin, boolean utasok, VonatElem ve) {
        szín = _szin;
        utas = utasok;
        irány = true;
        leszállhat= true;
        setPozíció(new SínElem(ve.getPozíció()));
        ve.setKövetkezõ(this);
    }



    /**
     * A metódus megadja, hogy adott színû állomás mellett elhaladva szállnak-e le a SzemélyKocsiról utasok.
     * Amennyiben igen, ezt jelzi az utas tulajdonság beállításával, valamit engedélyezi az utána következõ
     * kocsinak a leszállást.
     *
     * @param s: Az állomás színét jelöli a paraméter, a SzemélyKocsi színének egyeznie kell ezzel, ahoz,
     *           hogy leszállás történhessen.
     */
    @Override
    public boolean ellenõriz(String s){
        if (utas==false) return false;
        if (leszállhat && szín.equals(s)) {
            utas = false;

            if (következõ != null) {
                //leszálltak -> következõ engedélyezése
                következõ.setLeszállhat(true);
            }
            return true;
        }

        return false;
    }


    /**
     * A metódus megadja, hogy adott színû állomás mellett elhaladva szállnak-e fel a SzemélyKocsira utasok.
     * Amennyiben igen, ezt jelzi az utas tulajdonság beállításával, valamit tíltja az utána következõ
     * kocsinak a leszállást.
     *
     * @param s: Az állomás színét jelöli a paraméter, ez alapján fogjuk eldönteni,
     *           hogy szállhatnak-e fel utasok az adott SzemélyKocsira a megadott színû állomáson.
     */
    @Override
    public boolean felEllenõriz(String s){

        if (utas == false && szín.equals(s)) {
            utas = true;
            if (következõ != null) {
                //felszálltak -> következõ tiltása
                következõ.setLeszállhat(false);
            }
            return true;
        }

        return false;
    }


    /**
     * Beállítja a SzemélyKocsi leszállhat értékét.
     * Hamis érték esetén értesíti a mögötte lévõ kocsit, beállíja leszállhat értékét hamisra.
     * Igaz érték esetén, ha nincs utas a SzemélyKocsiban, beállítja a következõ
     * kocsi leszállhat értéket igazra.
     *
     * @param leszállhat erre az értékre állítjuk be a SzemélyKocsi leszállhat értékét
     */
    @Override
    protected void setLeszállhat(boolean leszállhat) {

        this.leszállhat = leszállhat;
        if (következõ != null) {
            //tiltás továbbadása pl ha felszállás történik
            if (leszállhat == false) {
                következõ.setLeszállhat(false);
            }
            //engedély továbbadása, csak akkor, ha az aktuális SzemélyKocsi üres
            else if (utas == false) {
                következõ.setLeszállhat(true);
            }
        }
    }

    /**
     * Hozzáköti a SzemélyKocsihoz a megadott kocsit, ez fog utána következni.
     * Beállítja a kocsinak a leszállhat jogosultságát a SzemélyKocsi
     * tulajdonságainak megfelelõen: ha van utas, vagy leszállhat false, akkor
     * a beállított érték false, különben marad true.
     *
     * @param következõ a kocsi, ami a SzemélyKocsihoz lesz kötve.
     */
    @Override
    public void setKövetkezõ(Kocsi következõ) {
        this.következõ = következõ;

        if (utas == true || leszállhat == false) {
            következõ.setLeszállhat(false);
        }
        //leszálhat létrehozáskor true
    }

    /**
     * Megmutatja, hogy van-e utas a SzemélyKocsiban
     * @return utas paraméter
     */
    @Override
    public boolean getUtas(){return utas;}

    /**
     * Megmutatja, hogy az utasok leszállhatnak-e a kocsiról, az adott paraméter értékét adja vissza.
     * @return leszállhat paraméter értéke
     */
    @Override
    public boolean getLeszállhat(){return leszállhat;}


    @Override
    public void rajzol(Graphics g) {
        if (tartózkodásiHely!=null && tartózkodásiHely.getLátható()) {

            BufferedImage img;
            img = Ikonok.getIkon("Kocsi_"+szín + (utas ? "_tele.png" : "_ures.png") );

            if (img == null){
                //ha a kép nem lett beolvasva
                g.setColor(Color.MAGENTA);
                g.drawRect(tartózkodásiHely.getX()-15,tartózkodásiHely.getY()-15,30,30);
                return;
            }

            int w = (int) (img.getWidth() * Ikonok.getNagyításVe());
            int h = (int) (img.getHeight() * Ikonok.getNagyításVe());
            g.drawImage(img, tartózkodásiHely.getX() - w / 2, tartózkodásiHely.getY() - h / 2, w, h, null);

        }
		/*try {

			if (tartózkodásiHely!=null && tartózkodásiHely.getLátható()) {
				//System.out.println(tartózkodásiHely.getX()+" , " +tartózkodásiHely.getY());
				BufferedImage img;
				if (irány) img = ImageIO.read(new File("ikonok/Mozdony_jobb.png"));
				else img = ImageIO.read(new File("ikonok/Mozdony_bal.png"));

				g.drawImage(img, tartózkodásiHely.getX()-img.getWidth()/2, tartózkodásiHely.getY()-img.getHeight()/2, null);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/

    }

}
