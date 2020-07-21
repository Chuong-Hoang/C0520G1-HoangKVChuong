package session02_loop_in_java.thuc_hanh;
import java.util.Scanner;
public class TimUCLN {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int a, b;
        System.out.print("Input number a: ");
        a = myScanner.nextInt();
        System.out.print("Input number b: ");
        b = myScanner.nextInt();
        int ucln = 1;
        a = Math.abs(a);
        b = Math.abs(b);

        // Check if a and b have greatest common factor
        if(a == 0 && b == 0){
            System.out.println("No greatest common factor");
        } else {
            if ((a == 0 && b != 0) || (a != 0 && b == 0)){
                int max = a > b ? a : b;
                ucln = max;
            } else {
                if(a%b == 0) {
                    ucln = b;
                } else if(b%a == 0) {
                    ucln = a;
                } else {
                    int min = a < b ? a : b;
                    for(int i = 1; i <= min; i++){
                        if(a%i == 0 && b%i == 0)
                            ucln = i;
                    }
                }
            }
            System.out.println("The greatest common factor: " + ucln);
        }
    }
}
