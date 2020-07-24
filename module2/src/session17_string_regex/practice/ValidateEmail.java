package session17_string_regex.practice;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ValidateEmail {
    private static Pattern pattern = Pattern.compile("^[\\w]+[A-Za-z0-9]*@[A-Za-z]+[\\d]*(\\.[A-Za-z]+)$");
    public static void main(String[] args) {
        String input = "chuong@gmail.com";
        System.out.println("Result:" + checkEmail(pattern, input));

    }

    public static boolean checkEmail(Pattern pat, String input) {
        boolean isMatched;
        Matcher matcher = pat.matcher(input);
        isMatched = matcher.matches();
        return isMatched;
    }
}
