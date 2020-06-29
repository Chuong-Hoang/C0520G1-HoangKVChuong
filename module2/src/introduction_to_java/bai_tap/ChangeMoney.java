package introduction_to_java.bai_tap;
import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
        final int rateUSD = 23000;
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Input quantity of dollars: ");
        int dollar = myScanner.nextInt();
        int vnd = dollar * rateUSD;
        System.out.printf("Exchanged Result: %d vnđ.", vnd);
    }
}
