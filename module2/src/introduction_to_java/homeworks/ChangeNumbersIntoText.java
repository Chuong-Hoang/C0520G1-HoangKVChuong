package introduction_to_java.bai_tap;
import java.util.Scanner;

public class ChangeNumbersIntoText {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = myScanner.nextInt();
        String text = "";
        if(number < 0 || number > 999){
            System.out.println("Invalid number!");
        } else if(number <=10) {
            switch (number){
                case 1: text += "one"; break;
                case 2: text += "two"; break;
                case 3: text += "three"; break;
                case 4: text += "four"; break;
                case 5: text += "five"; break;
                case 6: text += "six"; break;
                case 7: text += "seven"; break;
                case 8: text += "eight"; break;
                case 9: text += "nine"; break;
                case 10: text += "ten"; break;
                default: text +=""; break;
            }
        } else if(number < 20){
            switch (number-10){
                case 1: text += "eleven"; break;
                case 2: text += "twelve"; break;
                case 3: text += "thirteen"; break;
                case 4: text += "fourteen"; break;
                case 5: text += "fifteen"; break;
                case 6: text += "sixteen"; break;
                case 7: text += "seventeen"; break;
                case 8: text += "eighteen"; break;
                case 9: text += "nineteen"; break;
                default: text += ""; break;
            }
        } else if(number < 100){
            switch (number/10) {
                case 2: text += "twenty"; break;
                case 3: text += "thirty"; break;
                case 4: text += "forty"; break;
                case 5: text += "fifty"; break;
                case 6: text += "sixty"; break;
                case 7: text += "seventy"; break;
                case 8: text += "eighty"; break;
                case 9: text += "ninety"; break;
                default: text += ""; break;
            }
            if(number%10 > 0) {
                text += " ";
                switch(number%10){
                    case 1: text += "one"; break;
                    case 2: text += "two"; break;
                    case 3: text += "three"; break;
                    case 4: text += "four"; break;
                    case 5: text += "five"; break;
                    case 6: text += "six"; break;
                    case 7: text += "seven"; break;
                    case 8: text += "eight"; break;
                    case 9: text += "nine"; break;
                    default: text +=""; break;
                }
            }
        } else { // number > 100
            switch(number/100){
                case 1: text += "one hundred"; break;
                case 2: text += "two hundred"; break;
                case 3: text += "three hundred"; break;
                case 4: text += "four hundred"; break;
                case 5: text += "five hundred"; break;
                case 6: text += "six hundred"; break;
                case 7: text += "seven hundred"; break;
                case 8: text += "eight hundred"; break;
                case 9: text += "nine hundred"; break;
            }
            int modulo = number%100;
            if(modulo > 0){
                text += " and";
                if(modulo/10 < 2){
                    switch(modulo){
                        case 1: text += " one"; break;
                        case 2: text += " two"; break;
                        case 3: text += " three"; break;
                        case 4: text += " four"; break;
                        case 5: text += " five"; break;
                        case 6: text += " six"; break;
                        case 7: text += " seven"; break;
                        case 8: text += " eight"; break;
                        case 9: text += " nine"; break;
                        case 10: text += " ten"; break;
                        case 11: text += " eleven"; break;
                        case 12: text += " twelve"; break;
                        case 13: text += " thirteen"; break;
                        case 14: text += " fourteen"; break;
                        case 15: text += " fifteen"; break;
                        case 16: text += " sixteen"; break;
                        case 17: text += " seventeen"; break;
                        case 18: text += " eighteen"; break;
                        case 19: text += " nineteen"; break;
                    }
                } else {
                    switch(modulo/10) {
                        case 2: text += " twenty"; break;
                        case 3: text += " thirty"; break;
                        case 4: text += " forty"; break;
                        case 5: text += " fifty"; break;
                        case 6: text += " sixty"; break;
                        case 7: text += " seventy"; break;
                        case 8: text += " eighty"; break;
                        case 9: text += " ninety"; break;
                        default: text += ""; break;
                    }
                    if(modulo%10 > 0) {
                        switch(modulo%10) {
                            case 1: text += " one"; break;
                            case 2: text += " two"; break;
                            case 3: text += " three"; break;
                            case 4: text += " four"; break;
                            case 5: text += " five"; break;
                            case 6: text += " six"; break;
                            case 7: text += " seven"; break;
                            case 8: text += " eight"; break;
                            case 9: text += " nine"; break;
                            default: text +=""; break;
                        }
                    }
                }
            }
        }

        System.out.println("Result: " + text + ".");
    }
}

