package Class.ModellVasut;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A bemeneti fájlok alapján építi fel a pályát, beolvas néhány elvégzendõ parancsot, majd végre is hajtja õket.
 * @author Bandi
 * @version 1.0
 * @created 11-márc.-2017 3:39:56
 */
public class PályaGeneráló {

	private static PályaGeneráló me = null;
	private Controller ctrl;
	private int szint;
	private int sebesség;

    /**
     * Konstruktor. Mivel csak egyetlen példány létezik az osztályból, a konstruktor privát.
     */
	private PályaGeneráló(){
		szint =0;
	}

	public void finalize() throws Throwable {

	}

    /**
     * Csak egy példány létezik a PályaGenerálóból, ez a metódus biztosítja ennek a lekérését.
     * Amennyiben még nem létezik az adott példány, létrehozza mert õ hozzáfér a konstruktorhoz.
     * @return a pályageneráló példánya
     */
	public static PályaGeneráló getInstance() {
		if(me == null) {
			me = new PályaGeneráló();
		}
		return me;
	}


	/**
	 * Játékból hívandó kezdés.
	 * Növeli a szintet egyel, majd betölti a pályát változatlan sebességgel.
	 * @return játék idõzítõje
	 */
	public Idõzítõ kezdés() {
		szint++;
		Idõzítõ idõ= null;
		try {
			idõ = kezdés(szint,sebesség,ctrl);
		} catch (IOException e) {
			ctrl.játékVége("Nincs következõ pálya :(");
			//String szint = e.getMessage().substring(5,6);
			//ctrl.játékVége("Nincs " +szint + ". pálya :(");
		}
		return idõ;
	}


	/**
	 *
	 * @param _szint betöltendö pályát határozza meg
	 * @param _sebesség játék sebességét határozza meg
	 * @param _ctrl a program controllere, aminek átadjuk a megfelelõ elemeket listába rendezve
	 * @returnn játék idõzítõje
	 */
	public Idõzítõ kezdés(int _szint, int _sebesség, Controller _ctrl) throws IOException {
		ctrl = _ctrl;
		szint = _szint;
		sebesség = _sebesség;
		File pályaFile = new File("Palya" +szint +".txt");

		/** ezzel tartjuk számon az utasok számát a legenerált pályán */
		int nemleszállt = 0;

		/**Listák létrehozása, amit késöbb továbbadunka megfelelõ objektumoknak,
		 * ezekbe gyüjtük a létrehozott elemeket */
		//elejére szurunk be mindig
		List<VonatElem> vonatelemek = new LinkedList<>(); //->elemekbe majd

		List<Mozdony> mozdonyok = new LinkedList<>(); //->idõzítõnek csak
		List<Csomópont> csomópontok = new ArrayList<>(); //->elemekbe majd + pályagenhez kell (noid)
		List<KeresztezõSín> ksínek = new LinkedList<>(); //->idõzítõnek csak

		// fontos a sorrend kirajzolás miatt, nem mindent rakunk egybõl bele
		List<IMegjeleníthetõ> elemek = new LinkedList<>(); //->Controllernek

		List<IKattintható> kattinthatók = new LinkedList<>(); //->Controllernek


		BufferedReader br = null;
		String sor;


		br = new BufferedReader(new FileReader(pályaFile));
		sor = br.readLine();
		while(sor != null) {
			/** space/tab karakterek törlése a sorból */
			sor = sor.replaceAll("\\s","");

			/** parancs leválasztása */
			String parancs=sor.substring(0,3);

			/** parancs paramétereinek kinyerése*/
			String params[] = getParams(sor);

			/** Parancs végrehajtása a megadott paraméterekkel */
			switch (parancs) {
				case "Csp":
					csomópontok.add(new Csomópont(
							Integer.parseInt(params[0]),
							Integer.parseInt(params[1])
					));
					break;

				case "Ksn":
					KeresztezõSín ksn = new KeresztezõSín(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
					csomópontok.add(ksn);
					ksínek.add(ksn);
					break;

				case "Vlt":
					Váltó vlt = new Váltó(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
					csomópontok.add(vlt);
					kattinthatók.add(vlt);
					break;

				case "Asz":
					AlagútSzáj asz = new AlagútSzáj(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
					csomópontok.add(asz);
					kattinthatók.add(asz);
					break;

				case "All":
					csomópontok.add(new Állomás(
							params[0],
							params[1].equals("1"),
							Integer.parseInt(params[2]),
							Integer.parseInt(params[3])
					));
					if (params[1].equals("1")) nemleszállt++;
					break;

					//harmadik paramétert nem veszi figyelembe
				case "Sel":
					elemek.add(new GrafSín(
						csomópontok.get(Integer.parseInt(params[0])-1),
						csomópontok.get(Integer.parseInt(params[1])-1)
					));
					break;

				case "Mzd":
					Mozdony mzd = new Mozdony(
							csomópontok.get(Integer.parseInt(params[0])-1),
							Integer.parseInt(params[1])
					);
					vonatelemek.add(0,mzd);
					mozdonyok.add(mzd);
					break;

				case "Snk":
					vonatelemek.add(0,new SzenesKocsi(vonatelemek.get(0)));
					break;

				case "Smk":
					vonatelemek.add(0,new SzemélyKocsi(
							params[0],
							params[1].equals("1"),
							vonatelemek.get(0)
					));
					if (params[1].equals("1")) nemleszállt++;
					break;
			}
			sor = br.readLine();
		}
		for (Csomópont csp : csomópontok)
			elemek.add(csp);

		for (VonatElem ve : vonatelemek)
			elemek.add(ve);

		Idõzítõ idõ = new Idõzítõ(mozdonyok,ksínek,sebesség);
		Állomás.setNemleszállt(nemleszállt);
		ctrl.setElemek(elemek);
		ctrl.setKattinthatók(kattinthatók);
		ctrl.setIdõzítõ(idõ);
		ctrl.start();

		return idõ;
	}

	/**
	 * Segédfüggvény pályageneráláshoz.
	 * Kiszedi a vesszõvel elválasztott paramétereket a zárójelek közül.
	 * @param sor string, amibõl kiszedjük a paramétereket
	 * @return paraméterek tömbje
	 */
	private String[] getParams(String sor){
		int start = sor.indexOf('(')+1;
		int end = sor.indexOf(')');
		return sor.substring(start,end).split(",");
	}

}