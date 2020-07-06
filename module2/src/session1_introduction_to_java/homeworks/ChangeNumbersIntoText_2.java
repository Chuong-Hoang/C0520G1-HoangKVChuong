package session1_introduction_to_java.homeworks;
import java.util.Scanner;

public class ChangeNumbersIntoText_2 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = myScanner.nextInt();
        String output = "";
        if(number < 10){
            output += change1To9(number);
        } else if (number < 20){
            output += change10To19(number);
        } else if (number < 100){
            int factor = number/10;
            int modulo = number%10;
            output += change_To_Ty(factor) + " " + change1To9(modulo);
        } else if (number < 1000){
            int factor = number/100;
            output += change1To9(factor) + " hundred";
            int modulo = number%100;
            if(modulo == 0) {
                output += "";
            } else if(modulo > 0 && modulo < 10){
                output += " and " + change1To9(modulo);
            } else if (modulo < 20) {
                output += " and " + change10To19(modulo);
            } else { //modulo = number%100 --> modulo > 20
                int factor_2 = modulo/10;
                output += " and " + change_To_Ty(factor_2);
                int modulus = modulo%10;
                output += " " + change1To9(modulus);
            }
            int modulus = modulo/10;
        } // num >= 1000 ---ends here.

        System.out.println("Result: " + output.trim() + ".");
    }

    public static String change1To9(int number){
        String str = "";
        switch(number){
            case 1: str += "one"; break;
            case 2: str += "two"; break;
            case 3: str += "three"; break;
            case 4: str += "four"; break;
            case 5: str += "five"; break;
            case 6: str += "six"; break;
            case 7: str += "seven"; break;
            case 8: str += "eight"; break;
            case 9: str += "nine"; break;
            default: str += "";
        }
        return str;
    }

    public static String change10To19(int number){
        String str = "";
        switch(number){
            case 10: str += "ten"; break;
            case 11: str += "eleven"; break;
            case 12: str += "twelve"; break;
            case 13: str += "thirteen"; break;
            case 14: str += "fourteen"; break;
            case 15: str += "fifteen"; break;
            case 16: str += "sixteen"; break;
            case 17: str += "seventeen"; break;
            case 18: str += "eighteen"; break;
            case 19: str += "nineteen"; break;
            default: str += "";
        }
        return str;
    }

    public static String change_To_Ty(int number){
        String str = "";
        switch(number){
            case 2: str += "twenty"; break;
            case 3: str += "thirty"; break;
            case 4: str += "forty"; break;
            case 5: str += "fifty"; break;
            case 6: str += "sixty"; break;
            case 7: str += "seventy"; break;
            case 8: str += "eighty"; break;
            case 9: str += "ninety"; break;
        }
        return str;
    }
}
