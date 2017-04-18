package Class.ModellVasut;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public abstract class Kocsi extends VonatElem {

	//létrehozáskor legyen true, láncolásnál majd beállítódik.
	protected boolean leszállhat;


	public void finalize() throws Throwable {
		super.finalize();
	}


	/**
	 * A metódus meghívódik minden alkalommal, mikor az elõtte lévõ vonat elem átadja neki az órajelet
	 * Meghívja az elem mozgatásáért felelõs függvényt, és továbbadja a jelet a következõ vonat elemnek, ha létezik.
	 */
	public void tickAkció() throws VegException{
		mozgat();
		if(következõ != null) következõ.tickAkció();
	}




	/**
	 * Kocsi leszállhat értékének beállíitására használandó.
	 *
	 * @param leszállhat erre az értékre állítjuk be a kocsi leszállhat értékét
	 */
	protected abstract void setLeszállhat(boolean leszállhat);

}