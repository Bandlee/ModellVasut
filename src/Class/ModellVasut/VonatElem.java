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
	 * A metódus megadja, hogy adott színû állomás mellett elhaladva szállnak-e le a vonatelemrõl utasok.
	 * Visszatérési értéke false, vagyis biztosan nem szállnak le utasok. Azoknál a VonatElem õsû osztályoknál,
	 * amelyeknél utasok leszállhatnak, felül kell írni ezt a metódust.
	 * 
	 * @param s: Az állomás színét jelöli, ami mellett elhalad a VonatElem.
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