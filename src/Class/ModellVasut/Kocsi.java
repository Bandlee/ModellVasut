package Class.ModellVasut;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public class Kocsi extends VonatElem {

	private Kocsi k�vetkez�;
	private boolean lesz�llhat;
	private String sz�n;
	private boolean utas;

	public Kocsi(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 *
	 * @param s: Az �llom�s sz�n�t jel�li a param�ter, ez alapj�n fogjuk a v�gs� programban eld�nteni,
	 *           hogy sz�llnak-e le az adott kocsir�l a megadott sz�n� �llom�son.
	 */
	@Override
	public boolean ellen�riz(String s){

		System.out.println("Sz�llnak le utasok a kocsir�l?(i/n)");
		BufferedReader be= new BufferedReader(new InputStreamReader(System.in));
		String lesz�llnak;
		boolean lesz�lltak = false;
		try {
			lesz�llnak=be.readLine();
			if (lesz�llnak.equals("i"))
				lesz�lltak = true;

			else if ( !lesz�llnak.equals("n") )
				System.out.println("Nem megfelel� v�lasz.");

		} catch(IOException e) {e.getMessage();}


		System.out.println("<<Kocsi::ellen�riz(String s)::boolean");
		return lesz�lltak;

	}

	public void tickAkci�(){

	}

}