package Class.ModellVasut;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A bemeneti f�jlok alapj�n �p�ti fel a p�ly�t, beolvas n�h�ny elv�gzend� parancsot, majd v�gre is hajtja �ket.
 * @author Bandi
 * @version 1.0
 * @created 11-m�rc.-2017 3:39:56
 */
public class P�lyaGener�l� {

	private static P�lyaGener�l� me = null;
	private Controller ctrl;
	private int szint;
	private int sebess�g;

    /**
     * Konstruktor. Mivel csak egyetlen p�ld�ny l�tezik az oszt�lyb�l, a konstruktor priv�t.
     */
	private P�lyaGener�l�(){
		szint =0;
	}

	public void finalize() throws Throwable {

	}

    /**
     * Csak egy p�ld�ny l�tezik a P�lyaGener�l�b�l, ez a met�dus biztos�tja ennek a lek�r�s�t.
     * Amennyiben m�g nem l�tezik az adott p�ld�ny, l�trehozza mert � hozz�f�r a konstruktorhoz.
     * @return a p�lyagener�l� p�ld�nya
     */
	public static P�lyaGener�l� getInstance() {
		if(me == null) {
			me = new P�lyaGener�l�();
		}
		return me;
	}


	/**
	 * J�t�kb�l h�vand� kezd�s.
	 * N�veli a szintet egyel, majd bet�lti a p�ly�t v�ltozatlan sebess�ggel.
	 * @return j�t�k id�z�t�je
	 */
	public Id�z�t� kezd�s() {
		szint++;
		Id�z�t� id�= null;
		try {
			id� = kezd�s(szint,sebess�g,ctrl);
		} catch (IOException e) {
			ctrl.j�t�kV�ge("Nincs k�vetkez� p�lya :(");
			//String szint = e.getMessage().substring(5,6);
			//ctrl.j�t�kV�ge("Nincs " +szint + ". p�lya :(");
		}
		return id�;
	}


	/**
	 *
	 * @param _szint bet�ltend� p�ly�t hat�rozza meg
	 * @param _sebess�g j�t�k sebess�g�t hat�rozza meg
	 * @param _ctrl a program controllere, aminek �tadjuk a megfelel� elemeket list�ba rendezve
	 * @returnn j�t�k id�z�t�je
	 */
	public Id�z�t� kezd�s(int _szint, int _sebess�g, Controller _ctrl) throws IOException {
		ctrl = _ctrl;
		szint = _szint;
		sebess�g = _sebess�g;
		File p�lyaFile = new File("Palya" +szint +".txt");

		/** ezzel tartjuk sz�mon az utasok sz�m�t a legener�lt p�ly�n */
		int nemlesz�llt = 0;

		/**List�k l�trehoz�sa, amit k�s�bb tov�bbadunka megfelel� objektumoknak,
		 * ezekbe gy�jt�k a l�trehozott elemeket */
		//elej�re szurunk be mindig
		List<VonatElem> vonatelemek = new LinkedList<>(); //->elemekbe majd

		List<Mozdony> mozdonyok = new LinkedList<>(); //->id�z�t�nek csak
		List<Csom�pont> csom�pontok = new ArrayList<>(); //->elemekbe majd + p�lyagenhez kell (noid)
		List<Keresztez�S�n> ks�nek = new LinkedList<>(); //->id�z�t�nek csak

		// fontos a sorrend kirajzol�s miatt, nem mindent rakunk egyb�l bele
		List<IMegjelen�thet�> elemek = new LinkedList<>(); //->Controllernek

		List<IKattinthat�> kattinthat�k = new LinkedList<>(); //->Controllernek


		BufferedReader br = null;
		String sor;


		br = new BufferedReader(new FileReader(p�lyaFile));
		sor = br.readLine();
		while(sor != null) {
			/** space/tab karakterek t�rl�se a sorb�l */
			sor = sor.replaceAll("\\s","");

			/** parancs lev�laszt�sa */
			String parancs=sor.substring(0,3);

			/** parancs param�tereinek kinyer�se*/
			String params[] = getParams(sor);

			/** Parancs v�grehajt�sa a megadott param�terekkel */
			switch (parancs) {
				case "Csp":
					csom�pontok.add(new Csom�pont(
							Integer.parseInt(params[0]),
							Integer.parseInt(params[1])
					));
					break;

				case "Ksn":
					Keresztez�S�n ksn = new Keresztez�S�n(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
					csom�pontok.add(ksn);
					ks�nek.add(ksn);
					break;

				case "Vlt":
					V�lt� vlt = new V�lt�(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
					csom�pontok.add(vlt);
					kattinthat�k.add(vlt);
					break;

				case "Asz":
					Alag�tSz�j asz = new Alag�tSz�j(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
					csom�pontok.add(asz);
					kattinthat�k.add(asz);
					break;

				case "All":
					csom�pontok.add(new �llom�s(
							params[0],
							params[1].equals("1"),
							Integer.parseInt(params[2]),
							Integer.parseInt(params[3])
					));
					if (params[1].equals("1")) nemlesz�llt++;
					break;

					//harmadik param�tert nem veszi figyelembe
				case "Sel":
					elemek.add(new GrafS�n(
						csom�pontok.get(Integer.parseInt(params[0])-1),
						csom�pontok.get(Integer.parseInt(params[1])-1)
					));
					break;

				case "Mzd":
					Mozdony mzd = new Mozdony(
							csom�pontok.get(Integer.parseInt(params[0])-1),
							Integer.parseInt(params[1])
					);
					vonatelemek.add(0,mzd);
					mozdonyok.add(mzd);
					break;

				case "Snk":
					vonatelemek.add(0,new SzenesKocsi(vonatelemek.get(0)));
					break;

				case "Smk":
					vonatelemek.add(0,new Szem�lyKocsi(
							params[0],
							params[1].equals("1"),
							vonatelemek.get(0)
					));
					if (params[1].equals("1")) nemlesz�llt++;
					break;
			}
			sor = br.readLine();
		}
		for (Csom�pont csp : csom�pontok)
			elemek.add(csp);

		for (VonatElem ve : vonatelemek)
			elemek.add(ve);

		Id�z�t� id� = new Id�z�t�(mozdonyok,ks�nek,sebess�g);
		�llom�s.setNemlesz�llt(nemlesz�llt);
		ctrl.setElemek(elemek);
		ctrl.setKattinthat�k(kattinthat�k);
		ctrl.setId�z�t�(id�);
		ctrl.start();

		return id�;
	}

	/**
	 * Seg�df�ggv�ny p�lyagener�l�shoz.
	 * Kiszedi a vessz�vel elv�lasztott param�tereket a z�r�jelek k�z�l.
	 * @param sor string, amib�l kiszedj�k a param�tereket
	 * @return param�terek t�mbje
	 */
	private String[] getParams(String sor){
		int start = sor.indexOf('(')+1;
		int end = sor.indexOf(')');
		return sor.substring(start,end).split(",");
	}

}