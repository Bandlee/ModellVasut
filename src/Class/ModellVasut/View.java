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
 * Megjelen�t�s�rt felel�s ozt�ly.
 * Created by Akos on 2017.05.02..
 */
public class View {
    /** program ablak */
    private JFrame ablak;

    /** megjelen�tend� elemek list�ja */
    private List<IMegjelen�thet�> elemek;

    /** n�zethez tartoz� Controller*/
    private Controller ctrl;


    /**
     * N�zet konstruktora.
     * L�trehozza a megjelen�t� fel�letet, valamint regisztr�l egy kattint�s
     * esem�nykezel�t, ami tov�bbk�ldi a MouseEvent-et a Controllernek
     * @param _ctrl n�zethez rendelt Controller
     */
    public View(Controller _ctrl){
        ctrl = _ctrl;
        ablak = new JFrame();
        ablak.setSize(1200,800);
        ablak.setVisible(true);

        /** Megjelen�t� fel�let*/
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (elemek!=null)
                    for (IMegjelen�thet� elem : elemek) {
                        elem.rajzol(g);
                    }

            }
        };
        /** esem�nykezel� kattint�sra */
        panel.addMouseListener(new MouseAdapter() {
                                  @Override
                                  public void mousePressed(MouseEvent e) {
                                      super.mousePressed(e);
                                      ctrl.katt(e);
                                  }
                              });
        /** fel�let hozz�ad�sa az ablakhoz */
        ablak.add(panel);

        ablak.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(ablak,
                        "Biztos ki akarsz l�pni a j�t�kb�l?", "Kil�p�s meger�s�t�se",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    bez�r�s();
                }
            }
        });
    }

    /** �jrarajzoltatja az ablakot */
    public void mindenRajzol�sa() {
        ablak.revalidate();
        System.out.println("Repaint called");
    }

    /**
     * Be�ll�tja a megjelen�tend� elemek list�j�t a kapott list�ra
     * @param elemek be�ll�tand� �rt�k
     */
    public void setElemek(List<IMegjelen�thet�> elemek) {
        this.elemek = elemek;
    }

    /**
     * Ablak bez�r�s�t megval�s�t� f�ggv�ny.
     */
    public void bez�r�s() {
        ablak.setVisible(false);
        ablak.dispose();
    }
}
