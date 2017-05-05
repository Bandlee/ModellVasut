package Class.ModellVasut;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Akos on 2017.05.05..
 */
public class Ikonok {
    static private HashMap<String,BufferedImage> imgMap;
    static private double ScaleCsp;
    static private double ScaleVe ;
   // static private double ScaleCsp;
    static public void Init(double nagy�t�sCsp, double nagy�t�sVe){
        imgMap = new HashMap<>();
        File folder = new File("Ikonok");
        File[] ik = folder.listFiles();
        //HashMap<String,BufferedImage> im = new HashMap<>();
        for (File f : ik) {
            try {
                BufferedImage bimg = ImageIO.read(f);
                imgMap.put(f.getName(),bimg);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        ScaleCsp = nagy�t�sCsp;
        ScaleVe = nagy�t�sVe;
        //return false;
    }


    static public BufferedImage getIkon(String f�jln�v) {
        return imgMap.get(f�jln�v);
    }


    static public double getNagy�t�sCsp(){
        return ScaleCsp;
    }

    static public double getNagy�t�sVe(){
        return ScaleVe;
    }


}
