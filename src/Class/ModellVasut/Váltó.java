package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public class V�lt� extends Csom�pont {

	private int akt�v;
	private S�nElem r�gz�tett;

	public V�lt�(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void felhaszn�l�Akci�(){
		System.out.println("V�lt�s t�rt�nik.");
	}

	/**
	 * 
	 * @param v
	 * @param s
	 */

	@Override
	public boolean tov�bb(VonatElem v, S�nElem s){
		return false;
	}

}