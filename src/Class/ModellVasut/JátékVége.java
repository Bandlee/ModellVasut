package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */

import com.sun.org.apache.bcel.internal.generic.GOTO;

/** A j�t�k v�g�t megval�s�t� oszt�ly */
public class J�t�kV�ge {

	public J�t�kV�ge(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * j�t�k v�g�t jelent� f�ggv�ny
	 * ezesetben a felhaszn�l� vesztett, ezt fogja majd kezelni
	 */

	public void v�g() throws VegException {
		throw new VegException("J�t�k v�ge");
	}

}