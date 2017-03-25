package Class.ModellVasut.Cmd;

import java.util.List;

/**
 * Created by rolac on 2017. 03. 25..
 */
public interface Command {
    Object run();
    void setArguments(List<String> args);
}
