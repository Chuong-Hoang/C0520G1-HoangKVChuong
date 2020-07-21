package session01_introduction_to_java.homeworks;
import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
        final int RATE_USD = 23000;
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Input quantity of dollars: ");
        int dollar = myScanner.nextInt();
        int vnd = dollar * RATE_USD;
        System.out.printf("Exchanged Result: %d vnđ.", vnd);
    }
}
