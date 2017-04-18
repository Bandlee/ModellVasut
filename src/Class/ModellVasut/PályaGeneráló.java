package Class.ModellVasut;


import java.io.*;

/**
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public class P�lyaGener�l� {

	private static P�lyaGener�l� me = null;

	private File bemenet;
	private int szint;

	public P�lyaGener�l�(){
		bemenet = new File("tesztbe" + String.valueOf(szint));
		BufferedReader br = null;
		try {
			br=new BufferedReader(new FileReader(bemenet));
			String sor;
			while((sor=br.readLine()).equals("Start")){
				String parancs=sor.substring(0,3);

				if(parancs.equals("Csp")){
					new Csom�pont();

				} else if(parancs.equals("Vlt")) {
					new V�lt�();

				} else if(parancs.equals("Als")) {
					new Alag�tSz�j();

				} else if(parancs.equals("Sel")) {
					int csp1=Integer.parseInt(sor.substring(4,5));
					int csp2=Integer.parseInt(sor.substring(6,7));
					int db=Integer.parseInt(sor.substring(8,9));

					S�nElem temp_se =new S�nElem(csp1, csp2, null, );
					for(int i=2;i<db-1;i++){

					}
				} else if(parancs.equals("Ksn")) {
					new Keresztez�S�n();

				} else if(parancs.equals("All")) {
					int db=4;
					String sz�n;
					boolean utas;

					char[] temp = new char[20];
					while(sor.charAt(db++) != ','){
						temp[db-4]=sor.charAt(db);
					}
					sz�n=temp.toString();

					if (sor.substring(db,db+1)=="1"){
						utas=true;
					} else {
						utas=false;
					}

					new �llom�s(sz�n, utas);

				} else if(parancs.equals("Mzd")) {

				} else if(parancs.equals("Snk")) {

				} else if(parancs.equals("Smk")) {

				} else {
					System.out.println("Nem megfelel� parancs.");
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void finalize() throws Throwable {

	}

	public static P�lyaGener�l� getInstance() {
		if(me == null) {
			me = new P�lyaGener�l�();
		}

		return me;
	}

	/**
	 * P�lya bet�lt�s�rt, felel�s f�ggv�ny.
	 * A Szkeletonban csak 2 Csom�pontot, az �ket �sszek�t� SinElemeket,
	 * kett� kocsit, �s az �ket huz� mozdonyt hozzuk l�tre, valamint az id�z�t�t,
	 * ami a vonatok mozgat�s��rt felel.
	 */

	public Id�z�t� kezd�s(){

	}

}