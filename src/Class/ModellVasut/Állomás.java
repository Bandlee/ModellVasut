package Class.ModellVasut;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	 * A f�ggv�nyt akkor h�vjuk meg, amikor egy VonatElemr�l (Kocsir�l) lesz�ll�s t�rt�nt.
	 * Regisztr�ljuk a v�loz�st, majd megn�zz�k, hogy van-e m�g utas a p�ly�n l�v� vonatokban.
	 * Amennyiben azok ki�r�ltek, jelezz�k hogy a p�ly�t sikeresen teljes�tett�k.
	 *
	 * @param v: Az �llom�son �thalad� VonatElemet jel�li.
	 */
	public boolean lesz�ll(VonatElem v){

		System.out.println("Ki�r�ltek a vonatok?(i/n)");
		BufferedReader be= new BufferedReader(new InputStreamReader(System.in));
		String �res;
		try {
			�res=be.readLine();
			if (�res.equals("i")) {

				/** Nincs t�bb utas, p�lya sikeresen teljes�tve*/

				System.out.println(">>�llom�s::p�lyaTeljes�t()");
				p�lyaTeljes�t();
			}

			else if (�res.equals("n")) {

				/** Van m�g utas a p�ly�n l�v� vonatokban, nem �r v�get a p�lya */
				System.out.println("A j�t�k folytat�dik");
			}

			else {
				System.out.println("Nem megfelel� v�lasz.");
			}

		} catch(IOException e) {e.getMessage();}

		return true;
	}

	/**
	 * J�t�k sikeres teljes�t�se eset�n megh�vabd� f�ggv�ny.
	 * P�lyaGener�l�va bet�lteti az �j p�ly�t, �s az elind�tja a j�t�kot.
	 */
	public void p�lyaTeljes�t(){
		/** K�vetkez� p�lya ind�t�sa*/
		System.out.println(">>P�lyaGener�l�::kezd�s()");
		m_P�lyaGener�l� = new P�lyaGener�l�();
		m_P�lyaGener�l�.kezd�s();
		System.out.println("K�vetkez� p�lya bet�ltve");
	}

	/**
	 * Csom�ponthoz hasonl�an tov�bbadja az �thalad� VonatElem-et a k�vetkez� S�nElemre,
	 * ez ut�n ellen�zi, hogy sz�lltak a le utasok az �thalad� VonatElemr�l.
	 *
	 * @param v: Az �llom�son �thalad� VonatElemet jel�li.
	 * @param s: Azt a S�nElemet jel�li, amir�l a v VonatElem �rkezik.
	 *
	 */
	public boolean tov�bb(VonatElem v, S�nElem s){

		/** visszat�r�si �rt�k */
		boolean ret;

		/** Csom�ponttal azonosan m�k�d� tov�bbad�s */
		ret = super.tov�bb(v, s);

		/** Szkeleton f�ggv�nyhiv�s�nak pontos k�vet�s�re l�trehozott r�sz*/
		if (v.getClass() == Kocsi.class) {
			System.out.println(">>Kocsi::ellen�riz(String s)");
		}
		else {
			System.out.println(">>VonatElem::ellen�riz(String s)");
		}

		/** T�rt�nt-e lesz�ll�s - ellen�rz�s*/
		if ( v.ellen�riz(sz�n)) {

			/** T�rt�nt lesz�ll�s*/
			System.out.println(">>�llom�s::lesz�ll()");
			lesz�ll(v);
		}
		System.out.println("<<�llom�s::tov�bb(VonatElem v, S�nElem s)::boolean");
		return ret;
	}

}