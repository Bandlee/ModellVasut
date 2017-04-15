package Class.ModellVasut.Cmd;

import java.util.List;

/**
 * Created by rolac on 2017. 03. 25..
 */
public class CommandFactory {
    public Command create(String command, List<String> args) {

        Command cmd = null;
        switch(command.toLowerCase()) {
            case "csp":
                cmd = new Csp();
                break;

            case "asz":
                cmd = new CreateVonatElem();
                break;

            case "akt":
                cmd = new Akt();
                break;

            case "all":
                cmd = new Vlt();
                break;

            case "vlt":
                cmd = new Vlt();
                break;

            case "swc":
                cmd = new VonatMozgatas();
                break;

            case "ksn":
                break;

            case "sel":
                break;

            case "alg":
                break;

            case "snk":
                break;

            case "smk":
                break;

            case "mzd":
                break;

            case "uts":
                break;

            case "nls":
                break;

            case "start":
                break;

            case "stop":
                break;

            case "tick":
                break;
        }
        cmd.setArguments(args);

        return cmd;
    }
}
