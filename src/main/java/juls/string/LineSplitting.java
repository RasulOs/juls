package juls.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineSplitting {

    public static void splitAndPrint(String line, int maxNumberOfCharacters) {

        String regex = ".{1," + maxNumberOfCharacters + "}(\\s|$)";

        Matcher m = Pattern.compile(regex).matcher(line);

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
