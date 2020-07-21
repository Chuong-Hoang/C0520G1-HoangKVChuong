package session01_introduction_to_java.thuc_hanh;
import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Input your weight (kg): ");
        int weight = myScanner.nextInt();
        System.out.println("Input your height (cm): ");
        double height = myScanner.nextDouble()/100;
        System.out.println(height);
        double bmi = weight/(height*height);
        if(bmi >= 30) System.out.println("Obese");
        else if(bmi >= 25) System.out.println("Overweight");
        else if(bmi >= 18.5) System.out.println("Normal");
        else System.out.println("Underweight!");
    }
}
