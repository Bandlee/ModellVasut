package Class.ModellVasut;

import Class.ModellVasut.Cmd.Command;
import Class.ModellVasut.Cmd.CommandFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rolac on 2017. 03. 25..
 */
public class Prot {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in;

        try {
            CommandFactory factory = new CommandFactory();
            while((in = br.readLine()) != null) {
                List<String> params = Arrays.asList(in.split(" "));
                Command cmd = factory.create(params.get(0), params.subList(1, params.size()));

                cmd.run();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
