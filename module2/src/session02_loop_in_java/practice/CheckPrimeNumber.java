package session2_loop_in_java.thuc_hanh;
import java.util.Scanner;

public class CheckPrimeNumber {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = myScanner.nextInt();

        // Check if number is a prime number
        if(number < 2)
            System.out.println(number + " is not a prime.");
        else {
            int i = 2;
            boolean check = true;
            while(i <= Math.sqrt(number)){
                if(number%i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if(check)
                System.out.println(number + " is a prime.");
            else
                System.out.println(number + " is not a prime.");
        }
    }
}
