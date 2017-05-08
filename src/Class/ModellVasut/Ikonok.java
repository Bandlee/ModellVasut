package Class.ModellVasut;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Ikonok betöltésére, és megjelenített képek méretarányainak
 * számontartására létrehozott osztály.
 * Created by Akos on 2017.05.05..
 */
public class Ikonok {
    /** Ikonokat tároló map, a képekhez a fájlnevük tartozik */
    static private HashMap<String,BufferedImage> imgMap;
    /** Csomópontok nagyítását megadó változó */
    static private double ScaleCsp;
    /** VonatElemek nagyítását megadó változó */
    static private double ScaleVe ;

    /**
     * Inicializálja az osztályt.
     * Beolvassa az Ikonok mappában található képeket, beállítja a méretarányokat.
     * @param nagyításCsp csomópontok nagyításda
     * @param nagyításVe vonatelemek nagyítása
     */
    static public void Init(double nagyításCsp, double nagyításVe){
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
        ScaleCsp = nagyításCsp;
        ScaleVe = nagyításVe;
        //return false;
    }

    /**
     * Adott stringhez tartozó kép lekérése.
     * @param fájlnév kép fájlneve
     * @return kért kép
     */
    static public BufferedImage getIkon(String fájlnév) {
        return imgMap.get(fájlnév);
    }

    /**
     * Csomópontok nagyításának lekérésre használt függvény
     * @return csomópontok nagyítása
     */
    static public double getNagyításCsp(){
        return ScaleCsp;
    }

    /**
     * VonatElemek nagyításának lekérésre használt függvény
     * @return vonatelemek nagyítása
     */
    static public double getNagyításVe(){
        return ScaleVe;
    }


}
