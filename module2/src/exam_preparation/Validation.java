package exam_preparation;

import case_study.models.House;
import case_study.models.Service;
import case_study.models.Villa;

import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    //Main Method() for testing
    public static void main(String[] args) {
        //Test
        String birthday = "20/04/1988";
        System.out.println("Birthday Test: " + validateBirthday(birthday));
    }

    //1.Validate Id number
    public static boolean validateIdCard(String idNumber){
        boolean isValid;
        Pattern pattern = Pattern.compile("^(([\\d]{3}\\s){2}[\\d]{3})$");
        Matcher matcher = pattern.matcher(idNumber);
        isValid = matcher.matches();
        return isValid;
    }

    //2.Validate Gender
    public static boolean validateGender(String gender) {
        boolean isValid;
        Pattern pattern = Pattern.compile("^(((m|M)(a|A)(l|L)(e|E))|((f|F)(e|E)(m|M)(a|A)(l|L)(e|E))|" +
                "((u|U)(n|N)(k|K)(n|N)(o|O)(w|W)(n|N)))$");
        Matcher matcher = pattern.matcher(gender);
        isValid = matcher.matches();
        return isValid;
    }

    //3.Validate Email
    public static boolean validateEmail(String email) {
        boolean isValid;
        Pattern pattern = Pattern.compile("^([a-z]+[a-z0-9._]*@[\\w]{2,}.[\\w]{2,})$");
        Matcher matcher = pattern.matcher(email);
        isValid = matcher.matches();
        return isValid;
    }

    //4.Validate Person Name
    public static boolean validatePersonName(String personName) {
        boolean isValid;
        Pattern pattern = Pattern.compile("^(([A-Z][a-z]+\\s)*[A-Z][a-z]+)$");
        Matcher matcher = pattern.matcher(personName);
        isValid = matcher.matches();
        return isValid;
    }

    //5.Check existing Service Id
    public static boolean existServiceId(String serviceId, List<? extends Service> list){
        boolean isAvailable = false;
        for (Service service : list) {
            if(serviceId.compareTo(service.getId()) == 0) {
                isAvailable = true;
                break;
            }
        }
        return  isAvailable;
    }


    //6.Validate Service Id
    public static boolean validateServiceId(Service serviceType, String serviceId) {
        boolean isValid = false;
        String serviceCode;
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


    //7.Validate Service Name
    public static boolean validateServiceName(String serviceName) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile("^([A-Z][a-z]+)$");
        Matcher matcher = pattern.matcher(serviceName);
        isValid = matcher.matches();
        return isValid;
    }

    //8.Validate Area ( double >30 m2)
    public static boolean validateArea(String area) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile("^(30.[\\d]*[1-9]|(3[1-9]|[4-9][\\d]|[1-9][\\d]{2,}).[\\d]+)$");
        Matcher matcher = pattern.matcher(area);
        isValid = matcher.matches();
        return isValid;
    }

    //9.Validate Rent Fee (double > 0)
    public static boolean validateRentFee(String rentFee) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile("^(0.[\\d]*[1-9]|[1-9][\\d]*(.[\\d]+)*)$");
        Matcher matcher = pattern.matcher(rentFee);
        isValid = matcher.matches();
        return isValid;
    }

    //10.Validate Max People Q'ty (< 20 people)
    public static boolean validateMaxPeopleQty(String maxPeopleQty) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile("^([0]?[1-9]|1[\\d])$");
        Matcher matcher = pattern.matcher(maxPeopleQty);
        isValid = matcher.matches();
        return isValid;
    }

    //11.Validate Extra-Service Name
    public static boolean validateExtraServiceName(String extraServiceName) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile("^(Massage|Karaoke|Food|Drink|Car)$");
        Matcher matcher = pattern.matcher(extraServiceName);
        isValid = matcher.matches();
        return isValid;
    }

    //12.Validate story number
    public static boolean validateStoryNumber(String storyNumber) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile("^([0]?[1-9]|[1-9][\\d]*)$");
        Matcher matcher = pattern.matcher(storyNumber);
        isValid = matcher.matches();
        return isValid;
    }

    //13.Validate Rent Type
    public static boolean validateRentType(String rentType) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile("^(Hourly|Daily|Monthly|Yearly)$");
        Matcher matcher = pattern.matcher(rentType);
        isValid = matcher.matches();
        return isValid;
    }

    //14.Validate Room Standard
    public static boolean validateRoomStandard(String roomStandard) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile("^(Vip|Business|Normal)$");
        Matcher matcher = pattern.matcher(roomStandard);
        isValid = matcher.matches();
        return isValid;
    }

    //15.Validate birthday (year > 1900 and > 18 year-old)
    public static boolean validateBirthday(String birthday) {
        boolean isValid = false;
        Pattern pattern = Pattern.compile("^((0[1-9]|[1-2][\\d]|(3[0-1]))/(0[1-9]|1[0-2])/((190[1-9]|19[1-9][\\d])|20[0-9]{2}))$");
        Matcher matcher = pattern.matcher(birthday);
        isValid = matcher.matches();
        if (isValid) {
            Calendar c = Calendar.getInstance();
            int currentYear = c.get(Calendar.YEAR);

            //get 'year of birth' from birthday
            int birthYear = Integer.parseInt(birthday.substring(6));

            //check if 'year of birth' is satisfied
            isValid = (currentYear - birthYear) >= 18;
//            System.out.println("BirthYear: " + birthYear);
//            System.out.println("Current Year: " + currentYear);
            if (isValid) {
                // if 'year of birth' is satisfied, check 'month of birth'
                if (currentYear - birthYear == 18) {
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
