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
                cmd = new Asz();
                break;

            case "akt":
                cmd = new Akt();
                break;

            case "all":
                cmd = new All();
                break;

            case "vlt":
                cmd = new Vlt();
                break;

            case "swc":
                cmd = new Swc();
                break;

            case "ksn":
                cmd = new Ksn();
                break;

            case "sel":
                cmd = new Sel()
                break;

            case "alg":
                cmd = new Alg();
                break;

            case "snk":
                cmd = new Snk();
                break;

            case "smk":
                cmd = new Smk();
                break;

            case "mzd":
                cmd = new Mzd();
                break;

            case "uts":
                cmd = new Uts();
                break;

            case "nls":
                cmd = new Nls();
                break;

            case "start":
                cmd = new Start();
                break;

            case "stop":
                cmd = new Stop();
                break;

            case "tick":
                cmd = new Tick();
                break;
        }
        cmd.setArguments(args);

        return cmd;
    }
}
