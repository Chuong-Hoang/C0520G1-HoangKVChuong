package introduction_to_java.thuc_hanh;
import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given an equation as 'a*x + b = 0', please enter constants:");

        double a, b, c, x;
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter a = ");
        a = myScanner.nextDouble();

        System.out.println("Enter b = ");
        b = myScanner.nextDouble();

        if(a == 0){
            if(b == 0) {
                System.out.println("Equation has uncountable solution");
            } else {
                System.out.println("Equation has no solution");
            }
        } else {
            System.out.println("Solution x = " + (-b/a));
        }
    }
}
