package session2_loop_in_java.thuc_hanh;
import java.util.Scanner;

public class CreateMenuApplication {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int choice = 4;
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the square");
            System.out.println("3. Draw the rectangle");
            System.out.println("0. EXIT");
            System.out.print("Enter your choice: ");
            choice = myScanner.nextInt();

            String str = "";
            // Execute the choice
            switch (choice) {
                case 1:
                    System.out.println("Draw the triangle");
                    for (int i = 5; i >= 1; i--) {
                        for (int j = i; j >= 1; j--) {
                            str += "*";
                        }
                        str += "\n";
                    }
                    System.out.println(str);
                    break;
                case 2:
                    System.out.println("Draw the square");
                    for (int i = 1; i <= 4; i++) {
                        for (int j = 1; j <= 6; j++) {
                            str += "* ";
                        }
                        str += "\n";
                    }
                    System.out.println(str);
                    break;
                case 3:
                    System.out.println("Draw the triangle");
                    for (int i = 1; i <= 3; i++) {
                        for (int j = 1; j <= 8; j++) {
                            str += "* ";
                        }
                        str += "\n";
                    }
                    System.out.println(str);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }

            System.out.println("--------------");
        }
    }
}
