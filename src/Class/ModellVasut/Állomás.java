package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:55
 */
public class �llom�s extends Csom�pont {

	private static int nemlesz�llt;
	private P�lyaGener�l� pg;
	private String sz�n;
	public P�lyaGener�l� m_P�lyaGener�l�;

	public �llom�s(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param v
	 */
	public boolean lesz�ll(VonatElem v){
		return false;
	}

	public void p�lyaTeljes�t(){

	}

	/**
	 * 
	 * @param v
	 * @param s
	 */
	public boolean tov�bb(VonatElem v, S�nElem s){
		return false;
	}

}