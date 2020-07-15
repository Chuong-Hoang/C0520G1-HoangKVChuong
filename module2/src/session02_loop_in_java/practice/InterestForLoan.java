package session2_loop_in_java.thuc_hanh;
import java.util.Scanner;

public class InterestForLoan {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        double loan;
        int month;
        double interestRate;
        System.out.print("Enter the loan: ");
        loan = myScanner.nextDouble();
        System.out.print("Enter the interest rate (%/year): ");
        interestRate = myScanner.nextDouble();
        System.out.print("Enter the quantity of month: ");
        month = myScanner.nextInt();
        double totalInterest = 0;
        for(int i = 0; i < month; i++){
            totalInterest += loan * (interestRate/100)/12;
        }
        System.out.println("The total of interest: " + totalInterest);
    }
}
