package Class.ModellVasut;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:55
 */
public class Csomópont {

	protected List<SínElem> befutóSínek;
	protected int x;
	protected int y;
	private static int ids = 0;
	protected int id;

	/**
	 * Konstruktor a Csomópont osztály példányosításához
	 *
	 */
	public Csomópont(){
		befutóSínek = new ArrayList<SínElem>();
		id=ids;
		ids++;
    }

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

    public void removeBefutóSín(SínElem s){
        befutóSínek.remove(s);
    }

	public int getId(){return id;}

	public static void nullId(){
	    ids=0;
    }

}