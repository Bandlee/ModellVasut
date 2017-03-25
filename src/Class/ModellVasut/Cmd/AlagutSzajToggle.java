package Class.ModellVasut.Cmd;

import Class.ModellVasut.Alag�tSz�j;
import Class.ModellVasut.Prot;
import Class.ModellVasut.V�lt�;

import java.util.List;

/**
 * Created by rolac on 2017. 03. 25..
 */
public class AlagutSzajToggle implements Command {
    private int arg;

    @Override
    public Object run() {
        if(Prot.elements.get(arg) instanceof Alag�tSz�j) {
            Alag�tSz�j me = (Alag�tSz�j) Prot.elements.get(arg);
            me.felhaszn�l�Akci�();
        } else {
            System.out.println("#" + arg + " elem nem Alag�tSz�j");
        }

        return null;
    }

    @Override
    public void setArguments(List<String> args) {
        arg = Integer.parseInt(args.get(0));
    }
}
