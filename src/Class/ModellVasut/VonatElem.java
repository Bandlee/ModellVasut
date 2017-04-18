package Class.ModellVasut;


/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public abstract class VonatElem {

	protected boolean irány;
	protected SínElem TartózkodásiHely;
	protected Kocsi következõ;


	public VonatElem(){

	}

	public boolean getUtas(){return false;}

	public boolean getLeszállhat(){return false;}

	public void finalize() throws Throwable {

	}


	public boolean ellenõriz(String s){
		if(this.getUtas() && this.getLeszállhat()) return true;
		else return false;
	}


	/**
	 * A metódus megadja, hogy adott színû állomás mellett elhaladva szállnak-e fel a vonatelemre utasok.
	 * Visszatérési értéke false, vagyis biztosan nem szállnak fel utasok. Azoknál a VonatElem õsû osztályoknál,
	 * amelyeknél utasok felszállhatnak, felül kell írni ezt a metódust.
	 *
	 * @param s: Az állomás színét jelöli, ami mellett elhalad a VonatElem.
	 */
	public boolean felEllenõriz(String s){
		return false;
	}



	public boolean getIrány(){
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

		if(irány) {
			if(TartózkodásiHely.getKövetkezõ() == null) {
				boolean tmp = TartózkodásiHely.keresztez(true, this);
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
		irány = i;
	}

	/**
	 * beállítja a vonatelem pozícióját, hogy mely sínelemen tartózkodik éppen
	 * @param s az aktuális tartózkodási helyet reprezentáló paraméter
	 */
	public void setPozíció(SínElem s){
		TartózkodásiHely = s;
	}


	/**
	 * Hozzáköti a vonatelemhez a megadott kocsit, ez fog utána következni.
	 *
	 * @param következõ a kocsi, ami a vonatelemhez lesz kötve.
	 */
	public void setKövetkezõ(Kocsi _következõ){
	    következõ=_következõ;
    }

	public Kocsi getKövetkezõ(){
		return következõ;
	}


}