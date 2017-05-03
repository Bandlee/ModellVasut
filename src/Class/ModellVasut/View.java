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
    private List<IMegjelen�thet�> elemek;
    public List<IKattinthat�> akci�Cs; //temp, nem fog itt maradni

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

        //controllernek lesz tov�bbadva majd, aki ugyanezt fogja csin�lni
        ablak.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);
                boolean refresh = false;
                if (akci�Cs!=null)
                for (IKattinthat� ik : akci�Cs){
                    if (ik.voltKattintva(e)) refresh = true;
                }
                if (refresh) mindenRajzol�sa();

            }
        }
        );

    }


    public void mindenRajzol�sa() {
        ablak.repaint();

    }

    //lehet redund�ns
    public void vesztett() {

    }

    public void setElemek(List<IMegjelen�thet�> elemek) {
        this.elemek = elemek;
    }



}
