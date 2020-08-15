package case_study.controllers;
import case_study.commons.BookingUtils;
import case_study.commons.CustomerUtils;
import case_study.commons.EmployeeUtils;
import case_study.commons.ReaderAndWriter;
import case_study.models.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainController {

    //Service managers
    static VillaManager villaManager = new VillaManager();
    static HouseManager houseManager = new HouseManager();
    static RoomManager roomManager = new RoomManager();
    static CustomerManager customerManager = new CustomerManager();
    static BookingManager bookingManager = new BookingManager();
    static EmployeeManager employeeManager = new EmployeeManager();
    static CinemaCustomers cinemaCustomers = new CinemaCustomers();
    static DossierCabinet dossierCabinet = new DossierCabinet();
    static Scanner sc = new Scanner(System.in);

    // MAIN METHOD()
    public static void main(String[] args) {
        List<Service> villaList = ReaderAndWriter.readFile(Constant.VILLA_FILE_PATH);
        villaManager.setElementList(villaList);

        List<Service> houseList = ReaderAndWriter.readFile(Constant.HOUSE_FILE_PATH);
        houseManager.setElementList(houseList);

        List<Service> roomList = ReaderAndWriter.readFile(Constant.ROOM_FILE_PATH);
        roomManager.setElementList(roomList);

        List<Customer> customerObjectList = CustomerUtils.readCustomerFile();
        customerManager.setCustomerObjectList(customerObjectList);
        cinemaCustomers.setCustomerObjectList(customerObjectList);

        bookingManager.setBookingList(BookingUtils.readBookingFile());

        employeeManager.setEmployeeMapList(EmployeeUtils.readEmployeeFile());

        //show main menu
        displayMainMenu();
    }

    // Set up method displayMainMenu()
    private static void displayMainMenu() {
        System.out.println("[......... MAIN MENU .........]");
        System.out.println("[1] Add/Delete New Services");
        System.out.println("[2] Show Services");
        System.out.println("[3] Add New Customer");
        System.out.println("[4] Show Information of Customers");
        System.out.println("[5] Add New Booking");
        System.out.println("[6] Show Information of Employees");
        System.out.println("[7] Exit");
        System.out.println("[8._Try] DELETE a Customer...");
        System.out.println("[9] Cinema Manager");
        System.out.println("[10] Employee-Dossier Cabinet");
        System.out.println("...............................");
        System.out.print("Select an option: ");

        int option = Integer.parseInt(sc.nextLine());
        switch (option) {
            case 1:
                addNewServices();
                break;   // Task 2__OK
            case 2:
                showServices();
                break;     // Task 3__OK
            case 3:
                addNewCustomer();
                break;   // Task 5__OK
            case 4:
                showCustomersInfo();
                break; // Task 5__OK
            case 5:
                addNewBooking();
                break;    // Task 7
            case 6:
                showEmployeesInfo();
                break; // Task 9
            case 7:
                System.exit(0);
                break;
            case 8:
                deleteACustomer();
                break;   // Task 5__OK
            case 9:
                //Cinema Customer Manager__Task 10
                manageCinemaCustomers();
                break;
            case 10:
                //Employee Dossier Cabinet__Task 11
                manageDossierCabinet();
                break;
            default:
                System.out.println("No choice at all...");
        }
        System.out.println();

        //Show main menu again
        displayMainMenu();
    }

    /*............................................... OPTIONS .................................................*/

    // Option 1: ADD NEW SERVICES --> Task 2__OK
    private static void addNewServices() {
        System.out.println("OPTION 1 - ADD/DELETE NEW SERVICES:");
        System.out.println("<1>.Add New Villa");
        System.out.println("<2>.Add New House");
        System.out.println("<3>.Add New Room");
        System.out.println("<4>.Back to main menu");
        System.out.println("<5>.Exit");
        System.out.println("<6.Try> Delete VILLA Service.");
        System.out.println("<7.Try> Delete HOUSE Service.");
        System.out.println("<8.Try> Delete ROOM Service.");
        System.out.println("..............................");
        System.out.print("Choose an option: ");

        int option = Integer.parseInt(sc.nextLine());
        switch (option) {
            case 1:
                //1.Add New Villa
                villaManager.addNewVillaService();
                ReaderAndWriter.writeFile(villaManager.getElementList(), Constant.VILLA_FILE_PATH);
                System.out.println("*** New Villa was written to 'data/Villa.csv' ***");
                break;
            case 2:
                //2.Add New House
                houseManager.addNewHouseService();
                ReaderAndWriter.writeFile(houseManager.getElementList(), Constant.HOUSE_FILE_PATH);
                System.out.println("*** New House was written to 'data/House.csv' ***");
                break;
            case 3:
                //3.Add New Room
                roomManager.addNewRoomService();
                ReaderAndWriter.writeFile(roomManager.getElementList(), Constant.ROOM_FILE_PATH);
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
                //6.Delete a Villa Service
                System.out.print("Input Villa Service Id to be deleted: ");
                String idVilla = sc.nextLine();
                villaManager.deleteVillaService(idVilla);
                ReaderAndWriter.writeFile(villaManager.getElementList(), Constant.VILLA_FILE_PATH);
                break;
            case 7:
                //7.Delete a House Service
                System.out.print("Input House Service Id to be deleted: ");
                String idHouse = sc.nextLine();
                houseManager.deleteHouseService(idHouse);
                ReaderAndWriter.writeFile(houseManager.getElementList(), Constant.HOUSE_FILE_PATH);
                break;
            case 8:
                //8.Delete a Room-Service
                System.out.print("Input Room Service Id to be deleted: ");
                String idRoom = sc.nextLine();
                roomManager.deleteRoomService(idRoom);
                ReaderAndWriter.writeFile(roomManager.getElementList(), Constant.ROOM_FILE_PATH);
                break;
            default:
                System.out.println("No choice at all...");
                break;
        }
    }

    // Option 2: SHOW SERVICES --> Task 3__OK
    private static void showServices() {
        System.out.println("OPTION 2 - SHOW SERVICES:");
        System.out.println("<1>.Show all Villa");
        System.out.println("<2>.Show all House");
        System.out.println("<3>.Show all Room");
        System.out.println("<4>.Show All Name Villa Not Duplicate"); //Task 8
        System.out.println("<5>.Show All Name House Not Duplicate"); //Task 8
        System.out.println("<6>.Show All Name Room Not Duplicate");  //Task 8
        System.out.println("<7>.Back to main menu");
        System.out.println("<8>.Exit");
        System.out.println("...................................");
        System.out.print("Choose an option: ");

        int option = Integer.parseInt(sc.nextLine());
        switch (option) {
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
                //4.Show all Villa not duplicate -->Task 8__OK
                villaManager.displayNonDuplicateVillaNames();//
                break;
            case 5:
                //5.Show all House not duplicate -->Task 8__OK
                houseManager.displayNonDuplicateHouseNames();
                break;
            case 6:
                //6.Show all Room not duplicate -->Task 8__OK
                roomManager.displayNonDuplicateRoomNames();
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

    // Option 3: ADD NEW CUSTOMERS --> Task 5__OK
    private static void addNewCustomer() {
        System.out.println("OPTION 3 - ADD NEW CUSTOMER:");
        customerManager.addANewCustomer();
        CustomerUtils.writeCustomerFile(customerManager.getCustomerObjectList());
        System.out.println("*** New Customer was written to 'data/Customer.csv' ***");
    }

    // Option 4: SHOW CUSTOMER INFORMATION --> Task 5__OK
    private static void showCustomersInfo() {
        System.out.println("OPTION 4 - SHOW CUSTOMER INFORMATION:");
        customerManager.displayCustomerList();
    }

    // Option 8: [TRY] DELETE A CUSTOMER --> (Extra) Task 5__OK
    private static void deleteACustomer() {
        System.out.print("Input customer Id number to be deleted: ");
        String idNumber = sc.nextLine();
        customerManager.deleteCustomer(idNumber);
        CustomerUtils.writeCustomerFile(customerManager.getCustomerObjectList());
    }

    // Option 5: ADD NEW BOOKING --> Task 7_OK
    private static void addNewBooking() {
        Map<Integer, Customer> customersMapList;
        Map<Integer, Villa> villasMapList;
        Map<Integer, House> housesMapList;
        Map<Integer, Room> roomsMapList;

        System.out.println("OPTION 5 - ADD NEW BOOKING:");
        //show bookings-list BEFORE adding new booking
        System.out.println("__BEFORE adding new booking__");
        bookingManager.showBookingList();

        customersMapList = bookingManager.getCustomersMapList(customerManager.getCustomerObjectList());
        bookingManager.showCustomersMapList(customersMapList);
        System.out.print("Select customer No.: ");
        int customerNo = Integer.parseInt(sc.nextLine());
        if (customersMapList.containsKey(customerNo)) {
            Customer customer = customersMapList.get(customerNo);

            System.out.println("__BOOKING SERVICE FOR CUSTOMER NAME '" + customer.getName().toUpperCase() + "'__");
            System.out.println("1.Booking Villa");
            System.out.println("2.Booking House");
            System.out.println("3.Booking Room");
            System.out.println("..................");
            System.out.print("Select a booking option: ");
            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    //1.Booking Villa
                    villasMapList = bookingManager.getVillasMapList(villaManager.getElementList());
                    bookingManager.showVillasMapList(villasMapList);
                    System.out.print("Select a villa: ");
                    int villaNo = Integer.parseInt(sc.nextLine());
                    if (villasMapList.containsKey(villaNo)) {
                        Villa villa = villasMapList.get(villaNo);
                        customer.setService(new Villa(villa.getId(), villa.getServiceName()));
                    } else {
                        System.out.println("The villa No." + villaNo + " not found in the data.");
                    }
                    break;

                case 2:
                    //2.Booking House
                    housesMapList = bookingManager.getHousesMapList(houseManager.getElementList());
                    bookingManager.showHousesMapList(housesMapList);
                    System.out.print("Select a house: ");
                    int houseNo = Integer.parseInt(sc.nextLine());
                    if (housesMapList.containsKey(houseNo)) {
                        House house = housesMapList.get(houseNo);
                        customer.setService(new House(house.getId(), house.getServiceName()));
                    } else {
                        System.out.println("The house No." + houseNo + " not found in the data.");
                    }
                    break;

                case 3:
                    //3.Booking Room
                    roomsMapList = bookingManager.getRoomsMapList(roomManager.getElementList());
                    bookingManager.showRoomsMapList(roomsMapList);
                    System.out.print("Select a room: ");
                    int roomNo = Integer.parseInt(sc.nextLine());
                    if (roomsMapList.containsKey(roomNo)) {
                        Room room = roomsMapList.get(roomNo);
                        customer.setService(new Room(room.getId(), room.getServiceName()));
                    } else {
                        System.out.println("The room No." + roomNo + " not found in the data.");
                    }
                    break;

                default:
                    System.out.println("No booking service selected...");
                    System.exit(0);
            }

            bookingManager.addNewBooking(customer);
            BookingUtils.writeBookingFile(bookingManager.getBookingList());

            //show bookings-list again AFTER adding new booking
            System.out.println("__ AFTER adding new booking __");
            bookingManager.showBookingList();
        } else {
            System.out.println("The customer No." + customerNo + " not found in the list.");
            displayMainMenu();
        }
    }

    // Option 6: SHOW EMPLOYEE INFORMATION --> Task 9__OK
    private static void showEmployeesInfo() {
        System.out.println("OPTION 6 - SHOW EMPLOYEE INFORMATION:");
        employeeManager.displayEmployeeList();
    }

    // Option 9: CINEMA CUSTOMERS MANAGER
    private static void manageCinemaCustomers() {
        System.out.println("OPTION 9 - CINEMA CUSTOMERS MANAGER:");
        //Display customers list before for buying cinema-tickets
        customerManager.displayCustomerList();

        //Add new cinema customers
        cinemaCustomers.addCinemaCustomer();

        //Display buying-ticket-customers list
        cinemaCustomers.displayCinemaCustomerList();
    }

    // Option 10: EMPLOYEE DOSSIERS CABINET
    private static void manageDossierCabinet() {
        dossierCabinet.setEmployeeStackList(dossierCabinet.createDossierCabinet());
        dossierCabinet.findEmployeeDossier();
    }
}
