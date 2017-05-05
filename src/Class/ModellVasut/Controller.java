package Class.ModellVasut;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * Created by Akos on 2017.05.05..
 */
public class Controller {

    private View nézet;
    private List<IKattintható> kattinthatók;
    private Idõzítõ idõzítõ;

    public Controller(){
        nézet = new View(this);
        menüMegnyitása("Welcome");
    }

    public void start(){
        if (idõzítõ != null) {
            idõzítõ.schedule(new TimerTask() {

                @Override
                public void run() {
                    try {
                        idõzítõ.tick();
                    } catch (VegException e) {
                        játékVége(); //Controller::játékVége()
                    }
                }
            }, idõzítõ.getCiklusidõ(), idõzítõ.getCiklusidõ());
        }

        else {

        }

    }


    public  void játékVége() {
        idõzítõ.cancel();
        menüMegnyitása("Game Over!");
    }

    public void setElemek(List<IMegjeleníthetõ> elemek){
        nézet.setElemek(elemek);
    }

    public  void setKattinthatók(List<IKattintható> _kattinthatók){
        kattinthatók = _kattinthatók;
    }

    public void setIdõzítõ(Idõzítõ _idõzítõ) {
        idõzítõ = _idõzítõ;
    }

    public void katt(MouseEvent e){
        boolean ujrarajzol = false;
        for (IKattintható k : kattinthatók)
        {
            if(k.voltKattintva(e))
                ujrarajzol = true;
        }

        if(ujrarajzol)
            nézet.mindenRajzolása();

    }

    public void menüMegnyitása(String msg){
        Menü menü = new Menü(msg);
        ArrayList<IMegjeleníthetõ> lista = new ArrayList<IMegjeleníthetõ>();
        ArrayList<IKattintható> listakatt = new ArrayList<IKattintható>();

        lista.add(menü);
        setElemek(lista);

        listakatt.add(menü);
        setKattinthatók(listakatt);

        nézet.mindenRajzolása();


    }



}
