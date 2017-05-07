package Class.ModellVasut;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Megjelenítésért felelõs oztály.
 * Created by Akos on 2017.05.02..
 */
public class View {
    /** program ablak */
    private JFrame ablak;

    /** megjelenítendõ elemek listája */
    private List<IMegjeleníthetõ> elemek;

    /** nézethez tartozó Controller*/
    private Controller ctrl;


    /**
     * Nézet konstruktora.
     * Létrehozza a megjelenítõ felületet, valamint regisztrál egy kattintás
     * eseménykezelõt, ami továbbküldi a MouseEvent-et a Controllernek
     * @param _ctrl nézethez rendelt Controller
     */
    public View(Controller _ctrl){
        ctrl = _ctrl;
        ablak = new JFrame();
        ablak.setSize(1200,800);
        ablak.setVisible(true);

        /** Megjelenítõ felület*/
        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (elemek!=null)
                    for (IMegjeleníthetõ elem : elemek) {
                        elem.rajzol(g);
                    }

            }
        };
        /** eseménykezelõ kattintásra */
        pane.addMouseListener(new MouseAdapter() {
                                  @Override
                                  public void mousePressed(MouseEvent e) {
                                      super.mousePressed(e);
                                      ctrl.katt(e);
                                  }
                              });
        /** felület hozzáadása az ablakhoz */
        ablak.add(pane);
    }

    /** újrarajzoltatja az ablakot */
    public void mindenRajzolása() {
        ablak.repaint();

    }

    /**
     * Beállítja a megjelenítendõ elemek listáját a kapott listára
     * @param elemek beállítandó érték
     */
    public void setElemek(List<IMegjeleníthetõ> elemek) {
        this.elemek = elemek;
    }

    /**
     * Ablak bezárását megvalósító függvény.
     */
    public void bezárás() {
        ablak.setVisible(false);
        ablak.dispose();
    }
}
