package case_study.controllers;

import case_study.models.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainController {
    static VillaManager villaManager = new VillaManager();
    static HouseManager houseManager = new HouseManager();
    static RoomManager roomManager = new RoomManager();
    static CustomerManager customerManager = new CustomerManager();
    static BookingManager bookingManager = new BookingManager();
    static Scanner sc = new Scanner(System.in);

    // MAIN METHOD()
    public static void main(String[] args) {
        villaManager.setVillaObjectList(VillaUtils.readVillaFile());
        houseManager.setHouseObjectList(HouseUtils.readHouseFile());
        roomManager.setRoomObjectList(RoomUtils.readRoomFile());
        customerManager.setCustomerObjectList(CustomerUtils.readCustomerFile());
        bookingManager.setBookingList(BookingUtils.readBookingFile());
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
        System.out.println("[8.Try 1] DELETE a Customer...");
        System.out.println("...............................");
        System.out.print("Enter your option: ");

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
            default:
                System.out.println("No choice at all...");
        }
        displayMainMenu();
    }

    // Option 1: ADD NEW SERVICES --> Task 2__OK
    private static void addNewServices() {
        System.out.println("OPTION 1 - ADD/DELETE NEW SERVICES:");
        System.out.println("<1>.Add New Villa");
        System.out.println("<2>.Add New House");
        System.out.println("<3>.Add New Room");
        System.out.println("<4>.Back to main menu");
        System.out.println("<5>.Exit");
        System.out.println("<6>.[Try 1] Delete VILLA Service.");
        System.out.println("<7.Try> Delete HOUSE Service.");
        System.out.println("<8.Try> Delete ROOM Service.");
        System.out.println("..............................");
        System.out.print("Choose an option: ");

        int option = Integer.parseInt(sc.nextLine());
        switch (option) {
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
                //6.Delete a Villa Service
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
        System.out.print("Enter an option: ");

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

    // Option 5: ADD NEW BOOKING --> Task 7
    private static void addNewBooking() {
        List<Customer> bookingList;
        Map<Integer, Villa> villasMapList;
        Map<Integer, House> housesMapList;
        Map<Integer, Room> roomsMapList;
        Map<Integer, Customer> customersMapList;

        System.out.println("OPTION 5 - ADD NEW BOOKING:");
        //show bookings-list BEFORE adding new booking
        BookingManager.showBookingList();

        customersMapList = BookingManager.getCustomersMapList();
        BookingManager.showCustomersMapList(customersMapList);
        System.out.print("Select customer No.: ");
        int customerNo = Integer.parseInt(sc.nextLine());
        if (customersMapList.containsKey(customerNo)) {
            Customer customer = customersMapList.get(customerNo);

            System.out.println("__BOOKING SERVICE__");
            System.out.println("1.Booking Villa");
            System.out.println("2.Booking House");
            System.out.println("3.Booking Room");
            System.out.println("..................");
            System.out.print("Select booking option: ");
            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    villasMapList = BookingManager.getVillasMapList();
                    BookingManager.showVillasMapList(villasMapList);
                    System.out.print("Select a villa: ");
                    int villaNo = Integer.parseInt(sc.nextLine());
                    if (villasMapList.containsKey(villaNo)) {
                        Villa villa = villasMapList.get(villaNo);
                        customer.setServices(new Villa(villa.getId(), villa.getServiceName()));
                    } else {
                        System.out.println("The villa No." + villaNo + " not found in the data.");
                    }
                    break;
                case 2:
                    housesMapList = BookingManager.getHousesMapList();
                    BookingManager.showHousesMapList(housesMapList);
                    System.out.print("Select a house: ");
                    int houseNo = Integer.parseInt(sc.nextLine());
                    if (housesMapList.containsKey(houseNo)) {
                        House house = housesMapList.get(houseNo);
                        customer.setServices(new House(house.getId(), house.getServiceName()));
                    } else {
                        System.out.println("The house No." + houseNo + " not found in the data.");
                    }
                    break;
                case 3:
                    roomsMapList = BookingManager.getRoomsMapList();
                    BookingManager.showRoomsMapList(roomsMapList);
                    System.out.print("Select a room: ");
                    int roomNo = Integer.parseInt(sc.nextLine());
                    if (roomsMapList.containsKey(roomNo)) {
                        Room room = roomsMapList.get(roomNo);
                        customer.setServices(new Room(room.getId(), room.getServiceName()));
                    } else {
                        System.out.println("The room No." + roomNo + " not found in the data.");
                    }
                    break;
                default:
                    System.exit(0);
            }

            BookingManager.addNewBooking(customer);
            BookingUtils.writeBookingFile(bookingManager.getBookingList());

            //show bookings-list again AFTER adding new booking
            BookingManager.showBookingList();
        } else {
            System.out.println("The customer No." + customerNo + " not found in the list.");
            addNewBooking();
        }
    }

    // Option 6: SHOW EMPLOYEE INFORMATION --> Task 9
    private static void showEmployeesInfo() {
        System.out.println("OPTION 6 - SHOW EMPLOYEE INFORMATION:");
    }
}
