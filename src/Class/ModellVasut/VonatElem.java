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
		return false;
	}

	public boolean getIr�ny(){
		return false;
	}

	public S�nElem getPoz�ci�(){
		return null;
	}

	public void mozgat(){
		if(ir�ny) {

			if(m_S�nElem.getK�vetkez�() == null) {
				m_S�nElem.keresztez(ir�ny, this);
			}

		}
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