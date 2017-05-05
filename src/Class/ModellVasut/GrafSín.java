package Class.ModellVasut;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Akos on 2017.05.02..
 */
public class GrafS�n implements IMegjelen�thet� {
    private AffineTransform at;
    BufferedImage img;

    GrafS�n(Csom�pont cs1, Csom�pont cs2){
        if (cs1.getX()<=cs2.getX())
            S�nElem.�sszek�t(cs1,cs2,true);
        else
            S�nElem.�sszek�t(cs2,cs1,true);

        double x_dist = (cs2.getX()-cs1.getX());
        double y_dist = (cs2.getY()-cs1.getY());
        double szh =  Math.sqrt(x_dist*x_dist + y_dist*y_dist);
        double rad = Math.atan(y_dist/x_dist);

        try {
            img = ImageIO.read(new File("Ikonok/sinek_temp.png"));
            img = img.getSubimage(0,0,(int)szh,40);


            //http://stackoverflow.com/questions/4918482/rotating-bufferedimage-instances
            at = new AffineTransform();

            at.translate(cs1.getX()+x_dist/2,cs1.getY()+y_dist/2);

            at.rotate(rad);

            at.scale(1,Ikonok.getNagy�t�sVe());

            at.translate(-img.getWidth()/2,-img.getHeight()/2);

        } catch (IOException e)
        {
            e.printStackTrace();
        }



    }

    @Override
    public void rajzol(Graphics g) {
            Graphics2D g2d= (Graphics2D) g;
            g2d.drawImage(img,at,null);
    }
}
