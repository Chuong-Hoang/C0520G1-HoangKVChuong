package session04_class_and_object.practice;
import java.util.Scanner;

public class TestRectangle_2 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Input width: ");
        int width = myScanner.nextInt();
        System.out.print("Input height: ");
        int height = myScanner.nextInt();
        Rectangle_2 newRect = new Rectangle_2();
        newRect.setWidth(width);
        newRect.setHeight(height);
        System.out.println("This rectangle: " + newRect.display());
        System.out.println("Perimeter of this rectangle: " + newRect.getPerimeter());
        System.out.println("Area of this rectangle: " + newRect.getArea());
        System.out.println("------------------------");

        System.out.print("Input width 2: ");
        int w2 = myScanner.nextInt();
        System.out.print("Input height 2: ");
        int h2 = myScanner.nextInt();

        Rectangle_2 rect2 = new Rectangle_2(w2, h2);
        System.out.println("Rectangle: " + rect2.display());
        System.out.println("Perimeter: " + rect2.getPerimeter());
        System.out.println("Area: " + rect2.getArea());
    }
}
