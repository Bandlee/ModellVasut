package Class.ModellVasut;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * Controllert megvalósító osztály
 * Created by Akos on 2017.05.05..
 */
public class Controller {

    /** Megjelenítésér felelõs objektum */
    private View nézet;

    /** Elemek, amikre kattintás ellenörzést kell végezni kattintáskor */
    private List<IKattintható> kattinthatók;

    /** Az aktuális játék idõzítõje */
    private Idõzítõ idõzítõ;

    /**
     * Controller konstruktora.
     * Létrehozza egyben a nézetet, valamint megnyitja a menüt.
     */
    public Controller(){
        nézet = new View(this);
    }


    /**
     * Elindítja z aktuális játék idõzítõjét.
     * Periódikusan órajelet fog kapni a model, minden órajel
     * után rajzoltatunk a nézettel.
     * Játék vége esetén meghívjuk a controller játékVége függvényét.
     */
    public void start(){
        if (idõzítõ != null)
        {
            idõzítõ.schedule(new TimerTask() {

                @Override
                public void run() {
                    try {
                        idõzítõ.tick();
                        nézet.mindenRajzolása();
                    } catch (VegException e) {
                        játékVége("Game over!"); //Controller::játékVége()
                    }
                }
            }, 0, idõzítõ.getCiklusidõ());
        }
        else {
            menüMegnyitása("Controller nem kapott idõzítõt");
        }

    }

    /**
     * Játék végén meghívandó függvény.
     * Leállítja az idõzítõt, majd megnyitja a menüt a kapott string üzenettel.
     * @param msg menüben megjelenítendõ üezenet
     */
    public  void játékVége(String msg) {
        idõzítõ.cancel();
        menüMegnyitása(msg);
    }

    /**
     * Megjelenítendõ elemek beállítása.
     * Továbbadja a listát a nézetnek (aminek felelõssége a megjelenítés).
     * @param elemek megjelenítendõ elemek listája
     */
    public void setElemek(List<IMegjeleníthetõ> elemek){
        nézet.setElemek(elemek);
    }


    /**
     * Kattintható elemek beállítása.
     * Beállítja a kattinthatók listát a kapott listára.
     * @param _kattinthatók kattintható elemek listája
     */
    public  void setKattinthatók(List<IKattintható> _kattinthatók){
        kattinthatók = _kattinthatók;
    }


    /**
     * Leállítja az idõzítõt (ha létezik), mielõtt átállítaná azt az új értékre.
     * @param _idõzítõ beállítandó érték
     */
    public void setIdõzítõ(Idõzítõ _idõzítõ)
    {
        if (idõzítõ != null)
            idõzítõ.cancel();

        idõzítõ = _idõzítõ;
    }

    /**
     * Végignézi a kattintható elemek listájában, hogy érint-e valamit a kattintás.
     * Ha legalább egy valamit érint, akkor újrarajzoltatja az ablakot.
     * @param e kattintást leíró objektum
     */
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

    /**
     * Menü megnyitására használatos függvény.
     * Létrehoz egy menüt, majd listákba teszi és beállítja
     * megjelenítésre és kattintás ellenörzése.
     * @param msg menüben kiírandó üzenet
     */
    public void menüMegnyitása(String msg){
        Menü menü = new Menü(msg,this);
        ArrayList<IMegjeleníthetõ> lista = new ArrayList<IMegjeleníthetõ>();
        ArrayList<IKattintható> listakatt = new ArrayList<IKattintható>();

        lista.add(menü);
        setElemek(lista);

        listakatt.add(menü);
        setKattinthatók(listakatt);

        nézet.mindenRajzolása();
    }

    /**
     * Program bezárásra - bezárja a nézetet.
     */
    public void kilépés(){
        nézet.bezárás();
        if(idõzítõ != null) idõzítõ.cancel();
    }



}
