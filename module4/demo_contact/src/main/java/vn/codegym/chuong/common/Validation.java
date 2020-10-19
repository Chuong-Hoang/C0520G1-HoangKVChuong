package vn.codegym.chuong.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    //Regex Strings
    static final String CODE_REGEX = "^(SV)-[\\d]{4}$";
    static final String NAME_REGEX = "^[A-Z][\\w]+([\\s][A-Z][\\w]+)*$";
    static final String GENDER_REGEX = "^(male|female|other|unknown)$";
    static final String INTEGER_REGEX = "^[1-9][\\d]*$";
    static final String EMAIL_REGEX = "^([a-z]+[a-z0-9._]*@[\\w]{2,}.[\\w]{2,})$";
    static final String PHONE_NUMBER_REGEX = "^(\\(84\\)\\+|0)[9][0|1][\\d]{7}$";
    static final String DOUBLE_REGEX = "^[\\d]+[.]?[\\d]*$";
    static final String ID_REGEX = "^[\\d]{9}([\\d]{3})?$";
    static final String DATE_REGEX = "^((0[1-9]|[1-2][\\d]|(3[0-1]))/(0[1-9]|1[0-2])/((190[1-9]|19[1-9][\\d])|20[0-9]{2}))$";

    //Extra if need............................................
    static final String ABC = "^[A-Z][\\w]+([\\s][A-Z][\\w]+)*$";

    //Objects
    static Scanner sc = new Scanner(System.in);
    static Pattern pattern = null;
    static Matcher matcher = null;

    public static void main(String[] args) {
        System.err.println(checkTimeDuration("2020-10-10", "2020-12-10", 2));
//        System.err.println(checkDurationFromNow("2019-12-19", 2, -1));
    }

    // Method() templates for other methods
    public static boolean checkPattern(String input, String patternString) {
        if(input == null) return false;
        pattern = Pattern.compile(patternString);
        matcher = pattern.matcher(input);
        if (matcher.matches()) {
            System.err.println("Check pattern - " + patternString + " with string " + input + " ________ is: TRUE");
            return true;
        } else {
            System.err.println("Check pattern - " + patternString + " with string " + input + " ________ is: FALSE");
            return false;
        }
    }

    // Check duration from NOW and other date satisfied (>= duration) --> MONTH
    public static boolean checkDurationFromNow(String otherDateStr, int duration, int mode){
        // creating Calendar objects (yyyy-mm-dd)
        Calendar current = Calendar.getInstance(); // now
        Calendar other = Calendar.getInstance(); // other date

        // set MONTH starts with 0 i.e. ( 0 - Jan)
        other.set(Calendar.MONTH, Integer.parseInt(otherDateStr.substring(5,7))-1);
        // set Date
        other.set(Calendar.DATE, Integer.parseInt(otherDateStr.substring(8)));
        // set Year
        other.set(Calendar.YEAR, Integer.parseInt(otherDateStr.substring(0,4)));

        // creating date objects with specified time.
        Date currentDate = current.getTime(); // now
        Date otherDate = other.getTime();   // other date
        Long timeSpan = (otherDate.getTime() - currentDate.getTime())/(1000*60*60*24);
        if(mode < 0) {timeSpan = -timeSpan;}
        System.err.println("Other Date: " + otherDate);
        System.err.println("Current Date: " + currentDate);
        System.err.println("Time span: " + timeSpan + " days");
        if (timeSpan < duration*30) {
            return false;
        }
        return true;
    }

    // Check duration between 2 dates satisfied quantity (>=duration) --> MONTH
    public static boolean checkTimeDuration(String startDateStr, String endDateStr, Integer duration){
        // creating Calendar objects (yyyy-mm-dd)
        Calendar start = Calendar.getInstance(); // now
        Calendar end = Calendar.getInstance(); // other date

        // set MONTH starts with 0 i.e. ( 0 - Jan)
        start.set(Calendar.MONTH, Integer.parseInt(startDateStr.substring(5,7))-1);
        end.set(Calendar.MONTH, Integer.parseInt(endDateStr.substring(5,7))-1);
        // set Date
        start.set(Calendar.DATE, Integer.parseInt(startDateStr.substring(8)));
        end.set(Calendar.DATE, Integer.parseInt(endDateStr.substring(8)));
        // set Year
        start.set(Calendar.YEAR, Integer.parseInt(startDateStr.substring(0,4)));
        end.set(Calendar.YEAR, Integer.parseInt(endDateStr.substring(0,4)));

        // creating date objects with specified time.
        Date startDate = start.getTime(); // now
        Date endDate = end.getTime();   // other date
        Long timeSpan = (endDate.getTime() - startDate.getTime())/(1000*60*60*24);

        System.err.println("Start Date: " + startDate);
        System.err.println("End Date: " + endDate);
        System.err.println("Time span: " + timeSpan + " days");
        if(timeSpan < duration*30) {
            return false;
        }
        return true;
    }

    public static boolean checkCode(String input) {
        return checkPattern(input, CODE_REGEX);
    }

    public static boolean checkName(String input) {
        return checkPattern(input, NAME_REGEX);
    }

    public static boolean checkGender(String input) {
        return checkPattern(input, GENDER_REGEX);
    }

    public static boolean checkInteger(String input) {
        return checkPattern(input, INTEGER_REGEX);
    }

    public static boolean checkDouble(String input) {
        return checkPattern(input, DOUBLE_REGEX);
    }

    public static boolean checkPhoneNumber(String input) {
        return checkPattern(input, PHONE_NUMBER_REGEX);
    }

    public static boolean checkEmail(String input) {
        return checkPattern(input, EMAIL_REGEX);
    }

    public static boolean checkIdCard(String input) {
        return checkPattern(input, ID_REGEX);
    }

    public static boolean checkRealDate(String input) {
        return checkPattern(input, DATE_REGEX);
    }

    public static boolean checkBirthday(String inputDate) {
        boolean isValid = false;
        System.err.println("birthday is: ____" + inputDate.toString());

        if (inputDate.length() != 10) {
            return false;
        } else {
            Calendar c = Calendar.getInstance();
            int currentYear = c.get(Calendar.YEAR);

            //get 'year of birth' from birthday
            int birthYear = Integer.parseInt(inputDate.substring(0, 4));

            //check if 'year of birth' is satisfied
            isValid = (birthYear <= currentYear - 18) && (currentYear - birthYear < 100);

            if (isValid) {
                // if 'year of birth' is satisfied, check 'month of birth'
                if (birthYear == (currentYear - 18)) {
                    int birthMonth = Integer.parseInt(inputDate.substring(5, 7));
                    int currentMonth = c.get(Calendar.MONTH) + 1;

                    //check 'month of birth'
                    isValid = birthMonth <= currentMonth;
                    if (isValid) {
                        // if 'month of birth' is satisfied, check 'day of birth'
                        if (birthMonth == currentMonth) {
                            int dayOfBirth = Integer.parseInt(inputDate.substring(8));
                            int currentDay = c.get(Calendar.DAY_OF_MONTH);

                            //check if 'day of birth' is satisfied
                            isValid = dayOfBirth <= currentDay;
                        }
                    }
                }
            }
        }
        System.err.println("result Birthday check:____________" + isValid);
        return isValid;
    }

}
