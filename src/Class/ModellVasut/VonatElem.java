package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public abstract class VonatElem {

	protected boolean irány;
	protected SínElem TartózkodásiHely;
	public SínElem m_SínElem;

	public VonatElem(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param s
	 */
	public boolean ellenõriz(String s){
		System.out.println("<<VonatElem::ellenõriz(String s)::boolean");
		return false;
	}

	public boolean getIrány(){
		return false;
	}

	public SínElem getPozíció(){
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
	public void setPozíció(SínElem s){

	}

}