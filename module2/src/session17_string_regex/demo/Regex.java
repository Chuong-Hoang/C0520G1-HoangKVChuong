package session17_string_regex.demo;
import java.util.regex.*;

public class Regex {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z]{25}$");
        Matcher matcher = pattern.matcher("Xavdfghjkloiuytrewqasdfghz");
        boolean isMatched = matcher.matches();
        System.out.println("Result: " + isMatched);
    }

}
