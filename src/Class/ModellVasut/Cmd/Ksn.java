package Class.ModellVasut.Cmd;

import java.util.List;

/**
 * Created by rolac on 2017. 04. 16..
 */
public class Ksn implements Command {
    int x, y;

    @Override
    public Object run() {
        return new KeresztS�n();
    }

    @Override
    public void setArguments(List<String> args) {
        x = Integer.parseInt(args.get(0));
        y = Integer.parseInt(args.get(1));
    }
}
