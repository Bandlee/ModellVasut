package Class.ModellVasut;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * Controllert megval�s�t� oszt�ly
 * Created by Akos on 2017.05.05..
 */
public class Controller {

    /** Megjelen�t�s�r felel�s objektum */
    private View n�zet;

    /** Elemek, amikre kattint�s ellen�rz�st kell v�gezni kattint�skor */
    private List<IKattinthat�> kattinthat�k;

    /** Az aktu�lis j�t�k id�z�t�je */
    private Id�z�t� id�z�t�;

    /**
     * Controller konstruktora.
     * L�trehozza egyben a n�zetet, valamint megnyitja a men�t.
     */
    public Controller(){
        n�zet = new View(this);
    }


    /**
     * Elind�tja z aktu�lis j�t�k id�z�t�j�t.
     * Peri�dikusan �rajelet fog kapni a model, minden �rajel
     * ut�n rajzoltatunk a n�zettel.
     * J�t�k v�ge eset�n megh�vjuk a controller j�t�kV�ge f�ggv�ny�t.
     */
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
            }, 0, id�z�t�.getCiklusid�());
        }
        else {
            men�Megnyit�sa("Controller nem kapott id�z�t�t");
        }

    }

    /**
     * J�t�k v�g�n megh�vand� f�ggv�ny.
     * Le�ll�tja az id�z�t�t, majd megnyitja a men�t a kapott string �zenettel.
     * @param msg men�ben megjelen�tend� �ezenet
     */
    public  void j�t�kV�ge(String msg) {
        id�z�t�.cancel();
        men�Megnyit�sa(msg);
    }

    /**
     * Megjelen�tend� elemek be�ll�t�sa.
     * Tov�bbadja a list�t a n�zetnek (aminek felel�ss�ge a megjelen�t�s).
     * @param elemek megjelen�tend� elemek list�ja
     */
    public void setElemek(List<IMegjelen�thet�> elemek){
        n�zet.setElemek(elemek);
    }


    /**
     * Kattinthat� elemek be�ll�t�sa.
     * Be�ll�tja a kattinthat�k list�t a kapott list�ra.
     * @param _kattinthat�k kattinthat� elemek list�ja
     */
    public  void setKattinthat�k(List<IKattinthat�> _kattinthat�k){
        kattinthat�k = _kattinthat�k;
    }


    /**
     * Le�ll�tja az id�z�t�t (ha l�tezik), miel�tt �t�ll�tan� azt az �j �rt�kre.
     * @param _id�z�t� be�ll�tand� �rt�k
     */
    public void setId�z�t�(Id�z�t� _id�z�t�)
    {
        if (id�z�t� != null)
            id�z�t�.cancel();

        id�z�t� = _id�z�t�;
    }

    /**
     * V�gign�zi a kattinthat� elemek list�j�ban, hogy �rint-e valamit a kattint�s.
     * Ha legal�bb egy valamit �rint, akkor �jrarajzoltatja az ablakot.
     * @param e kattint�st le�r� objektum
     */
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

    /**
     * Men� megnyit�s�ra haszn�latos f�ggv�ny.
     * L�trehoz egy men�t, majd list�kba teszi �s be�ll�tja
     * megjelen�t�sre �s kattint�s ellen�rz�se.
     * @param msg men�ben ki�rand� �zenet
     */
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

    /**
     * Program bez�r�sra - bez�rja a n�zetet.
     */
    public void kil�p�s(){
        n�zet.bez�r�s();
        if(id�z�t� != null) id�z�t�.cancel();
    }



}
