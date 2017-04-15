package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public abstract class VonatElem {

	protected boolean irány;
	protected SínElem TartózkodásiHely;

	/**
	 * vonatelem konstruktor
	 * jelenleg csak a tesztesetekhez szükséges változók vannak kezelve benne, annak megfelelõen
	 * a mûödõ programban nem így fog kinézni, mivel elõre definiáljuk a vonatelemeket
	 */
	public VonatElem(){

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
		System.out.println(">>VonatElem::getIrány() : boolean");
		return irány;
	}

	public SínElem getPozíció(){
		return TartózkodásiHely;
	}

	/**
	 *	Adott vonat elem következõ sínelemre helyezését irányítja
	 *	benne kerül sor ütközésdetektálásra is. érzékeli, ha játék végét jelentõ eset következik be
	 */
	public void mozgat(){
		System.out.println(">>Mozdony::mozgat()");

		if(irány) {
			if(TartózkodásiHely.getKövetkezõ() == null) {
				boolean tmp = TartózkodásiHely.keresztez(true, this);
				System.out.println("<<SínElem::keresztez(i,v)::boolean");
				if(!tmp){
					JátékVége v = new JátékVége();
					v.vég();
					return;
				}
			} else {
				setPozíció(TartózkodásiHely.getKövetkezõ());
			}
		} else {
			boolean tmp = TartózkodásiHely.keresztez(true, this);
			System.out.println("<<SínElem::keresztez(i,v)::boolean");
			if(!tmp){
				if(!TartózkodásiHely.keresztez(irány, this)){
					JátékVége v = new JátékVége();
					v.vég();
					return;
				}

			} else {
				setPozíció(TartózkodásiHely.getElõzõ());
			}

		}
		boolean ütköz = TartózkodásiHely.ütközésElõrejelez();
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
		System.out.println(">>VonatElem::setIrány(" + i + ")");
		irány = i;
	}

	/**
	 * beállítja a vonatelem pozícióját, hogy mely sínelemen tartózkodik éppen
	 * @param s az aktuális tartózkodási helyet reprezentáló paraméter
	 */
	public void setPozíció(SínElem s){
		TartózkodásiHely = s;
		System.out.println(this.toString() + " átkerült " + s.toString() + " sínre");
	}

}