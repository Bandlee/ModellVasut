package Class.ModellVasut.Cmd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rolac on 2017. 03. 25..
 */
public class CommandFactory {
    public Command create(String command, List<String> args) {

        Command cmd = null;
        switch(command.toLowerCase()) {
            case "test":
                cmd = new Test();
                cmd.setArguments(args);
                break;

            case "createvonatelement":
                cmd = new CreateVonatElem();
                cmd.setArguments(args);
                break;

            case "createcsomopont":
                cmd = new CreateCsomopont();
                cmd.setArguments(args);
                break;

            case "valtovaltas":
                cmd = new Valtas();
                cmd.setArguments(args);
                break;

            case "alagutszajtoggle":
                cmd = new AlagutSzajToggle();
                cmd.setArguments(args);
                break;

            case "vonatmozatas":
                cmd = new VonatMozgatas();
                cmd.setArguments(args);
                break;
        }

        return cmd;
    }
}
