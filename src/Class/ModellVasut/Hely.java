package Class.ModellVasut;

/**
 * Koordinátákkal megadható helyet megvalósító osztály.
 * Created by Akos on 2017.05.02..
 */
public class Hely {
    /** hely x koordinátája*/
    protected int x;

    /** hely x koordinátája*/
    protected int y;

    /**
     * Hely konstruktora, beállítja a koordinátákat a kapott értékekre.
     * @param x hely x koordinátája
     * @param y hely y koordinátája
     */
    Hely(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Függvény az x koordináta lekérdezésére
     * @return hely x koordinátája
     */
    public int getX(){
        return x;
    }


    /**
     * Függvény az y koordináta lekérdezésére
     * @return hely y koordinátája
     */
    public int getY() {
        return y;
    }
}
