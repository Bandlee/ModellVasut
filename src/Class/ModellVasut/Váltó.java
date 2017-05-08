package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * A v�lt�t megval�s�t� oszt�ly
 */
public class V�lt� extends Csom�pont implements IKattinthat� {

	private S�nElem akt�v;
	private S�nElem r�gz�tett;

	/**
	 * A konstruktorban be�ll�tjuk a lista els� elem�t r�gz�tettnek, a m�sodikat akt�vnak.
	 * A V�lt�t Csom�pontk�nt, annak konstruktor�val hozzuk l�tre.
	 */
	public V�lt�(int x, int y){
		super(x, y);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * a felhaszn�l� v�lt�s�t kezel� f�ggv�ny.
	 * Az akt�v v�g�t a v�lt�nak a sorban k�vetkez�
	 * (vagy az utols�t k�vetve az els�) S�nElemre v�ltoztatja.
	 */
	public void felhaszn�l�Akci�(){


		if (akt�v.get�thalad�Elem() == null || r�gz�tett.get�thalad�Elem() == null) {
			/** egy v�ltoz� seg�ts�g�vel l�p�nk az elemek k�z�tt*/
			int i = befut�S�nek.indexOf(akt�v);
			/** l�ptetj�k a v�ltoz�nkat*/
			i++;
			/** ha t�ll�pt�nk a list�n, el�r�l kezdj�k (1-t�l, mivel a 0. a r�gz�tett) */
			if (i >= befut�S�nek.size())
				i = 1;
			/** ha l�ptet�s ut�n nem az akt�von �llunk, akkor lecser�lj�k azt az aktu�lisra */
			/** ha l�ptet�s ut�n is az akt�v az aktu�lis, akkor nem v�ltoztatunk semmmit */
			if (befut�S�nek.get(i) != akt�v)
				akt�v = befut�S�nek.get(i);
		}
	}

	/**
	 * A v�lt�ba �rkez� vonatot tov�bb�tja a megfelel� kimenetre
	 * visszat�r�si �rt�ke att�l f�gg, hogy siker�l-e be�ll�tani a a megfelel�
	 * v�ltoztat�sokat.
	 *
	 * @param v a tov�bb�tand� vonatelem
	 * @param s megmutatja, honnan is �rkezett a vonatelem
	 */
	public boolean tov�bb(VonatElem v, S�nElem s){
		try{
			S�nElem hova = null;

			if(s == r�gz�tett){
				hova = akt�v;
			} else if(s == akt�v){
				hova = r�gz�tett;
			}
			if(hova == null){
				return false;
			} else{
				v.setPoz�ci�(hova);
				if(hova.getS�nv�g1()==this) v.setIr�ny(true); else v.setIr�ny(false);
				return true;
			}
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * a v�lt�ba befut� s�nelekehez val� hozz�ad�s.
	 * speci�lis szerepe miatt a v�lt�ban k�l�nlegesebben m�k�dik, mint egy sima csom�pontban
	 * @param s a hozz�adand� S�nElem
	 */
	@Override
    public void setBefut�S�n(S�nElem s){
	    if (befut�S�nek.size()==0){
	        befut�S�nek.add(s);
	        r�gz�tett=s;
        } else if(befut�S�nek.size()==1){
            befut�S�nek.add(s);
            akt�v=s;
        } else {
            befut�S�nek.add(s);
        }
    }

	/**
	 * Be�ll�tja a v�lt� akt�v kimenet�t a param�terben �tadottra.
	 * @param s a be�ll�tand� S�nElem
	 */

	public void setAkt�v(S�nElem s){akt�v = s;}

	/**
	 * Visszat�r a v�lt� akt�v kimenet�vel
	 * @return az akt�v S�nElem
	 */
	public S�nElem getAkt�v(){return akt�v;}

	/**
	 * Be�ll�tja a v�lt� r�gz�tett kimenet�t a param�terben �tadottra.
	 * @param s a be�ll�tand� S�nElem
	 */
	public void setR�gz�tett(S�nElem s){r�gz�tett = s;}

	/**
	 * Visszaadja a v�lt� r�gz�tett kimenet�t
	 * @return  a visszaadott S�nElem
	 */
	public S�nElem getR�gz�tett(){return r�gz�tett;}


	/**
	 * F�ggv�ny megn�zi, hogy a kattint�s a v�lton�l t�rt�nt-e,
	 * ha igen, akkor pedig v�grehajtja a felhasznl�Akci�t.
	 * @param e kattint�st le�r� �rt�k
	 * @return kattint�s okozott-e v�ltoz�st
	 */
	@Override
	public boolean voltKattintva(MouseEvent e) {

		/** r sugar� k�r�n bel�l vizsg�lunk */
		int r = (int) (50*Ikonok.getNagy�t�sCsp());

		if(Math.sqrt((x-e.getX())*(x-e.getX())+(y-e.getY())*(y-e.getY())) < r) {
			felhaszn�l�Akci�();
			return true;
		}
		return false;
	}


	/**
	 * V�lt� kirajzol�sa a k�perny�re.
	 * A v�lt�t ugyan �gy jelenik meg, mint a csom�pont,a zzal a kieg�sz�t�ssel,
	 * hogy be vannak sz�nezve az �sszek�t�tt s�nelemek.
	 * @param g Graphic objektum amivel kirajzolunk a k�perny�re.
	 */
	@Override
	public void rajzol(Graphics g) {

		/** Csom�pont kirajzol�s */
		super.rajzol(g);

		int w = (int) (30 * Ikonok.getNagy�t�sVe());
		int h = (int) (30 * Ikonok.getNagy�t�sVe());

		/** akt�v S�nElemek jel�l�se a k�perny�n*/
		g.setColor(Color.blue);
		g.fillOval(r�gz�tett.getX()-w/2,r�gz�tett.getY()-h/2,w,h);
		g.setColor(Color.green);
		g.fillOval(akt�v.getX()-w/2,akt�v.getY()-h/2,w,h);
	}
}












