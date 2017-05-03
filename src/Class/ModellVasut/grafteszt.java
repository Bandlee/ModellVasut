package Class.ModellVasut;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Akos on 2017.05.02..
 */
public class grafteszt {
    /**
     * itt felhasznált dolgok vannak többé/kevésbé készen
     * @param args
     */
    public static void main (String args[]) {
        View tv1 = new View();

        Csomópont csp1 = new Csomópont(200,200);
        Csomópont csp2 = new Csomópont(456, 600);
        Csomópont csp3 = new Csomópont(1000, 50);

//        SínElem.összeköt(csp1,csp2,true);
//        SínElem.összeköt(csp2,csp3,true);
        GrafSín gs1 = new GrafSín(csp1,csp2);
        GrafSín gs2= new GrafSín(csp2,csp3);
        GrafSín gs3= new GrafSín(csp1,csp3);

        Mozdony m1 = new Mozdony(csp1,2);
        m1.setIrány(true);
        m1.setPozíció(new SínElem(csp2,csp1));



        Mozdony m2 = new Mozdony(csp1,8);
        m2.setIrány(true);
        m2.setPozíció(new SínElem(csp2,csp1));



        SzenesKocsi sznk1 = new SzenesKocsi();
        sznk1.setIrány(true);
        sznk1.setPozíció(new SínElem(csp2,csp1));
        m1.setKövetkezõ(sznk1);
        m1.getPozíció().setElõzõ(sznk1.getPozíció());

        ArrayList<IMegjeleníthetõ> lista = new ArrayList<IMegjeleníthetõ>();
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

        tv1.mindenRajzolása();
        try {
            while (true) {
                m1.tickAkció();
                m2.tickAkció();
                tv1.mindenRajzolása();
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
