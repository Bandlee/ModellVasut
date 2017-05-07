package Class.ModellVasut;

import java.awt.event.MouseEvent;

/**
 * Interface kattinthat� oszt�lyokhoz.
 * Created by Akos on 2017.05.03..
 */
public interface IKattinthat� {
    /**
     * Kattint�s relevanci�j�nak ellen�rz�se, valamint sz�ks�g szerint
     * az �rv�nyes kattint�s ut�ni m�veletek elv�gz�se.
     * @param e kattint�st le�r� �rt�k
     * @return kattint�s okoztt-e v�ltoz�st
     */
    boolean voltKattintva(MouseEvent e);
}
