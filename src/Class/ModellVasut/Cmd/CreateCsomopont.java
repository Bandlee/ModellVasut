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
        Csomópont elem = null;

        switch(arg.toLowerCase()) {
            case "állomás":
                elem = new Állomás();
                break;
            case "alagútszáj":
                elem = new AlagútSzáj();
                break;
            case "váltó":
                elem = new Váltó();
                break;
        }

        return elem;
    }

    @Override
    public void setArguments(List<String> args) {
        arg = args.get(0);
    }
}
