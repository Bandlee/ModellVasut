package Class.ModellVasut;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:55
 */

/**
 * Az alagútszájat megvalóító osztály
 */
public class AlagútSzáj extends Csomópont {

	private boolean aktív;
	private Alagút alagút;
	private static int darab;
	public Alagút m_Alagút;

	public AlagútSzáj(int x, int y, List<SínElem> se){
		super(x, y, se);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	private Alagút épít(){
		System.out.println("<<AlagútSzáj::épít()::Alagút");
		return new Alagút();
	}

	@Override
	public void felhasználóAkció(){
		System.out.println("Van aktív alagútszáj?(i/n)");
		BufferedReader be= new BufferedReader(new InputStreamReader(System.in));
		String van;
		try{
			van=be.readLine();
			if (van.equals("i")){
				System.out.println("Építesz vagy rombolsz?(é/r)");
				String válasz=be.readLine();
				if (válasz.equals("é")) {
					System.out.println("Egy van belõle?(i/n)");
					String egy = be.readLine();

					if (egy.equals("i")) {
						System.out.println(">>AlagútSzáj::épít()");
						this.épít();
					}

					else if (egy.equals("n")) {
						System.out.println("Nem épült fel alagútszáj");
					}

					else {
						System.out.println("Nem megfelelõ válasz.");
					}
				}

				else if(válasz.equals("r")){
					Alagút a = new Alagút();
					System.out.println(">>AlagútSzáj::rombol()");
					this.rombol(a);
				}

				else{
					System.out.println("Nem megfelelõ válasz.");
				}
			}

			else if (van.equals("n")){
				System.out.println("Felépült egy alagútszáj");
			}

			else {
				System.out.println("Nem megfelelõ válasz.");
			}
		} catch(IOException e) {e.getMessage();}
	}

	/**
	 * 
	 * @param a: Egy alagút típusú változót kap, amit megszüntet.
	 */
	private void rombol(Alagút a){
		System.out.println("Egy alagút lerombolódott.");
	}

}