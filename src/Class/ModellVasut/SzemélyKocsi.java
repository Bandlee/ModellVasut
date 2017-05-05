package Class.ModellVasut;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Utasokat sz�ll�t� kocsikat megval�s�t� oszt�ly, a kocsi oszt�ly lesz�rmazottja
 * Created by rolac on 2017. 04. 15..
 */
public class Szem�lyKocsi extends Kocsi {

    private String sz�n;
    private boolean utas;

    /**
     * Szem�lyKocsi konstruktor
     * @param _szin a kocsi sz�ne
     * @param utasok megmutatja, hogy vannak-e utasok a kocsin
     */
    public Szem�lyKocsi(String _szin, boolean utasok) {
        sz�n = _szin;
        utas = utasok;
    }

    /**
     *
     * Szem�lyKocsi konstruktor - belp�s�re v�r� Szem�lyKocsihoz
     * @param _szin a kocsi sz�ne
     * @param utasok megmutatja, hogy vannak-e utasok a kocsin
     * @param ve a vonat elem, ami ut�n ker�l a a kocsi
     */
    public Szem�lyKocsi(String _szin, boolean utasok, VonatElem ve) {
        sz�n = _szin;
        utas = utasok;
        ir�ny = true;
        lesz�llhat= true;
        setPoz�ci�(new S�nElem(ve.getPoz�ci�()));
        ve.setK�vetkez�(this);
    }



    /**
     * A met�dus megadja, hogy adott sz�n� �llom�s mellett elhaladva sz�llnak-e le a Szem�lyKocsir�l utasok.
     * Amennyiben igen, ezt jelzi az utas tulajdons�g be�ll�t�s�val, valamit enged�lyezi az ut�na k�vetkez�
     * kocsinak a lesz�ll�st.
     *
     * @param s: Az �llom�s sz�n�t jel�li a param�ter, a Szem�lyKocsi sz�n�nek egyeznie kell ezzel, ahoz,
     *           hogy lesz�ll�s t�rt�nhessen.
     */
    @Override
    public boolean ellen�riz(String s){
        if (utas==false) return false;
        if (lesz�llhat && sz�n.equals(s)) {
            utas = false;

            if (k�vetkez� != null) {
                //lesz�lltak -> k�vetkez� enged�lyez�se
                k�vetkez�.setLesz�llhat(true);
            }
            return true;
        }

        return false;
    }


    /**
     * A met�dus megadja, hogy adott sz�n� �llom�s mellett elhaladva sz�llnak-e fel a Szem�lyKocsira utasok.
     * Amennyiben igen, ezt jelzi az utas tulajdons�g be�ll�t�s�val, valamit t�ltja az ut�na k�vetkez�
     * kocsinak a lesz�ll�st.
     *
     * @param s: Az �llom�s sz�n�t jel�li a param�ter, ez alapj�n fogjuk eld�nteni,
     *           hogy sz�llhatnak-e fel utasok az adott Szem�lyKocsira a megadott sz�n� �llom�son.
     */
    @Override
    public boolean felEllen�riz(String s){

        if (utas == false && sz�n.equals(s)) {
            utas = true;
            if (k�vetkez� != null) {
                //felsz�lltak -> k�vetkez� tilt�sa
                k�vetkez�.setLesz�llhat(false);
            }
            return true;
        }

        return false;
    }


    /**
     * Be�ll�tja a Szem�lyKocsi lesz�llhat �rt�k�t.
     * Hamis �rt�k eset�n �rtes�ti a m�g�tte l�v� kocsit, be�ll�ja lesz�llhat �rt�k�t hamisra.
     * Igaz �rt�k eset�n, ha nincs utas a Szem�lyKocsiban, be�ll�tja a k�vetkez�
     * kocsi lesz�llhat �rt�ket igazra.
     *
     * @param lesz�llhat erre az �rt�kre �ll�tjuk be a Szem�lyKocsi lesz�llhat �rt�k�t
     */
    @Override
    protected void setLesz�llhat(boolean lesz�llhat) {

        this.lesz�llhat = lesz�llhat;
        if (k�vetkez� != null) {
            //tilt�s tov�bbad�sa pl ha felsz�ll�s t�rt�nik
            if (lesz�llhat == false) {
                k�vetkez�.setLesz�llhat(false);
            }
            //enged�ly tov�bbad�sa, csak akkor, ha az aktu�lis Szem�lyKocsi �res
            else if (utas == false) {
                k�vetkez�.setLesz�llhat(true);
            }
        }
    }

    /**
     * Hozz�k�ti a Szem�lyKocsihoz a megadott kocsit, ez fog ut�na k�vetkezni.
     * Be�ll�tja a kocsinak a lesz�llhat jogosults�g�t a Szem�lyKocsi
     * tulajdons�gainak megfelel�en: ha van utas, vagy lesz�llhat false, akkor
     * a be�ll�tott �rt�k false, k�l�nben marad true.
     *
     * @param k�vetkez� a kocsi, ami a Szem�lyKocsihoz lesz k�tve.
     */
    @Override
    public void setK�vetkez�(Kocsi k�vetkez�) {
        this.k�vetkez� = k�vetkez�;

        if (utas == true || lesz�llhat == false) {
            k�vetkez�.setLesz�llhat(false);
        }
        //lesz�lhat l�trehoz�skor true
    }

    /**
     * Megmutatja, hogy van-e utas a Szem�lyKocsiban
     * @return utas param�ter
     */
    @Override
    public boolean getUtas(){return utas;}

    /**
     * Megmutatja, hogy az utasok lesz�llhatnak-e a kocsir�l, az adott param�ter �rt�k�t adja vissza.
     * @return lesz�llhat param�ter �rt�ke
     */
    @Override
    public boolean getLesz�llhat(){return lesz�llhat;}


    @Override
    public void rajzol(Graphics g) {
        if (tart�zkod�siHely!=null && tart�zkod�siHely.getL�that�()) {

            BufferedImage img;
            img = Ikonok.getIkon("Kocsi_"+sz�n + (utas ? "_tele.png" : "_ures.png") );

            if (img == null){
                //ha a k�p nem lett beolvasva
                g.setColor(Color.MAGENTA);
                g.drawRect(tart�zkod�siHely.getX()-15,tart�zkod�siHely.getY()-15,30,30);
                return;
            }

            int w = (int) (img.getWidth() * Ikonok.getNagy�t�sVe());
            int h = (int) (img.getHeight() * Ikonok.getNagy�t�sVe());
            g.drawImage(img, tart�zkod�siHely.getX() - w / 2, tart�zkod�siHely.getY() - h / 2, w, h, null);

        }
		/*try {

			if (tart�zkod�siHely!=null && tart�zkod�siHely.getL�that�()) {
				//System.out.println(tart�zkod�siHely.getX()+" , " +tart�zkod�siHely.getY());
				BufferedImage img;
				if (ir�ny) img = ImageIO.read(new File("ikonok/Mozdony_jobb.png"));
				else img = ImageIO.read(new File("ikonok/Mozdony_bal.png"));

				g.drawImage(img, tart�zkod�siHely.getX()-img.getWidth()/2, tart�zkod�siHely.getY()-img.getHeight()/2, null);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/

    }

}
