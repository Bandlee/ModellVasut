package Class.ModellVasut.Cmd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rolac on 2017. 03. 25..
 */
public class Test implements Command {
    private List<String> args;

    public Test() {
        args = new ArrayList<>();
    }

    @Override
    public Object run() {
        for(String arg: args) {
            System.out.println(arg);
        }
        return null;
    }

    @Override
    public void setArguments(List<String> _args) {
        for(String arg: _args) {
            args.add(arg);
        }
    }
}
