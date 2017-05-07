package Class.ModellVasut;


import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * VonatElemet megval�s�t� oszt�ly
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public class VonatElem implements IMegjelen�thet� {

	protected boolean ir�ny;
	protected S�nElem tart�zkod�siHely;
	protected Kocsi k�vetkez�;


	/**
	 * megmutatja, hogy van-e utas a vonatelemen.
	 * @return hamissal t�r vissza, azokban az esetekben, ahol lehet utas, fel�l�rjuk a met�dust
	 */
	public boolean getUtas(){return false;}

	/**
	 * megmutatja, hogy sz�llhat-e le utas a vonatelemr�l
	 * @return hamis - ha speci�lis eset van, akkor fel�l�r�dik majd a met�dus
	 */
	public boolean getLesz�llhat(){return false;}

	public void finalize() throws Throwable {

	}

	/**
	 *
	 * @param s
	 * @return
	 */
	public boolean ellen�riz(String s){
		if(this.getUtas() && this.getLesz�llhat()) return true;
		else return false;
	}


	/**
	 * A met�dus megadja, hogy adott sz�n� �llom�s mellett elhaladva sz�llnak-e fel a vonatelemre utasok.
	 * Visszat�r�si �rt�ke false, vagyis biztosan nem sz�llnak fel utasok. Azokn�l a VonatElem �s� oszt�lyokn�l,
	 * amelyekn�l utasok felsz�llhatnak, fel�l kell �rni ezt a met�dust.
	 *
	 * @param s: Az �llom�s sz�n�t jel�li, ami mellett elhalad a VonatElem.
	 */
	public boolean felEllen�riz(String s){
		return false;
	}


	/**
	 * Visszaadja a vonatelem halad�si ir�ny�t.
	 * @return a visszaadott ir�ny
	 */
	public boolean getIr�ny(){
		return ir�ny;
	}

	/**
	 * Visszaadja a VonatElem aktu�lis poz�ci�j�t.
	 * @return az aktu�lis poz�ci� - s�nelem
	 */
	public S�nElem getPoz�ci�(){
		return tart�zkod�siHely;
	}

	/**
	 *	Adott vonat elem k�vetkez� s�nelemre helyez�s�t ir�ny�tja
	 *	benne ker�l sor �tk�z�sdetekt�l�sra is. �rz�keli, ha j�t�k v�g�t jelent� eset k�vetkezik be
	 */
	public void mozgat()throws VegException{





		if(ir�ny) {
			if(tart�zkod�siHely.getK�vetkez�() == null) {
				boolean tmp = tart�zkod�siHely.keresztez(ir�ny, this);
				if(!tmp){
					J�t�kV�ge v = new J�t�kV�ge();
					v.v�g();
					return;
				}
			} else {
				setPoz�ci�(tart�zkod�siHely.getK�vetkez�());
			}
		} else {
            if(tart�zkod�siHely.getEl�z�() == null) {
                boolean tmp = tart�zkod�siHely.keresztez(ir�ny, this);
                if (!tmp) {
                    J�t�kV�ge v = new J�t�kV�ge();
                    v.v�g();
                    return;
                }
            } else {
                setPoz�ci�(tart�zkod�siHely.getEl�z�());
            }
		}



		/**ellen�rzi, hogy ahova ker�lt ott van-e olyan vonatelem, ami ellent�tes ir�ny�
		 * azonos ir�ny� vonatelemmel t�rt�n� �tk�z�st nem detekt�l, helyes p�lyafileokn�l nem okoz gondot*/
        if (tart�zkod�siHely.get�thalad�Elem()!=null &&tart�zkod�siHely.get�thalad�Elem().ir�ny != this.ir�ny){
            J�t�kV�ge v = new J�t�kV�ge();
            v.v�g();
        } else {
            tart�zkod�siHely.set�thalad�Elem(this);
        }

        //redund�ns a feljebb l�v� 6 sor mellett
		//�tl�p�s nem lehet, mivel a vonatokat "egyenk�nt" l�ptetj�k �s nem egyszerre
		//tesztel�st ig�nyelhet
		/*boolean �tk�z = tart�zkod�siHely.�tk�z�sEl�rejelez();
		if(!�tk�z) {
			J�t�kV�ge v = new J�t�kV�ge();
			v.v�g();
		}*/


}

	/**
	 * be�ll�tja a vonatelem mozg�s�nak ir�ny�t
	 * @param i az ir�nyt jelz� param�ter
	 */
	public void setIr�ny(boolean i){
		ir�ny = i;
	}

	/**
	 * be�ll�tja a vonatelem poz�ci�j�t, hogy mely s�nelemen tart�zkodik �ppen
	 * @param s az aktu�lis tart�zkod�si helyet reprezent�l� param�ter
	 */
	public void setPoz�ci�(S�nElem s){
		//k�rja mag�t, ha a tartozkod�si helyre nem � van beregisztr�lva
//		if (tart�zkod�siHely!=null)
//		if (tart�zkod�siHely.get�thalad�Elem() !=this) {
//			System.out.println(this.toString());
//		}
		/**csak akkor jelentkezik le a s�nelemr�l ha � van oda beregisztr�lva
		 * (megakad�lyozva, hogy pl m�g�tte halad� elemet (ami el�bb l�pett) jelentkeztessen le*/
 		if (tart�zkod�siHely!=null && tart�zkod�siHely.get�thalad�Elem()== this)
			tart�zkod�siHely.set�thalad�Elem(null);


		tart�zkod�siHely = s;
    }


	/**
	 * Hozz�k�ti a vonatelemhez a megadott kocsit, ez fog ut�na k�vetkezni.
	 *
	 * @param _k�vetkez� a kocsi, ami a vonatelemhez lesz k�tve.
	 */
	public void setK�vetkez�(Kocsi _k�vetkez�){
	    k�vetkez�=_k�vetkez�;
    }

	/**
	 * Visszaadja a k�vetkez�, az aktu�lis vonatelem ut�n �ll� kocsit.
	 * @return a visszaadott kocsi
	 */
	public Kocsi getK�vetkez�(){return k�vetkez�;}

	//placeholder, nem lesz megval�s�tva
	@Override
	public void rajzol(Graphics g) {
		try {

			if (tart�zkod�siHely!=null && tart�zkod�siHely.getL�that�()) {
				//System.out.println(tart�zkod�siHely.getX()+" , " +tart�zkod�siHely.getY());
				BufferedImage img = ImageIO.read(new File("ve.png"));
				g.drawImage(img, tart�zkod�siHely.getX()-img.getWidth()/2, tart�zkod�siHely.getY()-img.getHeight()/2, null);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}