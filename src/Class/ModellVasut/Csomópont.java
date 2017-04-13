package Class.ModellVasut;


import java.util.List;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:55
 */
public class Csom�pont {

	protected List<S�nElem> befut�S�nek;
	protected int x;
	protected int y;

	public Csom�pont(int a, int b, List<S�nElem> list){
		x = a;
		y = b;
		befut�S�nek = list;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * a csom�pontra �rkez� vonatot tov�bb�rja a megfelel� kimenetre
     * jelenlegi kimenete csak a tesztesetek m�k�d�s�t szolg�lja
     *
	 * @param v a tov�bb�tand� vonatelem
	 * @param s megmutatja, honnan is �rkezett a vonatelem
	 */
	public boolean tov�bb(VonatElem v, S�nElem s){
		try{
			S�nElem hova = null;

			if(befut�S�nek.get(0)!=s){
				hova = befut�S�nek.get(0);
			} else if(befut�S�nek.get(1)!=s){
				hova = befut�S�nek.get(1);
			}
			if(hova == null){
				return false;
			} else{
				v.setPoz�ci�(hova);
				if(hova.getS�nv�g1()==this) v.setIr�ny(true); else v.setIr�ny(false);
				return true;
			}
		}catch(Exception e){
			return false;
		}
	}

}