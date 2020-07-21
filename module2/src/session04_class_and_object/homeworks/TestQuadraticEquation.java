package session04_class_and_object.homeworks;
import java.util.Scanner;

public class TestQuadraticEquation {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int a;
        do {
            System.out.print("Input a: ");
            a = myScanner.nextInt();
        } while (a == 0);
        System.out.print("Input b: ");
        int b = myScanner.nextInt();
        System.out.print("Input c: ");
        int c = myScanner.nextInt();
        QuadraticEquation eqt = new QuadraticEquation(a, b, c);
        if(eqt.getDiscriminant() < 0){
            System.out.println("The equation has no root!");
        } else if (eqt.getDiscriminant() > 0) {
            System.out.println("The equation has two roots:");
            System.out.println("The root 1 = " + eqt.getRoot1());
            System.out.println("The root 2 = " + eqt.getRoot2());
        } else {
            System.out.println("The equation has double root:");
            System.out.println("The double root: " + eqt.getRoot1());
        }
    }
}
