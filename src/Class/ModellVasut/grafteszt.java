package Class.ModellVasut;

import javax.swing.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Akos on 2017.05.02..
 */
public class grafteszt {
    /**
     * itt felhasznált dolgok vannak többé/kevésbé készen
     * @param args
     */
    public static void main (String args[]) {
        View tv1 = new View(null);//out of order
        Ikonok.Init(0.7,0.6);
        Csomópont csp1 = new Csomópont(100,100);
        Csomópont csp2 = new Csomópont(300, 300);
        //Csomópont csp3 = new Csomópont(1000, 50);
        Csomópont csp3 = new Csomópont(1300, 700);
        Váltó vlt1 = new Váltó(1000, 50);
        AlagútSzáj alsz1 = new AlagútSzáj(1050,300);
        AlagútSzáj alsz2 = new AlagútSzáj(200,500);


//        SínElem.összeköt(csp1,csp2,true);
//        SínElem.összeköt(csp2,csp3,true);
        GrafSín gs1 = new GrafSín(csp1,csp2);
        GrafSín gs2= new GrafSín(csp2,vlt1);
        GrafSín gs3= new GrafSín(csp1,vlt1);
        GrafSín gs4 = new GrafSín(vlt1, alsz1);
        GrafSín gs5 = new GrafSín(alsz2,csp3);

        Mozdony m1 = new Mozdony(csp1,2);
        m1.setIrány(true);
        m1.setPozíció(new SínElem(csp1));



        Mozdony m2 = new Mozdony(csp1,8);
        m2.setIrány(true);
        m2.setPozíció(new SínElem(csp1));



        SzenesKocsi sznk1 = new SzenesKocsi(m1);

       // sznk1.setIrány(true);
        //sznk1.setPozíció(new SínElem(csp1));
        //m1.setKövetkezõ(sznk1);
        //m1.getPozíció().setElõzõ(sznk1.getPozíció());


        SzemélyKocsi szmk1 = new SzemélyKocsi("piros",true,sznk1);




        ArrayList<IMegjeleníthetõ> lista = new ArrayList<IMegjeleníthetõ>();

        lista.add(gs1);
        lista.add(gs2);
        lista.add(gs3);
        lista.add(gs4);
        lista.add(gs5);

        lista.add(csp1);
        lista.add(csp2);
        lista.add(csp3);
        lista.add(vlt1);
        lista.add(alsz1);
        lista.add(alsz2);

        lista.add(szmk1);
        lista.add(sznk1);
        lista.add(m1);
        lista.add(m2);
        tv1.setElemek(lista);

        ArrayList<IKattintható> listakatt = new ArrayList<IKattintható>();
        listakatt.add(vlt1);
        listakatt.add(alsz1);
        listakatt.add(alsz2);

       // tv1.akcióCs = listakatt;

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

//        Timer idöz = new Timer();
//        idöz.schedule(new TimerTask() {
//            @Override
//            public void run() {
//
//
//                     try {
//                         m2.tickAkció();
//                         m1.tickAkció();
//                     } catch (VegException e) {
//                         e.printStackTrace();
//                     }
//                     tv1.mindenRajzolása();
//                }
//        },1000,200);






    }


}
