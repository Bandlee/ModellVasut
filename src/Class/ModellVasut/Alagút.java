package Class.ModellVasut;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:55
 */
public class Alag�t {

	private List<S�nElem> alag�telem;
	private Alag�tSz�j bej�rat1;
	private Alag�tSz�j bej�rat2;

	/**
	 * A konstruktor be�ll�tja az alag�t v�geit.
	 * @param be1: 1-es sz�m� bej�rat
	 * @param be2: 2-es sz�m� bej�rat
	 */
	public Alag�t(Alag�tSz�j be1, Alag�tSz�j be2){
		alag�telem=new ArrayList<>();
		bej�rat1 = be1;
		bej�rat2 = be2;
		S�nElem s=new S�nElem(be1,be2, false);
		alag�telem.add(s);
	}

	public void finalize() throws Throwable {

	}

	/**
	 * V�gign�zi az alag�telem list�ban l�v� S�nElemeket,
	 * majd visszaadja, hogy van-e �ppen vonat az alag�tban.
	 *
	 * @return van-e volnat az alag�tban (true: �res)
	 */
	public boolean get�resAlag�t(){
        for (S�nElem actual : alag�telem) {
            if (actual.get�thalad�Elem() != null)
                return false;
        }
		return true;
	}

	public List<S�nElem> getAlag�telem(){
		return alag�telem;
	}
}