package Class.ModellVasut.Cmd;

import Class.ModellVasut.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rolac on 2017. 03. 25..
 */
public class Csp implements Command {
    int x, y;

    @Override
    public Object run() {
        return new Csomópont(x, y, new ArrayList<>());
    }

    @Override
    public void setArguments(List<String> args) {
        x = Integer.parseInt(args.get(0));
        y = Integer.parseInt(args.get(1));
    }
}
