package Class.ModellVasut.Cmd;

import Class.ModellVasut.�llom�s;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rolac on 2017. 04. 14..
 */
public class All implements Command {
    String szin;
    int x, y;

    @Override
    public Object run() {
        return new �llom�s(x, y, new ArrayList<>(), szin, false);
    }

    @Override
    public void setArguments(List<String> args) {

    }
}
