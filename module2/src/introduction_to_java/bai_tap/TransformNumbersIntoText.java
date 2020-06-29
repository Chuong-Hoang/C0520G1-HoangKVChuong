package introduction_to_java.bai_tap;
import java.util.Scanner;

public class TransformNumbersIntoText {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = myScanner.nextInt();
        String txt = "";
        if(number < 0 || number > 999){
            System.out.println("Invalid number!");
        } else if(number <=10) {
            switch (number){
                case 1: txt += "one"; break;
                case 2: txt += "two"; break;
                case 3: txt += "three"; break;
                case 4: txt += "four"; break;
                case 5: txt += "five"; break;
                case 6: txt += "six"; break;
                case 7: txt += "seven"; break;
                case 8: txt += "eight"; break;
                case 9: txt += "nine"; break;
                case 10: txt += "ten"; break;
                default: txt +=""; break;
            }
        } else if(number < 20){
            switch (number-10){
                case 1: txt += "eleven"; break;
                case 2: txt += "twelve"; break;
                case 3: txt += "thirteen"; break;
                case 4: txt += "fourteen"; break;
                case 5: txt += "fifteen"; break;
                case 6: txt += "sixteen"; break;
                case 7: txt += "seventeen"; break;
                case 8: txt += "eighteen"; break;
                case 9: txt += "nineteen"; break;
                default: txt += ""; break;
            }
        } else if(number < 100){
            switch (number/10) {
                case 2: txt += "twenty"; break;
                case 3: txt += "thirty"; break;
                case 4: txt += "forty"; break;
                case 5: txt += "fifty"; break;
                case 6: txt += "sixty"; break;
                case 7: txt += "seventy"; break;
                case 8: txt += "eighty"; break;
                case 9: txt += "ninety"; break;
                default: txt += ""; break;
            }
            if(number%10 > 0) {
                txt += " ";
                switch(number%10){
                    case 1: txt += "one"; break;
                    case 2: txt += "two"; break;
                    case 3: txt += "three"; break;
                    case 4: txt += "four"; break;
                    case 5: txt += "five"; break;
                    case 6: txt += "six"; break;
                    case 7: txt += "seven"; break;
                    case 8: txt += "eight"; break;
                    case 9: txt += "nine"; break;
                    default: txt +=""; break;
                }
            }
        } else {
            switch(number/100){
                case 1: txt += "one hundred"; break;
                case 2: txt += "two hundred"; break;
                case 3: txt += "three hundred"; break;
                case 4: txt += "four hundred"; break;
                case 5: txt += "five hundred"; break;
                case 6: txt += "six hundred"; break;
                case 7: txt += "seven hundred"; break;
                case 8: txt += "eight hundred"; break;
                case 9: txt += "nine hundred"; break;
            }
            int modulo = number%100;
            if(modulo > 0){
                txt += " and ";
                switch(modulo/10){
                    case 2: txt += "twenty"; break;
                    case 3: txt += "thirty"; break;
                    case 4: txt += "forty"; break;
                    case 5: txt += "fifty"; break;
                    case 6: txt += "sixty"; break;
                    case 7: txt += "seventy"; break;
                    case 8: txt += "eighty"; break;
                    case 9: txt += "ninety"; break;
                    default: txt +=""; break;
                }
                if(modulo%10 > 0){
                    txt += " ";
                    switch(modulo%10){
                        case 1: txt += "one"; break;
                        case 2: txt += "two"; break;
                        case 3: txt += "three"; break;
                        case 4: txt += "four"; break;
                        case 5: txt += "five"; break;
                        case 6: txt += "six"; break;
                        case 7: txt += "seven"; break;
                        case 8: txt += "eight"; break;
                        case 9: txt += "nine"; break;
                        default: txt +=""; break;
                    }
                }
            }
        }

        System.out.println("Result: " + txt + ".");
    }
}

