package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public abstract class VonatElem {

	protected boolean ir�ny;
	protected S�nElem Tart�zkod�siHely;
	public S�nElem m_S�nElem;

	public VonatElem(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param s
	 */
	public boolean ellen�riz(String s){
		System.out.println("<<VonatElem::ellen�riz(String s)::boolean");
		return false;
	}

	public boolean getIr�ny(){
		return false;
	}

	public S�nElem getPoz�ci�(){
		return null;
	}

	public void mozgat(){

	}

	/**
	 * 
	 * @param i
	 */
	public void setIr�ny(boolean i){

	}

	/**
	 * 
	 * @param s
	 */
	public void setPoz�ci�(S�nElem s){

	}

}