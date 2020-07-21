package session01_introduction_to_java.bai_tap;
import java.util.Scanner;
public class HelloName {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = myScanner.nextLine();
        System.out.println("Hello " + name);

    }
}
