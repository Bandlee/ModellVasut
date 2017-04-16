package Class.ModellVasut.Cmd;

import Class.ModellVasut.Csomópont;
import Class.ModellVasut.Prot;
import Class.ModellVasut.SínElem;

import java.util.List;

/**
 * Created by rolac on 2017. 04. 16..
 */
public class Sel implements Command {
    int v1, v2;
    int pre, post;

    @Override
    public Object run() {
        if(v1 != -1 && !(Prot.elements.get(v1) instanceof Csomópont)) {
            System.out.println("#" + v1 + " nem Csomópont");
            return null;
        }
        if(v2 != -1 && !(Prot.elements.get(v2) instanceof Csomópont)) {
            System.out.println("#" + v1 + " nem Csomópont");
            return null;
        }
        if(pre != -1 && !(Prot.elements.get(pre) instanceof SínElem)) {
            System.out.println("#" + v1 + " nem SínElem");
            return null;
        }
        if(post != -1 && !(Prot.elements.get(post) instanceof SínElem)) {
            System.out.println("#" + v1 + " nem SínElem");
            return null;
        }

        return new SínElem(null, (SínElem)Prot.elements.get(pre), (SínElem)Prot.elements.get(post), true, (Csomópont)Prot.elements.get(v1), (Csomópont)Prot.elements.get(v2));
    }

    @Override
    public void setArguments(List<String> args) {
        v1 = Integer.parseInt(args.get(0));
        v2 = Integer.parseInt(args.get(1));
        pre = Integer.parseInt(args.get(2));
        post = Integer.parseInt(args.get(3));
    }
}
