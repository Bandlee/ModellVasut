package Class.ModellVasut;


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
	protected static int id = 0;

	/**
	 * Konstruktor a Csomópont osztály példányosításához
	 * @param a a Csomópont x koordinátája
	 * @param b a Csomópont x koordinátája
	 * @param list a Csomópontba futó SínElemek listája
	 */
	public Csomópont(int a, int b, List<SínElem> list){
		x = a;
		y = b;
		befutóSínek = list;
		id +=1;
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
		try{
			SínElem hova = null;

			if(befutóSínek.get(0)!=s){
				hova = befutóSínek.get(0);
			} else if(befutóSínek.get(1)!=s){
				hova = befutóSínek.get(1);
			}
			if(hova == null){
				return false;
			} else{
				v.setPozíció(hova);
				if(hova.getSínvég1()==this) v.setIrány(true); else v.setIrány(false);
				return true;
			}
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * A Csomópontba futó sínek bõvítése, új befutó SínElem hozzáadása
	 * @param s a hozzáadandó SínElem
	 */
	public void setBefutóSín(SínElem s){
		befutóSínek.add(s);
	}

}