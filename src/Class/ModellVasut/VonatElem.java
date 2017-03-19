package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public abstract class VonatElem {

	protected boolean ir�ny;
	protected S�nElem Tart�zkod�siHely;
	public S�nElem m_S�nElem;

	public VonatElem(){
		m_S�nElem = new S�nElem();
		ir�ny = true;
	}



	public void finalize() throws Throwable {

	}

	/**
	 * A met�dus megadja, hogy adott sz�n� �llom�s mellett elhaladva sz�llnak-e le a vonatelemr�l utasok.
	 * Visszat�r�si �rt�ke false, vagyis biztosan nem sz�llnak le utasok. Azokn�l a VonatElem �s� oszt�lyokn�l,
	 * amelyekn�l utasok lesz�llhatnak, fel�l kell �rni ezt a met�dust.
	 * 
	 * @param s: Az �llom�s sz�n�t jel�li, ami mellett elhalad a VonatElem.
	 */
	public boolean ellen�riz(String s){
		System.out.println("<<VonatElem::ellen�riz(String s)::boolean");
		return false;
	}

	public boolean getIr�ny(){
		return false;
	}

	public S�nElem getPoz�ci�(){
		return null;
	}

	/**
	 *	Adott vonat elem k�vetkez� s�nelemre helyez�s�t ir�ny�tja
	 */
	public void mozgat(){
		System.out.println(">>Mozdony::mozgat()");

		if(ir�ny) {
			if(m_S�nElem.getK�vetkez�() == null) {
				boolean tmp = m_S�nElem.keresztez(true, this);
				System.out.println("<<S�nElem::keresztez(i,v)::boolean");
				if(!tmp){
					J�t�kV�ge v = new J�t�kV�ge();
					v.v�g();
					return;
				}
			} else {
				setPoz�ci�(m_S�nElem.getK�vetkez�());
			}
		} else {
			boolean tmp = m_S�nElem.keresztez(true, this);
			System.out.println("<<S�nElem::keresztez(i,v)::boolean");
			if(!tmp){
				if(!m_S�nElem.keresztez(ir�ny, this)){
					J�t�kV�ge v = new J�t�kV�ge();
					v.v�g();
					return;
				}

			} else {
				setPoz�ci�(m_S�nElem.getEl�z�());
			}

		}
		boolean �tk�z = m_S�nElem.�tk�z�sEl�rejelez();
		if(!�tk�z) {
			J�t�kV�ge v = new J�t�kV�ge();
			v.v�g();

		}
	}

	/**
	 *
	 * @param i
	 */
	public void setIr�ny(boolean i){
		ir�ny = i;
	}

	/**
	 *
	 * @param s
	 */
	public void setPoz�ci�(S�nElem s){
		Tart�zkod�siHely = s;
		//System.out.println(this.toString() + " �tker�lt " + s.toString() + " s�nre");
	}

}