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
    private List<IMegjelen�thet�> elemek;


    View(){
        ablak = new JFrame();
        ablak.setSize(1200,800);
        ablak.setVisible(true);

        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (elemek!=null)
                for (IMegjelen�thet� elem : elemek) {
                    elem.rajzol(g);
                }

            }
        };
        ablak.add(pane);

    }


    public void mindenRajzol�sa() {
        //ablak.removeAll();
        /*ablak.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                //rajzol�sa
                for (IMegjelen�thet� elem : elemek) {
                    elem.rajzol(g);
                }
            }
        });*/

        ablak.repaint();


    }

    //lehet redund�ns
    public void vesztett() {

    }

    public void setElemek(List<IMegjelen�thet�> elemek) {
        this.elemek = elemek;
    }


}
