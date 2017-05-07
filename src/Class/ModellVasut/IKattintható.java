package Class.ModellVasut;

import java.awt.event.MouseEvent;

/**
 * Interface kattintható osztályokhoz.
 * Created by Akos on 2017.05.03..
 */
public interface IKattintható {
    /**
     * Kattintás relevanciájának ellenörzése, valamint szükség szerint
     * az érvényes kattintás utáni müveletek elvégzése.
     * @param e kattintást leíró érték
     * @return kattintás okoztt-e változást
     */
    boolean voltKattintva(MouseEvent e);
}
