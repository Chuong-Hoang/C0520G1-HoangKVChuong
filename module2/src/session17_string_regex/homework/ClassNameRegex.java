package session17_string_regex.homework;
import java.util.regex.PatternSyntaxException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ClassNameRegex {
    public static final String VALID_CLASS_NAME = "^[CPA][\\d]{4}[G-M]$";
    public static void main(String[] args) {
       String[] classNames = new String[] {"C0318G", "M0318G", "P0323A"};
       for (String name : classNames) {
          boolean isValid = isValidClassName(name);
           System.out.println("Class name " + name + " is valid: " + isValid);
       }
    }

    public static boolean isValidClassName(String input) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile(VALID_CLASS_NAME);
        Matcher matcher = pattern.matcher(input);
        isValid = matcher.matches();
        return isValid;
    }
}
