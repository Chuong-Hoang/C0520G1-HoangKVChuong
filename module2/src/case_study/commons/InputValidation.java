package case_study.commons;
import case_study.models.House;
import case_study.models.Room;
import case_study.models.Services;
import case_study.models.Villa;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InputValidation {

    public static void main(String[] args) {
        String birthday = "27/07/2002";
        System.out.println("Birthday Test: " + validateBirthday(birthday));
    }

    public static boolean validateServiceId(Services serviceType, String serviceId) {
        boolean isValid = false;
        String serviceCode = "";
        if (serviceType instanceof Villa) {
            serviceCode = "VL";
        } else if (serviceType instanceof House) {
            serviceCode = "HO";
        } else {
            serviceCode = "RO";
        }
        String patString = "^(SV" + serviceCode + "-[\\d]{4})$";
        Pattern pattern = Pattern.compile(patString);
        Matcher matcher = pattern.matcher(serviceId);
        isValid = matcher.matches();
        return isValid;
    }

    public static boolean validateServiceName(String serviceName) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile("^([A-Z][a-z]+)$");
        Matcher matcher = pattern.matcher(serviceName);
        isValid = matcher.matches();
        return isValid;
    }

    public static boolean validateArea(String area) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile("^(30.[\\d]*[1-9]|(3[1-9]|[4-9][\\d]|[1-9][\\d]{2,}).[\\d]+)$");
        Matcher matcher = pattern.matcher(area);
        isValid = matcher.matches();
        return isValid;
    }

    public static boolean validateRentFee(String rentFee) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile("^(0.[\\d]*[1-9]|[1-9][\\d]*(.[\\d]+)*)$");
        Matcher matcher = pattern.matcher(rentFee);
        isValid = matcher.matches();
        return isValid;
    }

    public static boolean validateMaxPeopleQty(String maxPeopleQty) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile("^([0]?[1-9]|1[\\d])$");
        Matcher matcher = pattern.matcher(maxPeopleQty);
        isValid = matcher.matches();
        return isValid;
    }

    public static boolean validateExtraServiceName(String extraServiceName) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile("^(Massage|Karaoke|Food|Drink|Car)$");
        Matcher matcher = pattern.matcher(extraServiceName);
        isValid = matcher.matches();
        return isValid;
    }

    public static boolean validateStoryNumber(String storyNumber) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile("^([0]?[1-9]|[1-9][\\d]*)$");
        Matcher matcher = pattern.matcher(storyNumber);
        isValid = matcher.matches();
        return isValid;
    }

    public static boolean validateRentType(String rentType) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile("^(Hourly|Daily|Monthly|Yearly)$");
        Matcher matcher = pattern.matcher(rentType);
        isValid = matcher.matches();
        return isValid;
    }

    public static boolean validateRoomStandard(String roomStandard) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile("^(Vip|Business|Normal)$");
        Matcher matcher = pattern.matcher(roomStandard);
        isValid = matcher.matches();
        return isValid;
    }

    public static boolean validateBirthday(String birthday) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile("^((0[1-9]|[1-2][\\d]|(3[0-1]))/(0[1-9]|1[0-2])/[0-9]{4})$");
        Matcher matcher = pattern.matcher(birthday);
        isValid = matcher.matches();
        if (isValid) {
            Calendar c = Calendar.getInstance();
            int currentYear = c.get(Calendar.YEAR);

            //get 'year of birth' from birthday
            int birthYear = Integer.parseInt(birthday.substring(6));

            //check if 'year of birth' is satisfied
            isValid = birthYear <= currentYear - 18;
//            System.out.println("BirthYear: " + birthYear);
//            System.out.println("Current Year: " + currentYear);
            if (isValid) {
                // if 'year of birth' is satisfied, check 'month of birth'
                if (birthYear == (currentYear - 18)) {
                    int birthMonth = Integer.parseInt(birthday.substring(3,5));
                    int currentMonth = c.get(Calendar.MONTH) + 1;
//                    System.out.println("BirthMonth: " + birthMonth);
//                    System.out.println("Current Month: " + currentMonth);

                    //check 'month of birth'
                    isValid = birthMonth <= currentMonth;
                    if (isValid) {
                        // if 'month of birth' is satisfied, check 'day of birth'
                        if (birthMonth == currentMonth) {
                            int dayOfBirth = Integer.parseInt(birthday.substring(0,2));
                            int currentDay = c.get(Calendar.DAY_OF_MONTH);
//                            System.out.println("DOB: " + dayOfBirth);
//                            System.out.println("Current Day: " + currentDay);

                            //check if 'day of birth' is satisfied
                            isValid = dayOfBirth <= currentDay;
                        }
                    }
                }
            }
        }
        return isValid;
    }
}
