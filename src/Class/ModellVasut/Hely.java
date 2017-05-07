package Class.ModellVasut;

/**
 * Koordin�t�kkal megadhat� helyet megval�s�t� oszt�ly.
 * Created by Akos on 2017.05.02..
 */
public class Hely {
    /** hely x koordin�t�ja*/
    protected int x;

    /** hely x koordin�t�ja*/
    protected int y;

    /**
     * Hely konstruktora, be�ll�tja a koordin�t�kat a kapott �rt�kekre.
     * @param x hely x koordin�t�ja
     * @param y hely y koordin�t�ja
     */
    Hely(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * F�ggv�ny az x koordin�ta lek�rdez�s�re
     * @return hely x koordin�t�ja
     */
    public int getX(){
        return x;
    }


    /**
     * F�ggv�ny az y koordin�ta lek�rdez�s�re
     * @return hely y koordin�t�ja
     */
    public int getY() {
        return y;
    }
}
