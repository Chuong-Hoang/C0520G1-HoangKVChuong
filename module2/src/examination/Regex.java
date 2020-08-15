package examination;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    //Regex Strings
    static final String NAME_REGEX = "^[A-Z][\\w]+([\\s][A-Z][\\w]+)*$";
    static final String INTEGER_REGEX = "^[1-9][\\d]*$";
    static final String EMAIL_REGEX = "^([a-z]+[a-z0-9._]*@[\\w]{2,}.[\\w]{2,})$";
    static final String PHONE_NUMBER_REGEX = "^[\\d]{10,11}$";
    static final String DOUBLE_REGEX = "^[\\d][.]?[\\d]*$";
    static final String ID_REGEX = "^(([\\d]{3}\\s){2}[\\d]{3})$";
    static final String BIRTHDAY = "^((0[1-9]|[1-2][\\d]|(3[0-1]))/(0[1-9]|1[0-2])/((190[1-9]|19[1-9][\\d])|20[0-9]{2}))$";

    //Extra if need............................................
    static final String ABC = "^[A-Z][\\w]+([\\s][A-Z][\\w]+)*$";

    //Objects
    static Scanner sc = new Scanner(System.in);
    static Pattern pattern = null;
    static Matcher matcher = null;

    //Methods()....................
    public static String checkABC(String string) { // ---> recursive
        String input;
        System.out.print("Input a " + string + ": ");
        input = sc.nextLine();
        pattern = Pattern.compile(ABC);
        matcher = pattern.matcher(input);
        if(matcher.matches()) {
            return input;
        } else {
            System.out.println("_________ABC is not valid!");
            return checkABC(string); //recursive
        }
    }

    public static String checkName(String string) {
        String input;
        System.out.print("Input a " + string + ": ");
        input = sc.nextLine();
        pattern = Pattern.compile(NAME_REGEX);
        matcher = pattern.matcher(input);
        if(matcher.matches()) {
            return input;
        } else {
            System.out.println("Input not valid!");
            return checkName(string);
        }
    }

    public static String checkInteger(String string) {
        String input;
        System.out.print("Input a " + string + ": ");
        input = sc.nextLine();
        pattern = Pattern.compile(INTEGER_REGEX);
        matcher = pattern.matcher(input);
        if(matcher.matches()) {
            return input;
        } else {
            System.out.println("Integer number is not valid!");
            //..................
            return checkInteger(string);
        }
    }

    public static String checkDouble(String string) {
        String input;
        System.out.print("Input a " + string + ": ");
        input = sc.nextLine();
        pattern = Pattern.compile(DOUBLE_REGEX);
        matcher = pattern.matcher(input);
        if(matcher.matches()) {
            return input;
        } else {
            System.out.println("Double number is not valid!");
            //..................
            return checkDouble(string);
        }
    }

    public static String checkPhoneNumber() {
        String input;
        System.out.print("Input a phone number: ");
        input = sc.nextLine();
        pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        matcher = pattern.matcher(input);
        if(matcher.matches()) {
            return input;
        } else {
            System.out.println("Phone number is not valid!");
            //................
            return checkPhoneNumber();
        }
    }

    public static String checkEmail() {
        String input;
        System.out.print("Input Email: ");
        input = sc.nextLine();
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(input);
        if(matcher.matches()) {
            return input;
        } else {
            System.out.println("Email is not valid!");
            //................
            return checkEmail();
        }
    }

    public static String checkIdCard() {
        String input;
        System.out.print("Input Id number: ");
        input = sc.nextLine();
        pattern = Pattern.compile(ID_REGEX);
        matcher = pattern.matcher(input);
        if(matcher.matches()) {
            return input;
        } else {
            System.out.println("Id number is not valid!");
            //................
            return checkIdCard();
        }
    }

    public static String checkBirthday() {
        String birthday;
        System.out.print("Input Birthday (dd/mm/yyyy): ");
        birthday = sc.nextLine();
        pattern = Pattern.compile(BIRTHDAY);
        matcher = pattern.matcher(birthday);
        boolean isValid = matcher.matches();

        if (isValid) {
            Calendar c = Calendar.getInstance();
            int currentYear = c.get(Calendar.YEAR);

            //get 'year of birth' from birthday
            int birthYear = Integer.parseInt(birthday.substring(6));

            //check if 'year of birth' is satisfied
            isValid = birthYear <= currentYear - 18;

            if (isValid) {
                // if 'year of birth' is satisfied, check 'month of birth'
                if (birthYear == (currentYear - 18)) {
                    int birthMonth = Integer.parseInt(birthday.substring(3, 5));
                    int currentMonth = c.get(Calendar.MONTH) + 1;

                    //check 'month of birth'
                    isValid = birthMonth <= currentMonth;
                    if (isValid) {
                        // if 'month of birth' is satisfied, check 'day of birth'
                        if (birthMonth == currentMonth) {
                            int dayOfBirth = Integer.parseInt(birthday.substring(0, 2));
                            int currentDay = c.get(Calendar.DAY_OF_MONTH);

                            //check if 'day of birth' is satisfied
                            isValid = dayOfBirth <= currentDay;
                        }
                    }
                }
            }
        }

        if (isValid) {
            return birthday;
        } else {
            System.out.println("Birthday is not valid. " +
                    "Age must not be less than 18 and birth of year must be greater than 1900");
            return checkBirthday();
        }
    }

}
