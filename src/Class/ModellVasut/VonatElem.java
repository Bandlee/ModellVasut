package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public abstract class VonatElem {

	protected boolean irány;
	protected SínElem TartózkodásiHely;
	public SínElem m_SínElem;

	public VonatElem(){
		m_SínElem = new SínElem();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * A metódus megadja, hogy adott színû állomás mellett elhaladva szállnak-e le a vonatelemrõl utasok.
	 * Visszatérési értéke false, vagyis biztosan nem szállnak le utasok. Azoknál a VonatElem õsû osztályoknál,
	 * amelyeknél utasok leszállhatnak, felül kell írni ezt a metódust.
	 * 
	 * @param s: Az állomás színét jelöli, ami mellett elhalad a VonatElem.
	 */
	public boolean ellenõriz(String s){
		System.out.println("<<VonatElem::ellenõriz(String s)::boolean");
		return false;
	}

	public boolean getIrány(){
		return false;
	}

	public SínElem getPozíció(){
		return null;
	}

	/**
	 *	Adott vonat elem következõ sínelemre helyezését irányítja
	 */
	public void mozgat(){
		System.out.println("Vonat tovább halad");
		if(irány) {
			if(m_SínElem.getKövetkezõ() == null) {
				if(!m_SínElem.keresztez(true, this)){
					System.out.println("<<JátékVége::vég()");
					JátékVége v = new JátékVége();
					v.vég();
				}
			} else {
				setPozíció(m_SínElem.getKövetkezõ());
			}
		} else {
			if(m_SínElem.getElõzõ() == null) {
				if(!m_SínElem.keresztez(irány, this)){
					System.out.println("<<JátékVége::vég()");
					JátékVége v = new JátékVége();
					v.vég();
				}

			} else {
				setPozíció(m_SínElem.getElõzõ());
			}
		}
	}

	/**
	 *
	 * @param i
	 */
	public void setIrány(boolean i){
		irány = i;
	}

	/**
	 *
	 * @param s
	 */
	public void setPozíció(SínElem s){
		TartózkodásiHely = s;
	}

}