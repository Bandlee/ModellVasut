package Class.ModellVasut.Cmd;

import Class.ModellVasut.Kocsi;
import Class.ModellVasut.Mozdony;
import Class.ModellVasut.VonatElem;

import java.util.List;

/**
 * Created by rolac on 2017. 03. 25..
 */
public class CreateVonatElem implements Command {
    String arg;

    @Override
    public Object run() {
        VonatElem elem = null;

        switch(arg.toLowerCase()) {
            case "mozdony":
                elem = new Mozdony();
                break;
            case "kocsi":
                elem = new Kocsi();
        }

        return elem;
    }

    @Override
    public void setArguments(List<String> args) {
        arg = args.get(0);
    }
}
