package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:55
 */
public class Állomás extends Csomópont {

	private static int nemleszállt;
	private PályaGeneráló pg;
	private String szín;
	public PályaGeneráló m_PályaGeneráló;

	public Állomás(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param v
	 */
	public boolean leszáll(VonatElem v){
		return false;
	}

	public void pályaTeljesít(){

	}

	/**
	 * 
	 * @param v
	 * @param s
	 */
	public boolean tovább(VonatElem v, SínElem s){
		return false;
	}

}