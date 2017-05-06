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

    private View n�zet;
    private List<IKattinthat�> kattinthat�k;
    private Id�z�t� id�z�t�;

    public Controller(){
        n�zet = new View(this);
        men�Megnyit�sa("Welcome");
    }

    public void start(){
        if (id�z�t� != null)
        {
            id�z�t�.schedule(new TimerTask() {

                @Override
                public void run() {
                    try {
                        id�z�t�.tick();
                        n�zet.mindenRajzol�sa();
                    } catch (VegException e) {
                        j�t�kV�ge("Game over!"); //Controller::j�t�kV�ge()
                    }
                }
            }, id�z�t�.getCiklusid�(), id�z�t�.getCiklusid�());
        }
        else {
            men�Megnyit�sa("Controller nem kapott id�z�t�t");
        }

    }


    public  void j�t�kV�ge(String msg) {
        id�z�t�.cancel();
        men�Megnyit�sa(msg);
    }

    public void setElemek(List<IMegjelen�thet�> elemek){
        n�zet.setElemek(elemek);
    }

    public  void setKattinthat�k(List<IKattinthat�> _kattinthat�k){
        kattinthat�k = _kattinthat�k;
    }

    public void setId�z�t�(Id�z�t� _id�z�t�)
    {
        if (id�z�t� != null)
            id�z�t�.cancel();

        id�z�t� = _id�z�t�;
    }

    public void katt(MouseEvent e){
        boolean ujrarajzol = false;
        for (IKattinthat� k : kattinthat�k)
        {
            if(k.voltKattintva(e))
                ujrarajzol = true;
        }

        if(ujrarajzol)
            n�zet.mindenRajzol�sa();

    }

    public void men�Megnyit�sa(String msg){
        Men� men� = new Men�(msg,this);
        ArrayList<IMegjelen�thet�> lista = new ArrayList<IMegjelen�thet�>();
        ArrayList<IKattinthat�> listakatt = new ArrayList<IKattinthat�>();

        lista.add(men�);
        setElemek(lista);

        listakatt.add(men�);
        setKattinthat�k(listakatt);

        n�zet.mindenRajzol�sa();
    }


    public void kil�p�s(){
        n�zet.bez�r�s();
    }



}
