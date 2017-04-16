package Class.ModellVasut.Cmd;

import Class.ModellVasut.Kocsi;
import Class.ModellVasut.Prot;
import Class.ModellVasut.SzemelyKocsi;
import Class.ModellVasut.VonatElem;

import java.util.List;

/**
 * Created by rolac on 2017. 04. 16..
 */
public class Smk implements Command {
    int elozo;
    String szin;

    @Override
    public Object run() {
        if(!(Prot.elements.get(elozo) instanceof VonatElem)) {
            System.out.println("#" + elozo + " nem Vonat Elem");
            return null;
        }

        Kocsi res = new SzemelyKocsi(szin);
        ((VonatElem)Prot.elements.get(elozo)).setKövetkezõ(res);

        return res;
    }

    @Override
    public void setArguments(List<String> args) {
        elozo = Integer.parseInt(args.get(0));
        szin = args.get(1);
    }
}
