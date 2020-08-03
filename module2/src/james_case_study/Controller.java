package james_case_study;
import java.util.Scanner;

public class Controller {
    //This class is used for receive/read request
    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("_________ MAIN MENU _________");
        System.out.println("1.Lookup a word");
        System.out.println("2.Define new word");
        System.out.println("3.Drop a word");
        System.out.println("4.Export data");
        System.out.println("5.Exit program");
        System.out.println("______________________________");
        System.out.print("Select an option: ");
        int option = Integer.parseInt(sc.nextLine());

        switch(option) {
            case 1:
                //Lookup a word
                Service.lookup();
                break;
            case 2:
                //Define new word
                Service.define();
                break;
            case 3:
                //Drop a word
                Service.drop();
                break;
            case 4:
                //Export data
                Service.export();
                break;
            case 5:
                //Exit program
                System.out.println("*** Program ends ***");
                System.exit(0);
            default:
                //No option selected
                System.out.println("No option selected at all. Program ends here.");
        }
        System.out.println("..............................");
        showMainMenu();
    }
}
