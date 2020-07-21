package session04_class_and_object.practice;
import java.util.Scanner;

public class TestRectangle {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Input width: ");
        double width = myScanner.nextDouble();
        System.out.print("Input height: ");
        double height = myScanner.nextDouble();
        Rectangle rect = new Rectangle(width, height);

        System.out.println("My rectangle: " + rect.display());
        System.out.println("Perimeter of the rectangle: " + rect.getPerimeter());
        System.out.println("Area of the rectangle: " + rect.getArea());
    }
}
