package Class.ModellVasut;

/**
 * Created by rolac on 2017. 04. 15..
 */
public class SzenesKocsi extends Kocsi {




    @Override
    protected void setLesz�llhat(boolean lesz�llhat) {
        this.lesz�llhat = lesz�llhat;
        if (k�vetkez� != null) {
            k�vetkez�.setLesz�llhat(lesz�llhat);
        }
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
}
