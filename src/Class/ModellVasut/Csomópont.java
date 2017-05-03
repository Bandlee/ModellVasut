package Class.ModellVasut;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Csomópontokat megvalósító osztály
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:55
 */
public class Csomópont extends Hely implements IMegjeleníthetõ {

	protected List<SínElem> befutóSínek;
	private static int ids = 0;
	protected int id;

	/**
	 * Konstruktor a Csomópont osztály példányosításához
	 */
	public Csomópont(int x,int y){
		super(x,y);
		befutóSínek = new ArrayList<SínElem>();
		id=ids;
		ids++;
    }

	/**
	 * felhasználói interakciót kezeli, egyelõre nem használt
	 */
	public void felhasználóAkció(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * a csomópontra érkezõ vonatot továbbítja a megfelelõ kimenetre
     * visszatérési értéke attól függ, hogy sikerül-e beállítani a a megfelelõ
	 * változtatásokat.
     *
	 * @param v a továbbítandó vonatelem
	 * @param s megmutatja, honnan is érkezett a vonatelem
	 */
	public boolean tovább(VonatElem v, SínElem s){
        SínElem hova = null;
        if(befutóSínek.get(0)!=s){
            hova = befutóSínek.get(0);
        } else if(befutóSínek.size()>1){
            if (befutóSínek.get(1)!=s) {
                hova = befutóSínek.get(1);
            }
        }
        if(hova == null){
            return false;
        } else{
            v.setPozíció(hova);
            if(hova.getSínvég1()==this) v.setIrány(true); else v.setIrány(false);
            return true;
        }
	}

	/**
	 * A Csomópontba futó sínek bõvítése, új befutó SínElem hozzáadása
	 * @param s a hozzáadandó SínElem
	 */
	public void setBefutóSín(SínElem s){
		befutóSínek.add(s);
	}

	/**
	 * a csomópontba befutó sínelemek közül az adott elvátolítása
	 * @param s az eltávolítandó sínelem
	 */
    public void removeBefutóSín(SínElem s){
        befutóSínek.remove(s);
    }

	/**
	 * visszaadja a csomópont azonosítóját
	 * @return a csomópont azonosítója
	 */
	public int getId(){return id;}

	/**
	 * ahhoz, hogy az egymás után következõ tesztesetek mindig elõrõl kezdjék a csomópontok számozását, szükség van egy statikus változóra,
	 * amit mindig ki kell nullázni az új szint elején. ezt valósítja  meg ez a függvény
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