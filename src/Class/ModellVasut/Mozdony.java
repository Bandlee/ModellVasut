package Class.ModellVasut;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A mozdonyokat megvalósító osztály. A vonatelem leszármazottja
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public class Mozdony extends VonatElem {

	private Csomópont belépésipont;
	private int késleltetés;

	/**
	 * Mozdony osztály konstruktora
	 * @param b a mozdony belépési pontja
	 * @param k a mozdony késleltetése
	 */
	public Mozdony(Csomópont b, int k){
		késleltetés = k;
		belépésipont = b;
		irány = true;
		setPozíció(new SínElem(b)); //láthatatlan sín amirõl tovább lép, ha elindult
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * Közvetlenül a játék lefolyását kezelõ osztályból hívódik. Meghívja a vonat mozgatásáért felelõs függvényt, ha
	 * annak már a pályán kellene lennie (késleltetés == 0), különben csökkenti a késleltetést
	 */
	public void tickAkció()throws VegException{
		if(késleltetés == 0) {
			mozgat();
			if(következõ != null) következõ.tickAkció();
		} else {
			késleltetés--;
		}
	}


	/**
	 * Hozzáköti a mozdonyhoz a megadott kocsit, ez fog utána következni.
	 *
	 * @param következõ a kocsi, ami a mozdonyhoz lesz kötve.
	 */
	@Override
	public void setKövetkezõ(Kocsi következõ) {
		this.következõ = következõ;
	}

	/**
	 * Visszaadja a mozdony késleltetését.
	 * @return késleltetés
	 */
	public int getKésleltetés(){return késleltetés;}

	/**
	 * Visszaadja a mozdony belépési pontját
	 * @return belépési pont
	 */
	public Csomópont getBelépésiPont(){
		return belépésipont;
	}

	@Override
	public void rajzol(Graphics g) {
		if (tartózkodásiHely!=null && tartózkodásiHely.getLátható()) {

			BufferedImage img;
			if (irány) img = Ikonok.getIkon("Mozdony_jobb.png");
			else img = Ikonok.getIkon("Mozdony_bal.png");
			int w = (int) (img.getWidth() * Ikonok.getNagyításVe());
			int h = (int) (img.getWidth() * Ikonok.getNagyításVe());
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