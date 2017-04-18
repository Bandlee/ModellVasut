package Class.ModellVasut;

/**
 * Created by rolac on 2017. 04. 15..
 */
public class SzemélyKocsi extends Kocsi {

    private String szín;
    private boolean utas;

    public SzemélyKocsi(String _szin, boolean utasok) {
        szín = _szin;
        utas = utasok;
        System.out.println("Új "+szín+" SzemélyKocsi jött létre");
    }




    /**
     * A metódus megadja, hogy adott színû állomás mellett elhaladva szállnak-e le a szemelykocsiról utasok.
     * Amennyiben igen, ezt jelzi az utas tulajdonság beállításával, valamit engedélyezi az utána következõ
     * kocsinak a leszállást.
     *
     * @param s: Az állomás színét jelöli a paraméter, a szemelykocsi színének egyeznie kell ezzel, ahoz,
     *           hogy leszállás történhessen.
     */
    @Override
    public boolean ellenõriz(String s){

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
     * A metódus megadja, hogy adott színû állomás mellett elhaladva szállnak-e fel a szemelykocsira utasok.
     * Amennyiben igen, ezt jelzi az utas tulajdonság beállításával, valamit tíltja az utána következõ
     * kocsinak a leszállást.
     *
     * @param s: Az állomás színét jelöli a paraméter, ez alapján fogjuk eldönteni,
     *           hogy szállhatnak-e fel utasok az adott szemelykocsira a megadott színû állomáson.
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
     * Beállítja a szemelykocsi leszállhat értékét.
     * Hamis érték esetén értesíti a mögötte lévõ kocsit, beállíja leszállhat értékét hamisra.
     * Igaz érték esetén, ha nincs utas a szemelykocsiban, beállítja a következõ
     * kocsi leszállhat értéket igazra.
     *
     * @param leszállhat erre az értékre állítjuk be a szemelykocsi leszállhat értékét
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
     * Hozzáköti a szemelykocsihoz a megadott kocsit, ez fog utána következni.
     * Beállítja a kocsinak a leszállhat jogosultságát a szemelykocsi
     * tulajdonságainak megfelelõen: ha van utas, vagy leszállhat false, akkor
     * a beállított érték false, különben marad true.
     *
     * @param következõ a kocsi, ami a szemelykocsihoz lesz kötve.
     */
    @Override
    public void setKövetkezõ(Kocsi következõ) {
        this.következõ = következõ;

        if (utas == true || leszállhat == false) {
            következõ.setLeszállhat(false);
        }
        //leszálhat létrehozáskor true
    }


    @Override
    public boolean getUtas(){return utas;}

    @Override
    public boolean getLeszállhat(){return leszállhat;}
}
