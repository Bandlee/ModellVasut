package Class.ModellVasut.Cmd;

import Class.ModellVasut.Csom�pont;
import Class.ModellVasut.Prot;
import Class.ModellVasut.S�nElem;

import java.util.List;

/**
 * Created by rolac on 2017. 04. 16..
 */
public class Sel implements Command {
    int v1, v2;
    int pre, post;

    @Override
    public Object run() {
        if(v1 != -1 && !(Prot.elements.get(v1) instanceof Csom�pont)) {
            System.out.println("#" + v1 + " nem Csom�pont");
            return null;
        }
        if(v2 != -1 && !(Prot.elements.get(v2) instanceof Csom�pont)) {
            System.out.println("#" + v1 + " nem Csom�pont");
            return null;
        }
        if(pre != -1 && !(Prot.elements.get(pre) instanceof S�nElem)) {
            System.out.println("#" + v1 + " nem S�nElem");
            return null;
        }
        if(post != -1 && !(Prot.elements.get(post) instanceof S�nElem)) {
            System.out.println("#" + v1 + " nem S�nElem");
            return null;
        }

        return new S�nElem(null, (S�nElem)Prot.elements.get(pre), (S�nElem)Prot.elements.get(post), true, (Csom�pont)Prot.elements.get(v1), (Csom�pont)Prot.elements.get(v2));
    }

    @Override
    public void setArguments(List<String> args) {
        v1 = Integer.parseInt(args.get(0));
        v2 = Integer.parseInt(args.get(1));
        pre = Integer.parseInt(args.get(2));
        post = Integer.parseInt(args.get(3));
    }
}
