package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public abstract class VonatElem {

	protected boolean ir�ny;
	protected S�nElem Tart�zkod�siHely;

	/**
	 * vonatelem konstruktor
	 * jelenleg csak a tesztesetekhez sz�ks�ges v�ltoz�k vannak kezelve benne, annak megfelel�en
	 * a m��d� programban nem �gy fog kin�zni, mivel el�re defini�ljuk a vonatelemeket
	 */
	public VonatElem(){

	}



	public void finalize() throws Throwable {

	}

	/**
	 * A met�dus megadja, hogy adott sz�n� �llom�s mellett elhaladva sz�llnak-e le a vonatelemr�l utasok.
	 * Visszat�r�si �rt�ke false, vagyis biztosan nem sz�llnak le utasok. Azokn�l a VonatElem �s� oszt�lyokn�l,
	 * amelyekn�l utasok lesz�llhatnak, fel�l kell �rni ezt a met�dust.
	 *
	 * jelenlegi visszat�r�si �rt�ke a teszteseteket szolg�lja, az �les programban nem �gy lesz meghat�rozva
	 *
	 * @param s: Az �llom�s sz�n�t jel�li, ami mellett elhalad a VonatElem.
	 */
	public boolean ellen�riz(String s){
		System.out.println("<<VonatElem::ellen�riz(String s)::boolean");
		return false;
	}

	public boolean getIr�ny(){
		System.out.println(">>VonatElem::getIr�ny() : boolean");
		return ir�ny;
	}

	public S�nElem getPoz�ci�(){
		return Tart�zkod�siHely;
	}

	/**
	 *	Adott vonat elem k�vetkez� s�nelemre helyez�s�t ir�ny�tja
	 *	benne ker�l sor �tk�z�sdetekt�l�sra is. �rz�keli, ha j�t�k v�g�t jelent� eset k�vetkezik be
	 */
	public void mozgat(){
		System.out.println(">>Mozdony::mozgat()");

		if(ir�ny) {
			if(Tart�zkod�siHely.getK�vetkez�() == null) {
				boolean tmp = Tart�zkod�siHely.keresztez(true, this);
				System.out.println("<<S�nElem::keresztez(i,v)::boolean");
				if(!tmp){
					J�t�kV�ge v = new J�t�kV�ge();
					v.v�g();
					return;
				}
			} else {
				setPoz�ci�(Tart�zkod�siHely.getK�vetkez�());
			}
		} else {
			boolean tmp = Tart�zkod�siHely.keresztez(true, this);
			System.out.println("<<S�nElem::keresztez(i,v)::boolean");
			if(!tmp){
				if(!Tart�zkod�siHely.keresztez(ir�ny, this)){
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
		System.out.println(">>VonatElem::setIr�ny(" + i + ")");
		ir�ny = i;
	}

	/**
	 * be�ll�tja a vonatelem poz�ci�j�t, hogy mely s�nelemen tart�zkodik �ppen
	 * @param s az aktu�lis tart�zkod�si helyet reprezent�l� param�ter
	 */
	public void setPoz�ci�(S�nElem s){
		Tart�zkod�siHely = s;
		System.out.println(this.toString() + " �tker�lt " + s.toString() + " s�nre");
	}

}