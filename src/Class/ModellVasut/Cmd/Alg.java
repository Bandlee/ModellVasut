package Class.ModellVasut.Cmd;

import Class.ModellVasut.Alag�t;
import Class.ModellVasut.Alag�tSz�j;
import Class.ModellVasut.Prot;

import java.util.List;

/**
 * Created by rolac on 2017. 04. 16..
 */
public class Alg implements Command {
    int v1, v2;

    @Override
    public Object run() {
        if(v1 != -1 && !(Prot.elements.get(v1) instanceof Alag�tSz�j)) {
            System.out.println("#" + v1 + " nem Csom�pont");
            return null;
        }
        if(v2 != -1 && !(Prot.elements.get(v2) instanceof Alag�tSz�j)) {
            System.out.println("#" + v1 + " nem Csom�pont");
            return null;
        }

        return new Alag�t((Alag�tSz�j)Prot.elements.get(v1), (Alag�tSz�j)Prot.elements.get(v2));
    }

    @Override
    public void setArguments(List<String> args) {
        v1 = Integer.parseInt(args.get(0));
        v2 = Integer.parseInt(args.get(1));
    }
}
