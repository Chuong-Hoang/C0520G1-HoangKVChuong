package loop_in_java.bai_tap;
import java.util.Scanner;

public class CreateShapeMenu {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int choice = 5;
        System.out.println("MENU");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. EXIT");

        System.out.print("Enter your choice: ");
        choice = myScanner.nextInt();
        String str = "";
        switch(choice){
            case 1:
                System.out.println("Print the rectangle");
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 6; j++){
                        str += "* ";
                    }
                    str += "\n";
                }
                System.out.println(str);
                break;
            case 2:
                System.out.println("Print the square triangle");

                // Corner is at top-left
                for(int i = 6; i >= 1; i--){
                    for(int j = i; j >=1; j--){
                        str += "* ";
                    }
                    str += "\n";
                }
                System.out.print(str);
                str = "";

                // Corner is at top-right
                for(int i = 6; i >= 1; i--){
                    for(int j = 6; j >=1; j--){
                        if(j > i) str += "  ";
                        else  str += "* ";
                    }
                    str += "\n";
                }
                System.out.print(str);
                str = "";

                // Corner is at bottom-left
                for(int i = 1; i <=6; i++){
                    for(int j = 1; j <= 6; j++){
                        if(j > i) str += "  ";
                        else str += "* ";
                    }
                    str += "\n";
                }
                System.out.print(str);
                str = "";

                // Corner is at bottom-right
                for(int i = 1; i <= 6; i++){
                    for(int j = 6; j >=1; j--){
                        if(j > i) str += "  ";
                        else str += "* ";
                    }
                    str += "\n";
                }
                System.out.print(str);
                break;
            case 3:
                System.out.println("Print the isosceles triangle");

                // isosceles triangle with top-bottom
                for(int i = 6; i >= 1; i--){
                    for(int j = 6; j >= 1; j--){
                        if(j <= i) str += "* ";
                        else str += " ";
                    }
                    str += "\n";
                }
                System.out.println(str);
                str = "";

                // isosceles triangle with bottom-top
                for(int i = 1; i <= 6; i++){
                    for(int j = 6; j >= 1; j--){
                        if(j <= i) str += "* ";
                        else str += " ";
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
        System.out.println("------------------");
    }
}
