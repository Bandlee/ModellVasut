package Class.ModellVasut.Cmd;

import Class.ModellVasut.Prot;
import Class.ModellVasut.SzemelyKocsi;
import Class.ModellVasut.�llom�s;

import java.util.List;

/**
 * Created by rolac on 2017. 04. 16..
 */
public class Uts implements Command {
    int csp;

    @Override
    public Object run() {
        if(Prot.elements.get(csp) instanceof �llom�s) {
            ((�llom�s)Prot.elements.get(csp)).addUtas();
        }

        if(Prot.elements.get(csp) instanceof SzemelyKocsi) {
            ((SzemelyKocsi)Prot.elements.get(csp)).addUtas();
        }

        System.out.println("#" + csp + " nem �llom�s/Kocsi");

        return null;
    }

    @Override
    public void setArguments(List<String> args) {
        csp = Integer.parseInt(args.get(0));
    }
}
