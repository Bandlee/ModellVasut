package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public abstract class VonatElem {

	protected boolean ir�ny;
	protected Class.ModellVasut.S�nElem Tart�zkod�siHely;
	public Class.ModellVasut.S�nElem m_S�nElem;

	public VonatElem(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param s
	 */
	public boolean ellen�riz(String s){
		return false;
	}

	public boolean getIr�ny(){
		return false;
	}

	public Class.ModellVasut.S�nElem getPoz�ci�(){
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
	public void setPoz�ci�(Class.ModellVasut.S�nElem s){

	}

}