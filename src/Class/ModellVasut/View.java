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
 * Created by Akos on 2017.05.02..
 */
public class View {

    private JFrame ablak;
    private List<IMegjeleníthetõ> elemek;
    public List<IKattintható> akcióCs; //temp, nem fog itt maradni

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

        //controllernek lesz továbbadva majd, aki ugyanezt fogja csinálni
        ablak.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);
                boolean refresh = false;
                if (akcióCs!=null)
                for (IKattintható ik : akcióCs){
                    if (ik.voltKattintva(e)) refresh = true;
                }
                if (refresh) mindenRajzolása();

            }
        }
        );

    }


    public void mindenRajzolása() {
        ablak.repaint();

    }

    //lehet redundáns
    public void vesztett() {

    }

    public void setElemek(List<IMegjeleníthetõ> elemek) {
        this.elemek = elemek;
    }



}
