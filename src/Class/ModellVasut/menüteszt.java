package Class.ModellVasut;

import java.util.ArrayList;

/**
 * Created by Akos on 2017.05.05..
 */
public class menüteszt {
    public static void main(String args[]) {
        View tv1 = new View();

        Menü mü1 = new Menü("kiírás");





        ArrayList<IMegjeleníthetõ> lista = new ArrayList<IMegjeleníthetõ>();

        lista.add(mü1);

        tv1.setElemek(lista);

        ArrayList<IKattintható> listakatt = new ArrayList<IKattintható>();
        listakatt.add(mü1);


        tv1.akcióCs = listakatt;
        tv1.mindenRajzolása();
    }
}
