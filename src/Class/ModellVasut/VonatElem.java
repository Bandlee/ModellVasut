package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public abstract class VonatElem {

	protected boolean irány;
	protected Class.ModellVasut.SínElem TartózkodásiHely;
	public Class.ModellVasut.SínElem m_SínElem;

	public VonatElem(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param s
	 */
	public boolean ellenõriz(String s){
		return false;
	}

	public boolean getIrány(){
		return false;
	}

	public Class.ModellVasut.SínElem getPozíció(){
		return null;
	}

	public void mozgat(){

	}

	/**
	 * 
	 * @param i
	 */
	public void setIrány(boolean i){

	}

	/**
	 * 
	 * @param s
	 */
	public void setPozíció(Class.ModellVasut.SínElem s){

	}

}