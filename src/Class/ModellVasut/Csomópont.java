package Class.ModellVasut;


import java.util.List;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:55
 */
public class Csom�pont {

	protected List<S�nElem> befut�S�nek;
	protected int x;
	protected int y;
	public S�nElem m_S�nElem;

	public Csom�pont(){

	}

	public void finalize() throws Throwable {

	}

	public void felhaszn�l�Akci�(){

	}

	/**
	 * a csom�pontra �rkez� vonatot tov�bb�rja a megfelel� kimenetre
     * jelenlegi kimenete csak a tesztesetek m�k�d�s�t szolg�lja, az �les programban nem �gy fog kin�zni
     *
	 * @param v a tov�bb�tand� vonatelem
	 * @param s megmutatja, honnan is �rkezett a vonatelem
	 */
	public boolean tov�bb(VonatElem v, S�nElem s){
		System.out.println(">>Csom�pont::tov�bb(v,s)");
		v.setPoz�ci�(m_S�nElem);
		v.setIr�ny(true);
		System.out.println("<<Csom�pont::tov�bb(v,s)::boolean");

		return false;
	}

}