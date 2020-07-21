package session02_loop_in_java.bai_tap;
import java.util.Scanner;

public class ShowTheFirst20PrimeNumbers {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("How many prime numbers to be shown? ");
        int number = myScanner.nextInt();
        int count = 0;
        boolean check = true;
        String str = "Result: ";
            for(int i = 2; count < number; i++){
                for(int j = 2; j <= Math.sqrt(i); j++) {
                    if(i%j == 0){
                        check = false;
                        break;
                    }
                    check = true;
                }
                if(check){
                    count++;
                    str += i + " ";
                }
            }
        System.out.println(str);
    }
}
