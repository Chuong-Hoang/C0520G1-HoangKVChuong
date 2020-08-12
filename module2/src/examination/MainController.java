package examination;

import java.util.Scanner;

public class MainController {

    //****************************create product manager object
    static ElementManager elementManager = new ElementManager();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {

        System.out.println("--MANAGEMENT PROGRAM--");
        System.out.println("Select a number to continue:");
        System.out.println("1.Add new element");
        System.out.println("2.Delete an element");
        System.out.println("3.Display elements list");
        System.out.println("4.Find an element");
        System.out.println("5.Find relative elements");
        System.out.println("0.Exit");
        System.out.println("____________________________");
        System.out.print("Select an option: ");
        int option = Integer.parseInt(sc.nextLine());

        //read file here
        elementManager.setElementList(FileUtility.readFile());

        switch(option) {
            case 1:
                //add new
                elementManager.addNewElement();
                break;
            case 2:
                //delete
                elementManager.deleteAnElement();
                break;
            case 3:
                //display
                elementManager.displayAllList();
                break;
            case 4:
                //find
                elementManager.findAnElement();
                break;
            case 5:
                //extra--find relatives
                elementManager.findRelativeElement();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Program ends. No option selected...");
        }

        //write to file here
        FileUtility.writeFile(elementManager.getElementList());

        System.out.println();
        showMainMenu();
    }
}
