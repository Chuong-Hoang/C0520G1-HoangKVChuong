package z_case_study.controllers;
import java.util.Scanner;

public class MainController {
    public MainController(){}
    Scanner myScanner = new Scanner(System.in);
    public void displayMainMenu(){
        System.out.println("MAIN MENU:");
        System.out.println("1. Add New Services");
        System.out.println("2. Show Services");
        System.out.println("3. Add New Customer");
        System.out.println("4. Show Information of Customer");
        System.out.println("5. Add New Booking");
        System.out.println("6. Show Information of Employee");
        System.out.println("7. Exit");

        System.out.print("Enter your choice: ");
        int choice = myScanner.nextInt();
        switch (choice){
            case 1: addNewServices(); break;
            case 2: showServices(); break;
            case 3: addNewCustomer(); break;
            case 4: showCustomerInfo(); break;
            case 5: addNewBooking(); break;
            case 6: showEmployeeInfo(); break;
            case 7: System.exit(0);
            default: System.out.println("No choice!");
        }
    }
    // choice 1
    public void addNewServices(){
        System.out.println("OPTION 1 - ADD NEW SERVICES:");
        System.out.println("1. Add New Villa");
        System.out.println("2. Add New House");
        System.out.println("3. Add New Room");
        System.out.println("4. Back to menu");
        System.out.println("5. Exit");

        System.out.print("Choose an option: ");
        int opt = myScanner.nextInt();
        switch (opt){
            case 1:
                System.out.println("Write attributes input by keyboard to data/Villa.csv");
                break;
            case 2:
                System.out.println("Write attributes input by keyboard to data/House.csv");
                break;
            case 3:
                System.out.println("Write attributes input by keyboard to data/Room.csv");
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                System.exit(0);
        }
    }

    // choice 2
    public void showServices(){
        System.out.println("OPTION 2 - SHOW SERVICES:");
        System.out.println("1. Show all Villa");
        System.out.println("2. Show all House");
        System.out.println("3. Show all Room");
        System.out.println("4. Show All Name Villa Not Duplicate");
        System.out.println("5. Show All Name House Not Duplicate");
        System.out.println("6. Show All Name Room Not Duplicate");
        System.out.println("7. Back to menu");
        System.out.println("8. Exit");

        System.out.print("Enter an option: ");
        int opt = myScanner.nextInt();
        switch (opt){
            case 1:
                System.out.println("Show all Villa here");
                break;
            case 2:
                System.out.println("Show all House here");
                break;
            case 3:
                System.out.println("Show all Room here");
                break;
            case 4:
                System.out.println("Show all name Villa not duplicate");
                break;
            case 5:
                System.out.println("Show all name House not duplicate");
                break;
            case 6:
                System.out.println("Show all name Room not duplicate");
                break;
            case 7:
                displayMainMenu();
                break;
            case 8: System.exit(0);
            default: System.out.println("No choice at all...");
        }

    }

    public void addNewCustomer(){
        System.out.println("OPTION 3 - ADD NEW CUSTOMER:");
    }

    public void showCustomerInfo(){
        System.out.println("OPTION 4 - SHOW CUSTOMER INFORMATION:");
    }

    public void addNewBooking(){
        System.out.println("OPTION 5 - ADD NEW BOOKING:");
    }

    public void showEmployeeInfo(){
        System.out.println("OPTION 6 - SHOW EMPLOYEE INFORMATION:");
    }

    // MAIN METHOD()
    public static void main(String[] args) {
        MainController mainControl = new MainController();
        mainControl.displayMainMenu();
    }
}
