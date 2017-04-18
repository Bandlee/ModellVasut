package Class.ModellVasut;

/**
 * SzenesKocsikat megvalósító osztály. Róla nem szállhatnak le utasok.
 * Created by rolac on 2017. 04. 15..
 */
public class SzenesKocsi extends Kocsi {

    /**
     * SzenesKocsi konstruktor
     */
    public SzenesKocsi(){
        System.out.println("Új SzenesKocsi jött létre");
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
}
