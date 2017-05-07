package Class.ModellVasut;

import java.awt.*;

/**
 * Interface grafikusan megjeleníthetõ osztályokhoz.
 * Created by Akos on 2017.05.02..
 */
public interface IMegjeleníthetõ {
    /**
     * Képernyõre rajzolás.
     * @param g Graphic objektum amivel kirajzol a megvalósító objektum a képernyõre.
     */
    void rajzol (Graphics g);
}
