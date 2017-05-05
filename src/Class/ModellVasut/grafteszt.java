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
     * itt felhaszn�lt dolgok vannak t�bb�/kev�sb� k�szen
     * @param args
     */
    public static void main (String args[]) {
        View tv1 = new View(null);//out of order
        Ikonok.Init(0.7,0.6);
        Csom�pont csp1 = new Csom�pont(100,100);
        Csom�pont csp2 = new Csom�pont(300, 300);
        //Csom�pont csp3 = new Csom�pont(1000, 50);
        Csom�pont csp3 = new Csom�pont(1300, 700);
        V�lt� vlt1 = new V�lt�(1000, 50);
        Alag�tSz�j alsz1 = new Alag�tSz�j(1050,300);
        Alag�tSz�j alsz2 = new Alag�tSz�j(200,500);


//        S�nElem.�sszek�t(csp1,csp2,true);
//        S�nElem.�sszek�t(csp2,csp3,true);
        GrafS�n gs1 = new GrafS�n(csp1,csp2);
        GrafS�n gs2= new GrafS�n(csp2,vlt1);
        GrafS�n gs3= new GrafS�n(csp1,vlt1);
        GrafS�n gs4 = new GrafS�n(vlt1, alsz1);
        GrafS�n gs5 = new GrafS�n(alsz2,csp3);

        Mozdony m1 = new Mozdony(csp1,2);
        m1.setIr�ny(true);
        m1.setPoz�ci�(new S�nElem(csp1));



        Mozdony m2 = new Mozdony(csp1,8);
        m2.setIr�ny(true);
        m2.setPoz�ci�(new S�nElem(csp1));



        SzenesKocsi sznk1 = new SzenesKocsi(m1);

       // sznk1.setIr�ny(true);
        //sznk1.setPoz�ci�(new S�nElem(csp1));
        //m1.setK�vetkez�(sznk1);
        //m1.getPoz�ci�().setEl�z�(sznk1.getPoz�ci�());


        Szem�lyKocsi szmk1 = new Szem�lyKocsi("piros",true,sznk1);




        ArrayList<IMegjelen�thet�> lista = new ArrayList<IMegjelen�thet�>();

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

        ArrayList<IKattinthat�> listakatt = new ArrayList<IKattinthat�>();
        listakatt.add(vlt1);
        listakatt.add(alsz1);
        listakatt.add(alsz2);

       // tv1.akci�Cs = listakatt;

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

//        Timer id�z = new Timer();
//        id�z.schedule(new TimerTask() {
//            @Override
//            public void run() {
//
//
//                     try {
//                         m2.tickAkci�();
//                         m1.tickAkci�();
//                     } catch (VegException e) {
//                         e.printStackTrace();
//                     }
//                     tv1.mindenRajzol�sa();
//                }
//        },1000,200);






    }


}
