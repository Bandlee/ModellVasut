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
public abstract class VonatElem implements IMegjelen�thet� {

	protected boolean ir�ny;
	protected S�nElem tart�zkod�siHely;
	protected Kocsi k�vetkez�;

	public void finalize() throws Throwable {

	}

	/**
	 * A met�dus megadja, hogy adott sz�n� �llom�s mellett elhaladva sz�llnak-e le a vonatelemr�l utasok.
	 * Visszat�r�si �rt�ke false, vagyis biztosan nem sz�llnak le utasok. Azokn�l a VonatElem �s� oszt�lyokn�l,
	 * amelyekn�l utasok lesz�llhatnak, fel�l kell �rni ezt a met�dust.
	 *
	 * @param s: Az �llom�s sz�n�t jel�li, ami mellett elhalad a VonatElem.
	 */
	public boolean ellen�riz(String s){
		return false;
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
					throw new VegException("J�t�k V�ge");
				}
			} else {
				setPoz�ci�(tart�zkod�siHely.getK�vetkez�());
			}
		} else {
            if(tart�zkod�siHely.getEl�z�() == null) {
                boolean tmp = tart�zkod�siHely.keresztez(ir�ny, this);
                if (!tmp) {
					throw new VegException("J�t�k V�ge");
                }
            } else {
                setPoz�ci�(tart�zkod�siHely.getEl�z�());
            }
		}



		/**ellen�rzi, hogy ahova ker�lt ott van-e olyan vonatelem, ami ellent�tes ir�ny�
		 * azonos ir�ny� vonatelemmel t�rt�n� �tk�z�st nem detekt�l, helyes p�lyafileokn�l nem okoz gondot
		 * megoldja a csomopontn�l l�v� �tk�z�sdetekt�l�st is*/
        if (tart�zkod�siHely.get�thalad�Elem()!=null &&tart�zkod�siHely.get�thalad�Elem().ir�ny != this.ir�ny){
			throw new VegException("J�t�k V�ge");
        } else {
            tart�zkod�siHely.set�thalad�Elem(this);
        }

        //redund�ns a feljebb l�v� 6 sor mellett
		//�tl�p�s nem lehet, mivel a vonatokat "egyenk�nt" l�ptetj�k �s nem egyszerre
		/*boolean �tk�z = tart�zkod�siHely.�tk�z�sEl�rejelez();
		if(!�tk�z) {
			throw new VegException("J�t�k V�ge");
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
	 * Vonatelem jelzi a tartozkod�si hely�nek, hogy m�r nem lesz ott, azt�n
	 * be�ll�tja poz�ci�j�t, hogy mely s�nelemen tart�zkodik �ppen
	 *
	 * @param s az k�vetkez� tart�zkod�si helyet reprezent�l� param�ter
	 */
	public void setPoz�ci�(S�nElem s){

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


}