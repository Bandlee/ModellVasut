package Class.ModellVasut.Cmd;

import Class.ModellVasut.AlagútSzáj;
import Class.ModellVasut.Prot;
import Class.ModellVasut.Váltó;

import java.util.List;

/**
 * Created by rolac on 2017. 03. 25..
 */
public class AlagutSzajToggle implements Command {
    private int arg;

    @Override
    public Object run() {
        if(Prot.elements.get(arg) instanceof AlagútSzáj) {
            AlagútSzáj me = (AlagútSzáj) Prot.elements.get(arg);
            me.felhasználóAkció();
        } else {
            System.out.println("#" + arg + " elem nem AlagútSzáj");
        }

        return null;
    }

    @Override
    public void setArguments(List<String> args) {
        arg = Integer.parseInt(args.get(0));
    }
}
