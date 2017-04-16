package Class.ModellVasut.Cmd;

import Class.ModellVasut.Csom�pont;
import Class.ModellVasut.Mozdony;
import Class.ModellVasut.Prot;

import java.util.List;

/**
 * Created by rolac on 2017. 04. 16..
 */
public class Mzd implements Command {
    int dly, csp;

    @Override
    public Object run() {
        if(csp != -1 && !(Prot.elements.get(csp) instanceof Csom�pont)) {
            System.out.println("#" + csp + " nem Csom�pont");
            return null;
        }

        return new Mozdony(dly, (Csom�pont)Prot.elements.get(csp));
    }

    @Override
    public void setArguments(List<String> args) {
        dly = Integer.parseInt(args.get(0));
        csp = Integer.parseInt(args.get(1));
    }
}
