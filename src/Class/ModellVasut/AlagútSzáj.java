package Class.ModellVasut;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:55
 */

/**
 * Az alag�tsz�jat megval��t� oszt�ly
 */
public class Alag�tSz�j extends Csom�pont {

	private boolean akt�v;
	private Alag�t alag�t;
	private static int darab;
	public Alag�t m_Alag�t;

	public Alag�tSz�j(int x, int y, List<S�nElem> se){
		super(x, y, se);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	private Alag�t �p�t(){
		System.out.println("<<Alag�tSz�j::�p�t()::Alag�t");
		return new Alag�t();
	}

	@Override
	public void felhaszn�l�Akci�(){
		System.out.println("Van akt�v alag�tsz�j?(i/n)");
		BufferedReader be= new BufferedReader(new InputStreamReader(System.in));
		String van;
		try{
			van=be.readLine();
			if (van.equals("i")){
				System.out.println("�p�tesz vagy rombolsz?(�/r)");
				String v�lasz=be.readLine();
				if (v�lasz.equals("�")) {
					System.out.println("Egy van bel�le?(i/n)");
					String egy = be.readLine();

					if (egy.equals("i")) {
						System.out.println(">>Alag�tSz�j::�p�t()");
						this.�p�t();
					}

					else if (egy.equals("n")) {
						System.out.println("Nem �p�lt fel alag�tsz�j");
					}

					else {
						System.out.println("Nem megfelel� v�lasz.");
					}
				}

				else if(v�lasz.equals("r")){
					Alag�t a = new Alag�t();
					System.out.println(">>Alag�tSz�j::rombol()");
					this.rombol(a);
				}

				else{
					System.out.println("Nem megfelel� v�lasz.");
				}
			}

			else if (van.equals("n")){
				System.out.println("Fel�p�lt egy alag�tsz�j");
			}

			else {
				System.out.println("Nem megfelel� v�lasz.");
			}
		} catch(IOException e) {e.getMessage();}
	}

	/**
	 * 
	 * @param a: Egy alag�t t�pus� v�ltoz�t kap, amit megsz�ntet.
	 */
	private void rombol(Alag�t a){
		System.out.println("Egy alag�t lerombol�dott.");
	}

}