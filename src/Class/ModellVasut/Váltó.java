package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */

/**
 * A v�lt�t megval�s�t� oszt�ly
 */
public class V�lt� extends Csom�pont {

	private int akt�v;
	private S�nElem r�gz�tett;

	public V�lt�(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * a felhaszn�l� v�lt�s�t kezel� f�ggv�ny
	 */
	public void felhaszn�l�Akci�(){
		System.out.println(">>V�lt�::v�lt()");
		this.v�lt();

	}

	private void v�lt(){

	}
}