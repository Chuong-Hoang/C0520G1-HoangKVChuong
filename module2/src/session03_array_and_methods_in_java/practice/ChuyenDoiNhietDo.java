package session03_array_and_methods_in_java.thuc_hanh;
import java.util.Scanner;

public class ChuyenDoiNhietDo {
    static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1.Fahrenheit to Celsius");
            System.out.println("2.Celsius to Fahrenheit");
            System.out.println("0.EXIT");
            System.out.print("Enter your choice: ");
            choice = myScanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter temperature in Fahrenheit scale: ");
                    double fahrenheit = myScanner.nextDouble();
                    System.out.println("Temperature in Celsius: " + fahrenheitToCelsius(fahrenheit));
                    break;
                case 2:
                    System.out.print("Enter temperature in Celsius scale: ");
                    double celsius = myScanner.nextDouble();
                    System.out.println("Temperature in Fahrenheit: " + celsiusToFahrenheit(celsius));
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        } while(choice != 0);
    }
    public static double fahrenheitToCelsius(double fahrenheit){
        double celsius = 1.8 * (fahrenheit - 32);
        return celsius;
    }
    public static double celsiusToFahrenheit(double celsius){
        double fahrenheit = (celsius/1.8) + 32;
        return fahrenheit;
    }
}
