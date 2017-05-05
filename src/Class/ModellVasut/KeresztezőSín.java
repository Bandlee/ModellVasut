package Class.ModellVasut;

import java.awt.*;
import java.util.List;

/**
 * A keresztezõ síneket megvalósító osztály
 * @author Peti
 * @version 1.0
 * @created 15-ápr.-2017 17:02:41
 */

/**
 * Az egymást keresztezõ sínek kapcsolódási pontját megvalósító osztály
 */
public class KeresztezõSín extends Csomópont {

    /**
     * A KeresztezõSínt Csomópontként, annak konstruktorával hozzuk létre.
     * A sínpárokat azok index-ével fogjuk azonosítani:
     * Összetartoznak a 0, 2 indexû és az 1, 3 indexû SínElemek
     */
    public KeresztezõSín (int x, int y) {
        super(x,y);
    }

    /**
     * A keresztezõdésbe érkezõ vonatot továbbítja a megfelelõ kimenetre
     * visszatérési értéke attól függ, hogy sikerül-e beállítani a a megfelelõ
     * változtatásokat.
     *
     * @param v a továbbítandó vonatelem
     * @param s megmutatja, honnan is érkezett a vonatelem
     */
    public boolean tovább(VonatElem v, SínElem s){
        SínElem hova = null;

        /** a forrás sínelem indexe alapján vizsgálunk */
        int i = befutóSínek.indexOf(s);

        /** ha az index 2-nél kisebb, akkor a párja (index+2) lesz */
        if(i < 2){
            hova = befutóSínek.get(i+2);
        }
        /** ha az index legalább 2, akkor a párja (index-2) lesz */
        else if(i >= 2){
            hova = befutóSínek.get(i-2);
        }
        if(hova == null){
            return false;
        } else{
            v.setPozíció(hova);
            if(hova.getSínvég1()==this) v.setIrány(true); else v.setIrány(false);
        }

        if(s.getÁthaladóElem()!=null && hova.getÁthaladóElem()!=null){
            if(s.getÁthaladóElem().getIrány()!=hova.getÁthaladóElem().getIrány()){
                return false;
            }
        }

        for (SínElem se: befutóSínek) {
            if (se != s && se!=hova) {
                if(se.getÁthaladóElem()!=null) return false;
            }
        }
        return true;
    }



    @Override
    public void rajzol(Graphics g) {

        //try {

        //final BufferedImage image = ImageIO.read(new File("csp.png"));
        //g.drawImage(image, x,y,null);
        g.setColor(Color.orange);
        int w = (int) (40 * Ikonok.getNagyításCsp());
        int h = (int) (40 * Ikonok.getNagyításCsp());
        g.fillOval(x-w/2,y-h/2,w,h);

		/*} catch (IOException e) {
			e.printStackTrace();
		}*/

    }
}
