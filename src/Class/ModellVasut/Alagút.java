package Class.ModellVasut;


import java.util.ArrayList;
import java.util.List;

/**
 * Alagutat megvalósító osztály.
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:55
 */
public class Alagút {

	private List<SínElem> alagútelem;
	private AlagútSzáj bejárat1;
	private AlagútSzáj bejárat2;

	/**
	 * A konstruktor beállítja az alagút végeit.
	 * @param be1: 1-es számú bejárat
	 * @param be2: 2-es számú bejárat
	 */
	public Alagút(AlagútSzáj be1, AlagútSzáj be2){
		bejárat1 = be1;
		bejárat2 = be2;
		alagútelem = SínElem.összeköt(be1,be2,false);
	}

	public void finalize() throws Throwable {

	}

	/**
	 * Végignézi az alagútelem listában lévõ SínElemeket,
	 * majd visszaadja, hogy van-e éppen vonat az alagútban.
	 *
	 * @return van-e volnat az alagútban (true: üres)
	 */
	public boolean getÜresAlagút(){
        for (SínElem actual : alagútelem) {
            if (actual.getÁthaladóElem() != null)
                return false;
        }
		return true;
	}

	/**
	 * Visszaadja az alagutat alkotó alagútszájakat egy listában
	 * @return az alagútszájakat tároló lista
	 */
	public List<SínElem> getAlagútelem(){
		return alagútelem;
	}
}