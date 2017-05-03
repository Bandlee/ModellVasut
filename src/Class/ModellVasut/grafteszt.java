package Class.ModellVasut;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Akos on 2017.05.02..
 */
public class grafteszt {
    /**
     * itt felhaszn�lt dolgok vannak t�bb�/kev�sb� k�szen
     * @param args
     */
    public static void main (String args[]) {
        View tv1 = new View();

        Csom�pont csp1 = new Csom�pont(200,200);
        Csom�pont csp2 = new Csom�pont(456, 600);
        Csom�pont csp3 = new Csom�pont(1000, 50);

//        S�nElem.�sszek�t(csp1,csp2,true);
//        S�nElem.�sszek�t(csp2,csp3,true);
        GrafS�n gs1 = new GrafS�n(csp1,csp2);
        GrafS�n gs2= new GrafS�n(csp2,csp3);
        GrafS�n gs3= new GrafS�n(csp1,csp3);

        Mozdony m1 = new Mozdony(csp1,2);
        m1.setIr�ny(true);
        m1.setPoz�ci�(new S�nElem(csp2,csp1));



        Mozdony m2 = new Mozdony(csp1,8);
        m2.setIr�ny(true);
        m2.setPoz�ci�(new S�nElem(csp2,csp1));



        SzenesKocsi sznk1 = new SzenesKocsi();
        sznk1.setIr�ny(true);
        sznk1.setPoz�ci�(new S�nElem(csp2,csp1));
        m1.setK�vetkez�(sznk1);
        m1.getPoz�ci�().setEl�z�(sznk1.getPoz�ci�());

        ArrayList<IMegjelen�thet�> lista = new ArrayList<IMegjelen�thet�>();
        lista.add(csp1);
        lista.add(csp2);
        lista.add(csp3);
        lista.add(gs1);
        lista.add(gs2);
        lista.add(gs3);

        lista.add(sznk1);
        lista.add(m1);
        lista.add(m2);
        tv1.setElemek(lista);

        tv1.mindenRajzol�sa();
        try {
            while (true) {
                m1.tickAkci�();
                m2.tickAkci�();
                tv1.mindenRajzol�sa();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }
        } catch(VegException e)
        {
            System.out.println("gameover");
        }




    }


}
