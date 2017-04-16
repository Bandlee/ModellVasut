package Class.ModellVasut;

/**
 * Created by rolac on 2017. 04. 15..
 */
public class SzenesKocsi extends Kocsi {




    @Override
    protected void setLeszállhat(boolean leszállhat) {
        this.leszállhat = leszállhat;
        if (következõ != null) {
            következõ.setLeszállhat(leszállhat);
        }
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
