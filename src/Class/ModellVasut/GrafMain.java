package Class.ModellVasut;

import java.util.ArrayList;

/**
 * Created by Akos on 2017.05.05..
 */
public class GrafMain {
    public static void main(String args[]) {
        Ikonok.Init(0.7,0.6);

        Controller ctrl = new Controller();
        PályaGeneráló.setController(ctrl);
    }
}
