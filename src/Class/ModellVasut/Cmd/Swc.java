package Class.ModellVasut.Cmd;

import Class.ModellVasut.Prot;
import Class.ModellVasut.V�lt�;

import java.util.List;

/**
 * Created by rolac on 2017. 03. 25..
 */
public class Swc implements Command {
    int valtoId;

    @Override
    public Object run() {

        if(Prot.elements.get(valtoId) instanceof V�lt�) {
            V�lt� me = (V�lt�)Prot.elements.get(valtoId);
            me.felhaszn�l�Akci�();
        } else {
            System.out.println("#" + valtoId + " elem nem V�lt�");
        }

        return null;
    }

    @Override
    public void setArguments(List<String> args) {
        valtoId = Integer.parseInt(args.get(0));
    }
}
