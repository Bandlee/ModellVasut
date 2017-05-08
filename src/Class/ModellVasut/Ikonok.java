package Class.ModellVasut;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Ikonok bet�lt�s�re, �s megjelen�tett k�pek m�retar�nyainak
 * sz�montart�s�ra l�trehozott oszt�ly.
 * Created by Akos on 2017.05.05..
 */
public class Ikonok {
    /** Ikonokat t�rol� map, a k�pekhez a f�jlnev�k tartozik */
    static private HashMap<String,BufferedImage> imgMap;
    /** Csom�pontok nagy�t�s�t megad� v�ltoz� */
    static private double ScaleCsp;
    /** VonatElemek nagy�t�s�t megad� v�ltoz� */
    static private double ScaleVe ;

    /**
     * Inicializ�lja az oszt�lyt.
     * Beolvassa az Ikonok mapp�ban tal�lhat� k�peket, be�ll�tja a m�retar�nyokat.
     * @param nagy�t�sCsp csom�pontok nagy�t�sda
     * @param nagy�t�sVe vonatelemek nagy�t�sa
     */
    static public void Init(double nagy�t�sCsp, double nagy�t�sVe){
        imgMap = new HashMap<>();
        File folder = new File("Ikonok");
        File[] ik = folder.listFiles();
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

    /**
     * Adott stringhez tartoz� k�p lek�r�se.
     * @param f�jln�v k�p f�jlneve
     * @return k�rt k�p
     */
    static public BufferedImage getIkon(String f�jln�v) {
        return imgMap.get(f�jln�v);
    }

    /**
     * Csom�pontok nagy�t�s�nak lek�r�sre haszn�lt f�ggv�ny
     * @return csom�pontok nagy�t�sa
     */
    static public double getNagy�t�sCsp(){
        return ScaleCsp;
    }

    /**
     * VonatElemek nagy�t�s�nak lek�r�sre haszn�lt f�ggv�ny
     * @return vonatelemek nagy�t�sa
     */
    static public double getNagy�t�sVe(){
        return ScaleVe;
    }


}
