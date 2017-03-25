package Class.ModellVasut.Cmd;

import Class.ModellVasut.*;

import java.util.List;

/**
 * Created by rolac on 2017. 03. 25..
 */
public class CreateCsomopont implements Command {
    String arg;

    @Override
    public Object run() {
        Csom�pont elem = null;

        switch(arg.toLowerCase()) {
            case "�llom�s":
                elem = new �llom�s();
                break;
            case "alag�tsz�j":
                elem = new Alag�tSz�j();
                break;
            case "v�lt�":
                elem = new V�lt�();
                break;
        }

        return elem;
    }

    @Override
    public void setArguments(List<String> args) {
        arg = args.get(0);
    }
}
