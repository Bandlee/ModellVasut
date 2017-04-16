package Class.ModellVasut.Cmd;

import Class.ModellVasut.Alagút;
import Class.ModellVasut.AlagútSzáj;
import Class.ModellVasut.Prot;

import java.util.List;

/**
 * Created by rolac on 2017. 04. 16..
 */
public class Alg implements Command {
    int v1, v2;

    @Override
    public Object run() {
        if(v1 != -1 && !(Prot.elements.get(v1) instanceof AlagútSzáj)) {
            System.out.println("#" + v1 + " nem Csomópont");
            return null;
        }
        if(v2 != -1 && !(Prot.elements.get(v2) instanceof AlagútSzáj)) {
            System.out.println("#" + v1 + " nem Csomópont");
            return null;
        }

        return new Alagút((AlagútSzáj)Prot.elements.get(v1), (AlagútSzáj)Prot.elements.get(v2));
    }

    @Override
    public void setArguments(List<String> args) {
        v1 = Integer.parseInt(args.get(0));
        v2 = Integer.parseInt(args.get(1));
    }
}
