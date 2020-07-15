package session6_inheritance.homeworks.triangle_shape;
import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Triangle t = new Triangle();
        System.out.println(t.toString());

        System.out.print("Input side 1: ");
        double s1 = myScanner.nextDouble();

        System.out.print("Input side 2: ");
        double s2 = myScanner.nextDouble();

        System.out.print("Input side 3: ");
        double s3 = myScanner.nextDouble();
        myScanner.nextLine();

        System.out.print("Input color: ");
        String color = myScanner.nextLine();
        System.out.println();
        if (s1 + s2 > s3 && s1 + s3 > s2 && s2 + s3 > s1) {
            t = new Triangle(color, s1, s2, s3);
            System.out.println(t);
        } else {
            System.out.println(s1 + ", " + s2 + " and " + s3 + " is not three sides of a triangle.");
        }
    }
}
