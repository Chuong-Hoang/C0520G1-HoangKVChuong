package session17_string_regex.homework;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PhoneNumberRegex {
    public static final String VALID_PHONE_NUMBER = "^\\([\\d]{2}\\)-\\([0][\\d]{9}\\)$";
    public static void main(String[] args) {
        String[] phoneNumbers = new String[] {"(84)-(0978489648)", "(b2)-(123456789)", "(04)-(0123489648)", "(a8)-(22222222)"};

        for (String phoneNumber : phoneNumbers) {
            boolean isValid = isValidPhoneNumber(phoneNumber);
            System.out.println("Phone number " + phoneNumber + " is valid: " + isValid);
        }

    }

    public static boolean isValidPhoneNumber(String input) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile(VALID_PHONE_NUMBER);
        Matcher matcher = pattern.matcher(input);
        isValid = matcher.matches();
        return isValid;
    }
}
