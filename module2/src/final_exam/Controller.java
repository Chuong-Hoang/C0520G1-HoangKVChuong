package final_exam;

import java.util.Scanner;

public class Controller {

    //****************************create product manager object
    static ElementManager elementManager = new ElementManager();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //read file in the MAIN method
        elementManager.setElementList(FileUtility.readFile());
        //show main menu
        showMainMenu();
    }

    public static void showMainMenu() {
        System.out.println("-- CONTACT MANAGEMENT PROGRAM --");
        System.out.println("___Select a number to continue___");
        System.out.println("1.Display elements list");
        System.out.println("2.Add new element");
        System.out.println("3.Update an element");
        System.out.println("4.Delete an element");
        System.out.println("5.Find elements relatively by Number");
        System.out.println("6.Read from file");
        System.out.println("7.Write to file");
        System.out.println("8.Find elements relatively by Name");
        System.out.println("0.Exit");
        System.out.println("___________________________________");
        System.out.print("Select an option: ");
        int option = Integer.parseInt(sc.nextLine());

        //read file here
        //elementManager.setElementList(FileUtility.readFile());

        switch (option) {

            case 1:
                //display
                elementManager.displayAllList();
                break;
            case 2:
                //add new
                elementManager.addNewElement();
                break;
            case 3:
                //update
                elementManager.updateAnElement();
                break;
            case 4:
                //delete
                elementManager.deleteAnElement();
                break;

            case 5:
                //extra--find relatives
                elementManager.findRelativeElement();
                break;
            case 6:
                //read file
                System.out.print("Delete memory and update from file? Yes(y) or No(n)? ");
                if ("Y".toLowerCase().compareTo(sc.nextLine()) == 0) {
                    elementManager.setElementList(FileUtility.readFile());
                    System.out.println("Update successfully!");
                }
                break;
            case 7:
                //write file
                System.out.print("Save change? Yes(y) or No(n)? ");
                if ("Y".toLowerCase().compareTo(sc.nextLine()) == 0) {
                    FileUtility.writeFile(elementManager.getElementList());
                    System.out.println("File successfully saved!");
                }
                break;
            case 8:
                //find relatively name
                elementManager.findAnElementByName();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Program ends. No option selected...");
        }

        //write to file here
        //FileUtility.writeFile(elementManager.getElementList());

        System.out.println();
        showMainMenu();
    }
}
