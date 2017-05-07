package Class.ModellVasut;


import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * VonatElemet megvalósító osztály
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public class VonatElem implements IMegjeleníthetõ {

	protected boolean irány;
	protected SínElem tartózkodásiHely;
	protected Kocsi következõ;


	/**
	 * megmutatja, hogy van-e utas a vonatelemen.
	 * @return hamissal tér vissza, azokban az esetekben, ahol lehet utas, felülírjuk a metódust
	 */
	public boolean getUtas(){return false;}

	/**
	 * megmutatja, hogy szállhat-e le utas a vonatelemrõl
	 * @return hamis - ha speciális eset van, akkor felülíródik majd a metódus
	 */
	public boolean getLeszállhat(){return false;}

	public void finalize() throws Throwable {

	}

	/**
	 *
	 * @param s
	 * @return
	 */
	public boolean ellenõriz(String s){
		if(this.getUtas() && this.getLeszállhat()) return true;
		else return false;
	}


	/**
	 * A metódus megadja, hogy adott színû állomás mellett elhaladva szállnak-e fel a vonatelemre utasok.
	 * Visszatérési értéke false, vagyis biztosan nem szállnak fel utasok. Azoknál a VonatElem õsû osztályoknál,
	 * amelyeknél utasok felszállhatnak, felül kell írni ezt a metódust.
	 *
	 * @param s: Az állomás színét jelöli, ami mellett elhalad a VonatElem.
	 */
	public boolean felEllenõriz(String s){
		return false;
	}


	/**
	 * Visszaadja a vonatelem haladási irányát.
	 * @return a visszaadott irány
	 */
	public boolean getIrány(){
		return irány;
	}

	/**
	 * Visszaadja a VonatElem aktuális pozícióját.
	 * @return az aktuális pozíció - sínelem
	 */
	public SínElem getPozíció(){
		return tartózkodásiHely;
	}

	/**
	 *	Adott vonat elem következõ sínelemre helyezését irányítja
	 *	benne kerül sor ütközésdetektálásra is. érzékeli, ha játék végét jelentõ eset következik be
	 */
	public void mozgat()throws VegException{





		if(irány) {
			if(tartózkodásiHely.getKövetkezõ() == null) {
				boolean tmp = tartózkodásiHely.keresztez(irány, this);
				if(!tmp){
					JátékVége v = new JátékVége();
					v.vég();
					return;
				}
			} else {
				setPozíció(tartózkodásiHely.getKövetkezõ());
			}
		} else {
            if(tartózkodásiHely.getElõzõ() == null) {
                boolean tmp = tartózkodásiHely.keresztez(irány, this);
                if (!tmp) {
                    JátékVége v = new JátékVége();
                    v.vég();
                    return;
                }
            } else {
                setPozíció(tartózkodásiHely.getElõzõ());
            }
		}



		/**ellenörzi, hogy ahova került ott van-e olyan vonatelem, ami ellentétes irányú
		 * azonos irányú vonatelemmel történõ ütközést nem detektál, helyes pályafileoknál nem okoz gondot*/
        if (tartózkodásiHely.getÁthaladóElem()!=null &&tartózkodásiHely.getÁthaladóElem().irány != this.irány){
            JátékVége v = new JátékVége();
            v.vég();
        } else {
            tartózkodásiHely.setÁthaladóElem(this);
        }

        //redundáns a feljebb lévõ 6 sor mellett
		//átlépés nem lehet, mivel a vonatokat "egyenként" léptetjük és nem egyszerre
		//tesztelést igényelhet
		/*boolean ütköz = tartózkodásiHely.ütközésElõrejelez();
		if(!ütköz) {
			JátékVége v = new JátékVége();
			v.vég();
		}*/


}

	/**
	 * beállítja a vonatelem mozgásának irányát
	 * @param i az irányt jelzõ paraméter
	 */
	public void setIrány(boolean i){
		irány = i;
	}

	/**
	 * beállítja a vonatelem pozícióját, hogy mely sínelemen tartózkodik éppen
	 * @param s az aktuális tartózkodási helyet reprezentáló paraméter
	 */
	public void setPozíció(SínElem s){
		//kírja magát, ha a tartozkodási helyre nem ö van beregisztrálva
//		if (tartózkodásiHely!=null)
//		if (tartózkodásiHely.getÁthaladóElem() !=this) {
//			System.out.println(this.toString());
//		}
		/**csak akkor jelentkezik le a sínelemrõl ha õ van oda beregisztrálva
		 * (megakadályozva, hogy pl mögötte haladó elemet (ami elõbb lépett) jelentkeztessen le*/
 		if (tartózkodásiHely!=null && tartózkodásiHely.getÁthaladóElem()== this)
			tartózkodásiHely.setÁthaladóElem(null);


		tartózkodásiHely = s;
    }


	/**
	 * Hozzáköti a vonatelemhez a megadott kocsit, ez fog utána következni.
	 *
	 * @param _következõ a kocsi, ami a vonatelemhez lesz kötve.
	 */
	public void setKövetkezõ(Kocsi _következõ){
	    következõ=_következõ;
    }

	/**
	 * Visszaadja a következõ, az aktuális vonatelem után álló kocsit.
	 * @return a visszaadott kocsi
	 */
	public Kocsi getKövetkezõ(){return következõ;}

	//placeholder, nem lesz megvalósítva
	@Override
	public void rajzol(Graphics g) {
		try {

			if (tartózkodásiHely!=null && tartózkodásiHely.getLátható()) {
				//System.out.println(tartózkodásiHely.getX()+" , " +tartózkodásiHely.getY());
				BufferedImage img = ImageIO.read(new File("ve.png"));
				g.drawImage(img, tartózkodásiHely.getX()-img.getWidth()/2, tartózkodásiHely.getY()-img.getHeight()/2, null);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}