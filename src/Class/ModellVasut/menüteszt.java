package Class.ModellVasut;

import java.util.ArrayList;

/**
 * Created by Akos on 2017.05.05..
 */
public class men�teszt {
    public static void main(String args[]) {
        View tv1 = new View(null); //out of order

        Men� m�1 = new Men�("ki�r�s",null);





        ArrayList<IMegjelen�thet�> lista = new ArrayList<IMegjelen�thet�>();

        lista.add(m�1);

        tv1.setElemek(lista);

        ArrayList<IKattinthat�> listakatt = new ArrayList<IKattinthat�>();
        listakatt.add(m�1);


        tv1.mindenRajzol�sa();
    }
}
