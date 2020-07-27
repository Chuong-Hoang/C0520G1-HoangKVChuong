package case_study.controllers;
import case_study.models.Villa;
import java.util.Scanner;

public class MainController {
    static VillaManager villaManager = new VillaManager();
    static HouseManager houseManager = new HouseManager();
    static RoomManager roomManager = new RoomManager();

    // MAIN METHOD()
    public static void main(String[] args) {
        villaManager.setVillaObjectList(VillaUtils.readVillaFile());
        houseManager.setHouseObjectList(HouseUtils.readHouseFile());
        roomManager.setRoomObjectList(RoomUtils.readRoomFile());
        displayMainMenu();
    }

    // Set up method displayMainMenu()
    private static void displayMainMenu() {
        System.out.println("[......... MAIN MENU .........]");
        System.out.println("1.Add/Delete New Services");
        System.out.println("2.Show Services");
        System.out.println("3.Add New Customer");
        System.out.println("4.Show Information of Customer");
        System.out.println("5.Add New Booking");
        System.out.println("6.Show Information of Employee");
        System.out.println("7.Exit");
        System.out.println("...............................");
        System.out.print("Enter your option: ");
        Scanner myScanner = new Scanner(System.in);
        int option = myScanner.nextInt();
        switch (option) {
            case 1: addNewServices(); break;   // Task 2__OK
            case 2: showServices(); break;     // Task 3__OK
            case 3: addNewCustomer(); break;   // Task 5
            case 4: showCustomerInfo(); break; // Task 5
            case 5: addNewBooking(); break;    // Task 7
            case 6: showEmployeeInfo(); break; // Task 9
            case 7: System.exit(0);
            default: System.out.println("No choice at all...");
        }
        displayMainMenu();
    }

    // Option 1: ADD NEW SERVICES --> Task 2 item 2
    private static void addNewServices(){
        System.out.println("OPTION 1 - ADD/DELETE NEW SERVICES:");
        System.out.println("1.Add New Villa");
        System.out.println("2.Add New House");
        System.out.println("3.Add New Room");
        System.out.println("4.Back to main menu");
        System.out.println("5.Exit");
        System.out.println("6.[Try 1] Delete VILLA Service.");
        System.out.println("7.[Try 2] Delete HOUSE Service.");
        System.out.println("8.[Try 3] Delete ROOM Service.");
        System.out.println("..............................");
        System.out.print("Choose an option: ");
        Scanner sc = new Scanner(System.in);
        int opt = Integer.parseInt(sc.nextLine());
        switch (opt) {
            case 1:
                //1.Add New Villa
                villaManager.addNewVillaService();
                VillaUtils.writeVillaFile(villaManager.getVillaObjectList());
                System.out.println("*** New Villa was written to 'data/Villa.csv' ***");
                break;
            case 2:
                //2.Add New House
                houseManager.addNewHouseService();
                HouseUtils.writeHouseFile(houseManager.getHouseObjectList());
                System.out.println("*** New House was written to 'data/House.csv' ***");
                break;
            case 3:
                //3.Add New Room
                roomManager.addNewRoomService();
                RoomUtils.writeRoomFile(roomManager.getRoomObjectList());
                System.out.println("*** New Room was written to 'data/Room.csv' ***");
                break;
            case 4:
                //4.Back to main menu
                displayMainMenu();
                break;
            case 5:
                //5.Exit program
                System.exit(0);
            case 6:
                // 6.Delete a Villa Service
                System.out.print("Input Villa Service Id to be deleted: ");
                String idVilla = sc.nextLine();
                villaManager.deleteVillaService(idVilla);
                VillaUtils.writeVillaFile(villaManager.getVillaObjectList());
                break;
            case 7:
                //7.Delete a House Service
                System.out.print("Input House Service Id to be deleted: ");
                String idHouse = sc.nextLine();
                houseManager.deleteHouseService(idHouse);
                HouseUtils.writeHouseFile(houseManager.getHouseObjectList());
                break;
            case 8:
                //8.Delete a Room-Service
                System.out.print("Input Room Service Id to be deleted: ");
                String idRoom = sc.nextLine();
                roomManager.deleteRoomService(idRoom);
                RoomUtils.writeRoomFile(roomManager.getRoomObjectList());
                break;
            default:
                System.out.println("No choice at all...");
                break;
        }
    }

    // Option 2: SHOW SERVICES --> Task 3
    private static void showServices(){
        System.out.println("OPTION 2 - SHOW SERVICES:");
        System.out.println("1.Show all Villa");
        System.out.println("2.Show all House");
        System.out.println("3.Show all Room");
        System.out.println("4.Show All Name Villa Not Duplicate"); //Task 8
        System.out.println("5.Show All Name House Not Duplicate"); //Task 8
        System.out.println("6.Show All Name Room Not Duplicate");  //Task 8
        System.out.println("7.Back to main menu");
        System.out.println("8.Exit");
        System.out.println("...................................");
        System.out.print("Enter an option: ");
        Scanner myScanner = new Scanner(System.in);
        int opt = myScanner.nextInt();
        switch (opt) {
            case 1:
                //1.Show all Villa
                villaManager.displayVillaList();
                break;
            case 2:
                //2.Show all House
                houseManager.displayHouseList();
                break;
            case 3:
                //3.Show all Room
                roomManager.displayRoomList();
                break;
            case 4:
                //4.Show all Villa not duplicate -->Task 8
                System.out.println("Show all name Villa not duplicate");
                break;
            case 5:
                //5.Show all House not duplicate -->Task 8
                System.out.println("Show all name House not duplicate");
                break;
            case 6:
                //6.Show all Room not duplicate -->Task 8
                System.out.println("Show all name Room not duplicate");
                break;
            case 7:
                //7.Back to main menu
                displayMainMenu();
                break;
            case 8:
                //8.Exit the program
                System.exit(0);
            default:
                System.out.println("No choice at all...");
                break;
        }
    }

    // Option 3: ADD NEW CUSTOMERS --> Task 5
    private static void addNewCustomer() {
        System.out.println("OPTION 3 - ADD NEW CUSTOMER:");
    }

    // Option 4: SHOW CUSTOMER INFORMATION --> Task 5
    private static void showCustomerInfo() {
        System.out.println("OPTION 4 - SHOW CUSTOMER INFORMATION:");
    }

    // Option 5: ADD NEW BOOKING --> Task 7
    private static void addNewBooking() {
        System.out.println("OPTION 5 - ADD NEW BOOKING:");
    }

    // Option 6: SHOW EMPLOYEE INFORMATION --> Task 9
    private static void showEmployeeInfo() {
        System.out.println("OPTION 6 - SHOW EMPLOYEE INFORMATION:");
    }
}
