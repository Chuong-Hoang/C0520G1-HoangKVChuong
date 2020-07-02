package introduction_to_java.thuc_hanh;
import java.util.Scanner;

public class CheckLeapYear {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Input a year: ");
        int year = myScanner.nextInt();

        if(year%4 == 0) {
            if(year%100 != 0) {
                System.out.println("The year " + year + " is a leap year.");
            } else {
                if(year%400 != 0) {
                    System.out.println("The year " + year + " is NOT a leap year.");
                } else {
                    System.out.println("The year " + year + " is a leap year");
                }
            }
        } else {
            System.out.println("The year " + year + " is NOT a leap year.");
        }
        System.out.println("---- Programme ends here ----");
    }
}
