package Class.ModellVasut.Cmd;

import Class.ModellVasut.Alag�tSz�j;
import Class.ModellVasut.�llom�s;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rolac on 2017. 04. 14..
 */
public class Asz implements Command {
    int x, y;

    @Override
    public Object run() {
        return new Alag�tSz�j(x, y, new ArrayList<>());
    }

    @Override
    public void setArguments(List<String> args) {
        x = Integer.parseInt(args.get(0));
        y = Integer.parseInt(args.get(1));
    }
}
