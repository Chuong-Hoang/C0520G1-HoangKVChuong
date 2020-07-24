package session17_string_regex.practice;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

public class ValidateAccount {
    public static final String VALID_ACCOUNT = "^([_a-z0-9]{6,})$";
    public static final String[] validAccount = new String[] { "123abc_", "_abc123", "______", "123456","abcdefgh" };
    public static final String[] invalidAccount = new String[] { ".@", "12345", "1234_", "abcde" };

    public static void main(String[] args) {
        for (String account : validAccount) {
            boolean isValid = checkAccount(account);
            System.out.println("Account " + account + " is valid: " + isValid);
        }

        for (String account : invalidAccount) {
            boolean isValid = checkAccount(account);
            System.out.println("Account " + account + " is valid: " + isValid);
        }
    }

    public static boolean checkAccount(String account) {
        boolean isMatched = false;
        Pattern pattern = Pattern.compile(VALID_ACCOUNT);
        Matcher matcher = pattern.matcher(account);
        isMatched = matcher.matches();
        return isMatched;
    }
}
