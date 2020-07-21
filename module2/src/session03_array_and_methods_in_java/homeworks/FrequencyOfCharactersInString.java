package session03_array_and_methods_in_java.bai_tap;
import java.util.Scanner;


public class FrequencyOfCharactersInString {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Input a string: ");
        String inputString = myScanner.nextLine();
        System.out.print("Input the character to be found: ");
        String goal = myScanner.nextLine();

        int count = 0;
        for(int i = 0; i < inputString.length(); i++){
            char eachChar = inputString.charAt(i);
            String character = Character.toString(eachChar).toLowerCase();
            if(goal.equals(character)) count++;
        }
        if(count > 0) {
            System.out.println(goal + " appears " + count + " time(s) in the string");
        } else {
            System.out.println(goal + " is not in the string");
        }

    }
}
