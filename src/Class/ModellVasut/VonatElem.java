package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public class VonatElem {

	protected boolean ir�ny;
	protected S�nElem Tart�zkod�siHely;
	protected Kocsi k�vetkez�;

	/**
	 * VonatElem oszt�ly konstruktora.
	 */
	public VonatElem(){

	}

	/**
	 *
	 * @return
	 */
	public boolean getUtas(){return false;}

	/**
	 *
	 * @return
	 */
	public boolean getLesz�llhat(){return false;}

	public void finalize() throws Throwable {

	}

	/**
	 *
	 * @param s
	 * @return
	 */
	public boolean ellen�riz(String s){
		if(this.getUtas() && this.getLesz�llhat()) return true;
		else return false;
	}


	/**
	 * A met�dus megadja, hogy adott sz�n� �llom�s mellett elhaladva sz�llnak-e fel a vonatelemre utasok.
	 * Visszat�r�si �rt�ke false, vagyis biztosan nem sz�llnak fel utasok. Azokn�l a VonatElem �s� oszt�lyokn�l,
	 * amelyekn�l utasok felsz�llhatnak, fel�l kell �rni ezt a met�dust.
	 *
	 * @param s: Az �llom�s sz�n�t jel�li, ami mellett elhalad a VonatElem.
	 */
	public boolean felEllen�riz(String s){
		return false;
	}


	/**
	 * Visszaadja a vonatelem halad�si ir�ny�t.
	 * @return a visszaadott ir�ny
	 */
	public boolean getIr�ny(){
		return ir�ny;
	}

	/**
	 * Visszaadja a VonatElem aktu�lis poz�ci�j�t.
	 * @return az aktu�lis poz�ci� - s�nelem
	 */
	public S�nElem getPoz�ci�(){
		return Tart�zkod�siHely;
	}

	/**
	 *	Adott vonat elem k�vetkez� s�nelemre helyez�s�t ir�ny�tja
	 *	benne ker�l sor �tk�z�sdetekt�l�sra is. �rz�keli, ha j�t�k v�g�t jelent� eset k�vetkezik be
	 */
	public void mozgat()throws VegException{

		if(ir�ny) {
			if(Tart�zkod�siHely.getK�vetkez�() == null) {
				boolean tmp = Tart�zkod�siHely.keresztez(ir�ny, this);
				if(!tmp){
					J�t�kV�ge v = new J�t�kV�ge();
					v.v�g();
					return;
				}
			} else {
				setPoz�ci�(Tart�zkod�siHely.getK�vetkez�());
			}
		} else {
            if(Tart�zkod�siHely.getEl�z�() == null) {
                boolean tmp = Tart�zkod�siHely.keresztez(ir�ny, this);
                if (!tmp) {
                    J�t�kV�ge v = new J�t�kV�ge();
                    v.v�g();
                    return;
                }
            } else {
                setPoz�ci�(Tart�zkod�siHely.getEl�z�());
            }
		}

		boolean �tk�z = Tart�zkod�siHely.�tk�z�sEl�rejelez();
		if(!�tk�z) {
			J�t�kV�ge v = new J�t�kV�ge();
			v.v�g();

		}
	}

	/**
	 * be�ll�tja a vonatelem mozg�s�nak ir�ny�t
	 * @param i az ir�nyt jelz� param�ter
	 */
	public void setIr�ny(boolean i){
		ir�ny = i;
	}

	/**
	 * be�ll�tja a vonatelem poz�ci�j�t, hogy mely s�nelemen tart�zkodik �ppen
	 * @param s az aktu�lis tart�zkod�si helyet reprezent�l� param�ter
	 */
	public void setPoz�ci�(S�nElem s){
		Tart�zkod�siHely = s;
        System.out.println(s);
    }


	/**
	 * Hozz�k�ti a vonatelemhez a megadott kocsit, ez fog ut�na k�vetkezni.
	 *
	 * @param _k�vetkez� a kocsi, ami a vonatelemhez lesz k�tve.
	 */
	public void setK�vetkez�(Kocsi _k�vetkez�){
	    k�vetkez�=_k�vetkez�;
    }

	/**
	 * Visszaadja a k�vetkez�, az aktu�lis vonatelem ut�n �ll� kocsit.
	 * @return a visszaadott kocsi
	 */
	public Kocsi getK�vetkez�(){return k�vetkez�;}


}