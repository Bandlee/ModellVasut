package Class.ModellVasut.Cmd;

import Class.ModellVasut.Prot;
import Class.ModellVasut.Váltó;

import java.util.List;

/**
 * Created by rolac on 2017. 03. 25..
 */
public class Swc implements Command {
    int valtoId;

    @Override
    public Object run() {

        if(Prot.elements.get(valtoId) instanceof Váltó) {
            Váltó me = (Váltó)Prot.elements.get(valtoId);
            me.felhasználóAkció();
        } else {
            System.out.println("#" + valtoId + " elem nem Váltó");
        }

        return null;
    }

    @Override
    public void setArguments(List<String> args) {
        valtoId = Integer.parseInt(args.get(0));
    }
}
