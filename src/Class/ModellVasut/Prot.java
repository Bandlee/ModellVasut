package Class.ModellVasut;

import Class.ModellVasut.Cmd.Command;
import Class.ModellVasut.Cmd.CommandFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rolac on 2017. 03. 25..
 */
public class Prot {
    public static List<Object> elements;

    public static void main(String[] args) {
        elements = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in;

        try {
            while((in = br.readLine()) != null) {
                eval(in);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eval(String in) {
        CommandFactory factory = new CommandFactory();

        Pattern bracket = Pattern.compile("\\(.*\\)");
        Matcher bracketMatch = bracket.matcher(in);
        String cmdStr = bracketMatch.replaceAll("");

        String argsStr = in.substring(bracketMatch.regionStart(), bracketMatch.regionEnd());

        List<String> params = new ArrayList<>();
        Pattern argsPattern = Pattern.compile("\\w+");
        Matcher argsMatch = argsPattern.matcher(argsStr);

        while(argsMatch.find()) {
            params.add(argsStr.substring(argsMatch.regionStart(), argsMatch.regionEnd()));
        }

        Command cmd = factory.create(cmdStr, params.subList(1, params.size()));

        Object res = cmd.run();
        if(res != null) {
            elements.add(res);
            System.out.println(res.getClass() + " created with ID #" + elements.indexOf(res));
        }
    }
}
