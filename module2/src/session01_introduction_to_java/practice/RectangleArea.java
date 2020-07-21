package session01_introduction_to_java.thuc_hanh;
import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        float width;
        float height;

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter width: ");
        width = myScanner.nextFloat();
        System.out.println("Enter height:");
        height = myScanner.nextFloat();
        float area = width * height;
        System.out.println("Rectangle area: " + area);

    }
}
