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

	/**
	 * vonatelem konstruktor
	 * jelenleg csak a tesztesetekhez szükséges változók vannak kezelve benne, annak megfelelõen
	 * a mûödõ programban nem így fog kinézni, mivel elõre definiáljuk a vonatelemeket
	 */
	public VonatElem(){
		m_SínElem = new SínElem();
		irány = true;
	}



	public void finalize() throws Throwable {

	}

	/**
	 * A metódus megadja, hogy adott színû állomás mellett elhaladva szállnak-e le a vonatelemrõl utasok.
	 * Visszatérési értéke false, vagyis biztosan nem szállnak le utasok. Azoknál a VonatElem õsû osztályoknál,
	 * amelyeknél utasok leszállhatnak, felül kell írni ezt a metódust.
	 *
	 * jelenlegi visszatérési értéke a teszteseteket szolgálja, az éles programban nem így lesz meghatározva
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
	 *	benne kerül sor ütközésdetektálásra is. érzékeli, ha játék végét jelentõ eset következik be
	 */
	public void mozgat(){
		System.out.println(">>Mozdony::mozgat()");

		if(irány) {
			if(m_SínElem.getKövetkezõ() == null) {
				boolean tmp = m_SínElem.keresztez(true, this);
				System.out.println("<<SínElem::keresztez(i,v)::boolean");
				if(!tmp){
					JátékVége v = new JátékVége();
					v.vég();
					return;
				}
			} else {
				setPozíció(m_SínElem.getKövetkezõ());
			}
		} else {
			boolean tmp = m_SínElem.keresztez(true, this);
			System.out.println("<<SínElem::keresztez(i,v)::boolean");
			if(!tmp){
				if(!m_SínElem.keresztez(irány, this)){
					JátékVége v = new JátékVége();
					v.vég();
					return;
				}

			} else {
				setPozíció(m_SínElem.getElõzõ());
			}

		}
		boolean ütköz = m_SínElem.ütközésElõrejelez();
		if(!ütköz) {
			JátékVége v = new JátékVége();
			v.vég();

		}
	}

	/**
	 * beállítja a vonatelem mozgásának irányát
	 * @param i az irányt jelzõ paraméter
	 */
	public void setIrány(boolean i){
		irány = i;
	}

	/**
	 * beállítja a vonatelem pozícióját, hogy mely sínelemen tartózkodik éppen
	 * @param s az aktuális tartózkodási helyet reprezentáló paraméter
	 */
	public void setPozíció(SínElem s){
		TartózkodásiHely = s;
		//System.out.println(this.toString() + " átkerült " + s.toString() + " sínre");
	}

}