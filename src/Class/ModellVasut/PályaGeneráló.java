package Class.ModellVasut;


import java.io.File;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public class P�lyaGener�l� {

	private File bemenet;
	private int szint;

	public P�lyaGener�l�(){

	}

	public void finalize() throws Throwable {

	}

	public Id�z�t� kezd�s(){
		System.out.println("<<P�lyagener�l�::kezd�s()::Id�z�t�");
		return new Id�z�t�();
	}

}