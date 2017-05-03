package Class.ModellVasut;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Az �llom�sokat megval�s�t� oszt�ly, a Csom�pont lesz�rmazottja.
 * Az �llom�son utasok sz�llhatnak fel, illetve le a megfelel� szab�lyok szerint
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:55
 */
public class �llom�s extends Csom�pont {

	private static int nemlesz�llt=0;
	private P�lyaGener�l� pg;
	private String sz�n;
	boolean felsz�ll�;

	/**
	 * Konstruktor az �llom�s oszt�ly p�ld�nyos�t�s�hoz
	 * @param sz�n az �llom�s sz�ne
	 * @param felsz�ll� megadja, hogy az �llom�son v�rakoznak-e utasok felsz�ll�sra
	 * @param pg p�lyagener�l�, amit az �llom�s �rtes�t, ha sikeresen teljes�l a szint
	 */
	public �llom�s(String sz�n, boolean felsz�ll�, int x, int y){
		super(x,y);
		this.sz�n = sz�n;
		this.felsz�ll� = felsz�ll�;
		this.pg = P�lyaGener�l�.getInstance();
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * A f�ggv�nyt akkor h�vjuk meg, amikor egy VonatElemr�l (Szem�lyKocsir�l) lesz�ll�s t�rt�nt.
	 * Regisztr�ljuk a v�loz�st, majd megn�zz�k, hogy van-e m�g utas a p�ly�n l�v� vonatokban.
	 * Amennyiben azok ki�r�ltek, jelezz�k hogy a p�ly�t sikeresen teljes�tett�k.
	 *
	 * @param v: Az �llom�son �thalad� VonatElemet jel�li.
	 */
	public boolean lesz�ll(VonatElem v){
		try{
			nemlesz�llt--;
			pg.getBw().write("Utasok sz�lltak le");
			pg.getBw().newLine();
			if (nemlesz�llt == 0) {
				p�lyaTeljes�t();
			}
			return true;
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		return false;

	}

	/**
	 * A f�ggv�nyt akkor h�vjuk meg, amikor egy VonatElemre (Szem�lyKocsira) felsz�ll�ss t�rt�nt.
	 * Regisztr�ljuk a v�loz�st, be�ll�tjuk a felsz�ll� �rt�ket hamisra.
	 *
	 * @param v: Az �llom�son �thalad� VonatElemet jel�li.
	 */
	public boolean felsz�ll(VonatElem v){
		try{
			felsz�ll� = false;
			pg.getBw().write("Utasok sz�lltak Szem�lyKocsira");
			pg.getBw().newLine();
			return true;
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		return false;
	}


	/**
	 * J�t�k sikeres teljes�t�se eset�n megh�vand� f�ggv�ny.
	 * P�lyaGener�l�va bet�lteti az �j p�ly�t, �s az elind�tja a j�t�kot.
	 */
	public void p�lyaTeljes�t(){
		try {
            pg.getBw().write("Szint teljes�tve");
            pg.getBw().newLine();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
	}

	/**
	 * Csom�ponthoz hasonl�an tov�bbadja az �thalad� VonatElem-et a k�vetkez� S�nElemre,
	 * ez ut�n ellen�zi, hogy sz�lltak-e le utasok az �thalad� VonatElemr�l, illetve,
	 * hogy sz�lltak-e fel r�. T�rt�nteket az �llom�s a megfelel� f�ggv�nyeivel
	 * (lesz�ll/felsz�ll) regisztr�lja mag�nak. Visszat�r�si �rt�ke azonos a Csom�pont
	 * tov�bb f�ggv�ny�vel.
	 *
	 * @param v: Az �llom�son �thalad� VonatElemet jel�li.
	 * @param s: Azt a S�nElemet jel�li, amir�l a v VonatElem �rkezik.
	 *
	 */
	@Override
	public boolean tov�bb(VonatElem v, S�nElem s){

		boolean ret;

		ret = super.tov�bb(v, s);

		if ( v.ellen�riz(sz�n)) {
			lesz�ll(v);
		}

		if ( v.felEllen�riz(sz�n) && felsz�ll�!=false) {
			felsz�ll(v);

		}

		return ret;
	}

	public static void setNemlesz�llt(int n){
	    nemlesz�llt = n;
    }
}