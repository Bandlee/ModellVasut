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
	public SínElem m_SínElem;

	public Csomópont(){

	}

	public void finalize() throws Throwable {

	}

	public void felhasználóAkció(){

	}

	/**
	 * 
	 * @param v
	 * @param s
	 */
	public boolean tovább(VonatElem v, SínElem s){
		System.out.println(">>Csomópont::tovább(v,s)");
		v.setPozíció(m_SínElem);
		v.setIrány(true);
		System.out.println("<<Csomópont::tovább(v,s)::boolean");

		return false;
	}

}