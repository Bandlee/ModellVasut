package Class.ModellVasut.Cmd;

import Class.ModellVasut.KeresztezőSín;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rolac on 2017. 04. 16..
 */
public class Ksn implements Command {
    int x, y;

    @Override
    public Object run() {
        return new KeresztezőSín(x, y, new ArrayList<>());
    }

    @Override
    public void setArguments(List<String> args) {
        x = Integer.parseInt(args.get(0));
        y = Integer.parseInt(args.get(1));
    }
}
