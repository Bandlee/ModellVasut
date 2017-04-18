package Class.ModellVasut;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
		szint = 0;
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
        bemenet = new File("tesztbe" + String.valueOf(szint));
        BufferedReader br = null;
        List<Csom�pont> csom�pontList= new ArrayList<>();
        List<Mozdony> mozdonyList = new ArrayList<>();
        Id�z�t� id� = new Id�z�t�(mozdonyList);
        try {
            br=new BufferedReader(new FileReader(bemenet));
            String sor;
            while((sor=br.readLine()).equals("Start")){
                String parancs=sor.substring(0,3);

                if(parancs.equals("Csp")){
                    csom�pontList.add(new Csom�pont());
                } else if(parancs.equals("Vlt")) {
                    csom�pontList.add(new V�lt�());

                } else if(parancs.equals("Als")) {
                    csom�pontList.add(new Alag�tSz�j());

                } else if(parancs.equals("Sel")) {
                    int csp1=Integer.parseInt(sor.substring(4,5));
                    Csom�pont cs1=null;
                    for (Csom�pont cs: csom�pontList) {
                        if(cs.getId()==csp1) cs1=cs;
                    }

                    int csp2=Integer.parseInt(sor.substring(6,7));
                    Csom�pont cs2=null;
                    for (Csom�pont cs: csom�pontList) {
                        if(cs.getId()==csp2) cs2=cs;
                    }

                    int db=Integer.parseInt(sor.substring(8,9));

                    List<S�nElem> temp_se =new ArrayList<>();
                    for(int i=0;i<db;i++) temp_se.add(new S�nElem(cs1, cs2, true));

                    if (temp_se.size()>1) {
                        for (int i = 0; i < temp_se.size() - 1; i++) {
                            temp_se.get(i).setK�vetkez�(temp_se.get(i+1));
                        }
                    }

                } else if(parancs.equals("Ksn")) {
                    csom�pontList.add(new Keresztez�S�n());

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

                    csom�pontList.add(new �llom�s(sz�n, utas));

                } else if(parancs.equals("Mzd")) {

                } else if(parancs.equals("Snk")) {


                } else if(parancs.equals("Smk")) {

                } else {
                    System.out.println("Nem megfelel� parancs.");
                }
            }



            while((sor=br.readLine())!=null){
                String parancs=sor.substring(0,3);
                String index = sor.substring(5,6);
                if(sor.equals("tick")){
                    id�.tick();
                } else if(parancs.equals("Swc")) {
                    csom�pontList.get(Integer.parseInt(index)-1).felhaszn�l�Akci�();
                } else if(parancs.equals("Akt")) {
                    csom�pontList.get(Integer.parseInt(index)-1).felhaszn�l�Akci�();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return id�;
    }

}