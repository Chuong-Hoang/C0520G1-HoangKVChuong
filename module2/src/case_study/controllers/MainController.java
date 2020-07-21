package case_study.controllers;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;


public class MainController {
    public MainController(){}

    // MAIN METHOD()
    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        System.out.println("___ MAIN MENU ___");
        System.out.println("1. Add New Services");
        System.out.println("2. Show Services");
        System.out.println("3. Add New Customer");
        System.out.println("4. Show Information of Customer");
        System.out.println("5. Add New Booking");
        System.out.println("6. Show Information of Employee");
        System.out.println("7. Exit");

        System.out.print("Enter your option: ");
        Scanner myScanner = new Scanner(System.in);
        int option = myScanner.nextInt();
        switch (option) {
            case 1: addNewServices(); break;   // Task 2 - item 2
            case 2: showServices(); break;     // Task 3
            case 3: addNewCustomer(); break;   // Task 5
            case 4: showCustomerInfo(); break; // Task 5
            case 5: addNewBooking(); break;    // Task 7
            case 6: showEmployeeInfo(); break; // Task 9
            case 7: System.exit(0);
            default: System.out.println("No choice at all...");
        }
    }
    // Option 1 --> Task 2 item 2
    public static void addNewServices(){
        System.out.println("OPTION 1 - ADD NEW SERVICES:");
        System.out.println("1. Add New Villa");
        System.out.println("2. Add New House");
        System.out.println("3. Add New Room");
        System.out.println("4. Back to menu");
        System.out.println("5. Exit");

        System.out.print("Choose an option: ");
        Scanner myScanner = new Scanner(System.in);
        int opt = myScanner.nextInt();
        switch (opt) {
            case 1:
                // Villa service
                System.out.println("-- ADD VILLA SERVICE --");
                System.out.print("1. Input Id: ");
                String id = myScanner.nextLine();
                myScanner.nextLine();

                System.out.print("2. Input service name: ");
                String serviceName = myScanner.nextLine();

                System.out.print("3. Input used area: ");
                double usedArea = myScanner.nextDouble();
                myScanner.nextLine();

                System.out.print("4. Input rent type: ");
                String rentType = myScanner.nextLine();

                System.out.print("5. Input max people quantity: ");
                int maxPeopleQuantity = myScanner.nextInt();

                System.out.print("6. Input rent amount: ");
                //Add private information for villa only:
                System.out.print("7. Input room standard: ");
                System.out.print("8. Input other utility: ");
                System.out.print("9. Input swimming pool area: ");
                System.out.print("10. Input story number: ");

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

    // Option 2 --> Task 3
    public static void showServices(){
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
        Scanner myScanner = new Scanner(System.in);
        int opt = myScanner.nextInt();
        switch (opt) {
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
            default:
                System.out.println("No choice at all...");
                break;
        }
    }

    // Option 3 --> Task 5
    public static void addNewCustomer() {
        System.out.println("OPTION 3 - ADD NEW CUSTOMER:");
    }

    // Option 4 --> Task 5
    public static void showCustomerInfo() {
        System.out.println("OPTION 4 - SHOW CUSTOMER INFORMATION:");
    }

    // Option 5 --> Task 7
    public static void addNewBooking() {
        System.out.println("OPTION 5 - ADD NEW BOOKING:");
    }

    // Option 6 --> Task 9
    public static void showEmployeeInfo() {
        System.out.println("OPTION 6 - SHOW EMPLOYEE INFORMATION:");
    }
}
