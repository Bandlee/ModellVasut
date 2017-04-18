package Class.ModellVasut;


import java.util.ArrayList;
import java.util.List;

/**
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
		alagútelem=new ArrayList<>();
		bejárat1 = be1;
		bejárat2 = be2;
		SínElem s=new SínElem(be1,be2, false);
		alagútelem.add(s);
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

	public List<SínElem> getAlagútelem(){
		return alagútelem;
	}
}