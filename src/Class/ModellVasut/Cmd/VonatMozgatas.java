package Class.ModellVasut.Cmd;

import Class.ModellVasut.Mozdony;
import Class.ModellVasut.Prot;

import java.util.List;

/**
 * Created by rolac on 2017. 03. 25..
 */
public class VonatMozgatas implements Command {
    private int arg;

    @Override
    public Object run() {
        if(Prot.elements.get(arg) instanceof Mozdony) {
            Mozdony me = (Mozdony) Prot.elements.get(arg);
            me.tickAkció();
        } else {
            System.out.println("#" + arg + " elem nem Mozdony");
        }

        return null;
    }

    @Override
    public void setArguments(List<String> args) {
        arg = Integer.parseInt(args.get(0));
    }
}
