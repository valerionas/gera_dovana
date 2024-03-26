package lt.valentinas.pom.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static Double parseNumberFromString(String input) {
        Pattern decimalNumPattern = Pattern.compile("\\d+.\\d+");
        Matcher matcher;
        String match = null;

        matcher = decimalNumPattern.matcher(input);
        while (matcher.find()) {
            match = matcher.group();
        }
        return Double.parseDouble(match.replaceAll(",", "."));
    }

    public static String deLithuaniseStringToLower(String input) {
        input = input.toLowerCase();
        input = input.replaceAll("ą", "a");
        input = input.replaceAll("č", "c");
        input = input.replaceAll("ę", "e");
        input = input.replaceAll("ė", "e");
        input = input.replaceAll("į", "i");
        input = input.replaceAll("š", "s");
        input = input.replaceAll("ų", "u");
        input = input.replaceAll("ū", "u");
        input = input.replaceAll("ž", "z");

        return input;
    }
}
