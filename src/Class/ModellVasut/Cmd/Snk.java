package Class.ModellVasut.Cmd;

import Class.ModellVasut.Kocsi;
import Class.ModellVasut.Prot;
import Class.ModellVasut.SzenesKocsi;
import Class.ModellVasut.VonatElem;

import java.util.List;

/**
 * Created by rolac on 2017. 04. 16..
 */
public class Snk implements Command {
    int elozo;

    @Override
    public Object run() {
        if(!(Prot.elements.get(elozo) instanceof VonatElem)) {
            System.out.println("#" + elozo + " nem Vonat Elem");
            return null;
        }

        Kocsi res = new SzenesKocsi();
        ((VonatElem)Prot.elements.get(elozo)).setKövetkezõ(res);

        return res;
    }

    @Override
    public void setArguments(List<String> args) {
        elozo = Integer.parseInt(args.get(0));
    }
}
