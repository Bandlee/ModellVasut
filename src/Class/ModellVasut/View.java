package Class.ModellVasut;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by Akos on 2017.05.02..
 */
public class View {

    private JFrame ablak;
    private List<IMegjeleníthetõ> elemek;


    View(){
        ablak = new JFrame();
        ablak.setSize(1200,800);
        ablak.setVisible(true);

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
        ablak.add(pane);

    }


    public void mindenRajzolása() {
        //ablak.removeAll();
        /*ablak.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                //rajzolása
                for (IMegjeleníthetõ elem : elemek) {
                    elem.rajzol(g);
                }
            }
        });*/

        ablak.repaint();


    }

    //lehet redundáns
    public void vesztett() {

    }

    public void setElemek(List<IMegjeleníthetõ> elemek) {
        this.elemek = elemek;
    }


}
