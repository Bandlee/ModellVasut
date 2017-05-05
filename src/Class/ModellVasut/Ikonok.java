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
    static public void Init(double nagyításCsp, double nagyításVe){
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
        ScaleCsp = nagyításCsp;
        ScaleVe = nagyításVe;
        //return false;
    }


    static public BufferedImage getIkon(String fájlnév) {
        return imgMap.get(fájlnév);
    }


    static public double getNagyításCsp(){
        return ScaleCsp;
    }

    static public double getNagyításVe(){
        return ScaleVe;
    }


}
