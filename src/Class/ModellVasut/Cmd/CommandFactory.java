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
        }

        return cmd;
    }
}
