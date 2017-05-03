package Class.ModellVasut;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Csom�pontokat megval�s�t� oszt�ly
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:55
 */
public class Csom�pont extends Hely implements IMegjelen�thet� {

	protected List<S�nElem> befut�S�nek;
	private static int ids = 0;
	protected int id;

	/**
	 * Konstruktor a Csom�pont oszt�ly p�ld�nyos�t�s�hoz
	 */
	public Csom�pont(int x,int y){
		super(x,y);
		befut�S�nek = new ArrayList<S�nElem>();
		id=ids;
		ids++;
    }

	/**
	 * felhaszn�l�i interakci�t kezeli, egyel�re nem haszn�lt
	 */
	public void felhaszn�l�Akci�(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * a csom�pontra �rkez� vonatot tov�bb�tja a megfelel� kimenetre
     * visszat�r�si �rt�ke att�l f�gg, hogy siker�l-e be�ll�tani a a megfelel�
	 * v�ltoztat�sokat.
     *
	 * @param v a tov�bb�tand� vonatelem
	 * @param s megmutatja, honnan is �rkezett a vonatelem
	 */
	public boolean tov�bb(VonatElem v, S�nElem s){
        S�nElem hova = null;
        if(befut�S�nek.get(0)!=s){
            hova = befut�S�nek.get(0);
        } else if(befut�S�nek.size()>1){
            if (befut�S�nek.get(1)!=s) {
                hova = befut�S�nek.get(1);
            }
        }
        if(hova == null){
            return false;
        } else{
            v.setPoz�ci�(hova);
            if(hova.getS�nv�g1()==this) v.setIr�ny(true); else v.setIr�ny(false);
            return true;
        }
	}

	/**
	 * A Csom�pontba fut� s�nek b�v�t�se, �j befut� S�nElem hozz�ad�sa
	 * @param s a hozz�adand� S�nElem
	 */
	public void setBefut�S�n(S�nElem s){
		befut�S�nek.add(s);
	}

	/**
	 * a csom�pontba befut� s�nelemek k�z�l az adott elv�tol�t�sa
	 * @param s az elt�vol�tand� s�nelem
	 */
    public void removeBefut�S�n(S�nElem s){
        befut�S�nek.remove(s);
    }

	/**
	 * visszaadja a csom�pont azonos�t�j�t
	 * @return a csom�pont azonos�t�ja
	 */
	public int getId(){return id;}

	/**
	 * ahhoz, hogy az egym�s ut�n k�vetkez� tesztesetek mindig el�r�l kezdj�k a csom�pontok sz�moz�s�t, sz�ks�g van egy statikus v�ltoz�ra,
	 * amit mindig ki kell null�zni az �j szint elej�n. ezt val�s�tja  meg ez a f�ggv�ny
	 */
	public static void nullId(){
	    ids=0;
    }

	@Override
	public void rajzol(Graphics g) {

		//try {

			//final BufferedImage image = ImageIO.read(new File("csp.png"));
			//g.drawImage(image, x,y,null);
			g.setColor(Color.BLACK);
			g.fillOval(x-20,y-20,40,40);

		/*} catch (IOException e) {
			e.printStackTrace();
		}*/

	}
}