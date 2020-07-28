package case_study.controllers;

import case_study.models.*;
import case_study.views.SortingCustomerNames;

import java.util.*;

public class BookingManager {
    private static List<Customer> bookingList;
    private static Map<Integer, Villa> villasMapList = new TreeMap<>();
    private static Map<Integer, House> housesMapList = new TreeMap<>();
    private static Map<Integer, Room> roomsMapList = new TreeMap<>();
    private static Map<Integer, Customer> customersMapList = new TreeMap<>();
    private static List<Customer> customersList;
    private static List<Villa> villasList;
    private static List<House> housesList;
    private static List<Room> roomsList;

    public BookingManager() {
        this.bookingList = new ArrayList<>();
    }

    public BookingManager(List<Customer> bookingList) {
        this.bookingList = bookingList;
    }

    public List<Customer> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Customer> bookingList) {
        this.bookingList = bookingList;
    }

    //Manipulation maps
    public static void addNewBooking(Customer customer) {
        bookingList.add(customer);
    }

    public static void showBookingList(){
        //Sorting booking-list by name and year of birth
        Collections.sort(bookingList, new SortingCustomerNames());
        System.out.println("___________BOOKINGS LIST_________");
        System.out.printf("%-8s%-25s%-16s%-12s%-14s%-18s%-20s%-18s%-20s%-15s%s\n",
                "No.", "Full_Name", "Birthday", "Gender", "Id_Number", "Phone_Number", "Email", "Customer_Type", "Address",
                "Service_Id", "Service_Name");
        int i = 1;
        for (Customer customer : bookingList) {
            System.out.printf("%-8s", i +".");
            customer.showInfo();
            i++;
        }
        System.out.println(". . . . . . . . . . . . . . . . End Bookings List . . . . . . . . . . . . . . . . . . . .");
    }

    public static Map<Integer, Room> getRoomsMapList() {
        //Clear map before add new services
        roomsMapList.clear();

        //get room objects list
        RoomManager roomManager = new RoomManager();
        roomManager.setRoomObjectList(RoomUtils.readRoomFile());
        roomsList = roomManager.getRoomObjectList();

        //add room objects into map
        int i = 1;
        for (Room room : roomsList) {
            roomsMapList.put(i, room);
            i++;
        }

        //Get map list
        return roomsMapList;
    }

    public static void showRoomsMapList(Map<Integer, Room> roomsMapList) {
        //show map list
        Set<Integer> roomKeys = roomsMapList.keySet();
        System.out.println("ROOM SERVICES LIST:");
        System.out.printf("%-5s%-12s%-15s%-12s%-14s%-14s%-12s%-15s%-21s%-11s%s\n","No.", "Service_Id",
                "Service_Name", "Used_Area", "Rent_Type", "Max_People", "Rent_Fee",
                "Free_Service", "Extra_Service_Name", "E.S_Unit", "E.S_Price");
        for (Integer key : roomKeys) {
            System.out.print(key + ".   ");
            roomsMapList.get(key).showInfo();
        }
        System.out.println("----------------------------------End Rooms List-----------------------------------");
    }

    public static Map<Integer, House> getHousesMapList() {
        //Clear map before add new services
        housesMapList.clear();

        //get house objects list
        HouseManager houseManager = new HouseManager();
        houseManager.setHouseObjectList(HouseUtils.readHouseFile());
        housesList = houseManager.getHouseObjectList();

        //add house objects into map
        int i = 1;
        for (House house : housesList) {
            housesMapList.put(i, house);
            i++;
        }

        //Get map list
        return housesMapList;
    }

    public static void showHousesMapList(Map<Integer, House> housesMapList){
        //show map list
        Set<Integer> houseKeys = housesMapList.keySet();
        System.out.println("HOUSE SERVICES LIST:");
        System.out.printf("%-5s%-12s%-15s%-12s%-14s%-14s%-12s%-12s%-15s%-15s%-21s%-11s%s\n", "No.", "Service_Id",
                "Service_Name", "Used_Area", "Rent_Type", "Max_People", "Rent_Fee", "Room_Std.",
                "Other_Utils", "Story_Number", "Extra_Service_Name", "E.S_Unit", "E.S_Price");
        for (Integer key : houseKeys) {
            System.out.print(key + ".   ");
            housesMapList.get(key).showInfo();
        }
        System.out.println("----------------------------------End Houses List-----------------------------------");
    }

    public static Map<Integer, Villa> getVillasMapList() {
        //Clear map before add new services
        villasMapList.clear();

        //get villa objects list
        VillaManager villaManager = new VillaManager();
        villaManager.setVillaObjectList(VillaUtils.readVillaFile());
        villasList = villaManager.getVillaObjectList();

        //add villa objects into map
        int i = 1;
        for (Villa villa : villasList) {
            villasMapList.put(i, villa);
            i++;
        }

        //Get map list
        return villasMapList;
    }

    public static void showVillasMapList(Map<Integer, Villa> villasMapList){
        //show map list
        Set<Integer> villaKeys = villasMapList.keySet();
        System.out.println("VILLA SERVICES LIST:");
        System.out.printf("%-5s%-12s%-15s%-12s%-14s%-14s%-12s%-12s%-15s%-15s%-15s%-21s%-11s%s\n","No.", "Service_Id",
                "Service_Name", "Used_Area", "Rent_Type", "Max_People", "Rent_Fee", "Room_Std.",
                "Other_Utils", "Sw.Pool_Area", "Story_Number", "Extra_Service_Name", "E.S_Unit", "E.S_Price");
        for (Integer key : villaKeys) {
            System.out.print(key + ".   ");
            villasMapList.get(key).showInfo();
        }
        System.out.println("----------------------------------End Villas List-----------------------------------");
    }

    public static Map<Integer, Customer> getCustomersMapList() {
        //get customer objects list
        CustomerManager customerManager = new CustomerManager();
        customerManager.setCustomerObjectList(CustomerUtils.readCustomerFile());

        //sorting customers by names and years of birth
        customersList = customerManager.getCustomerObjectList();
        Collections.sort(customersList, new SortingCustomerNames());

        //Add each key and value as customer object into map
        int i = 1;
        for (Customer customer : customersList) {
            customersMapList.put(i, customer);
            i++;
        }

        //Get customersMapList
        return customersMapList;
    }
    public static void showCustomersMapList(Map<Integer, Customer> customersMapList) {
        //Show the customersMapList
        Set<Integer> customerKeys = customersMapList.keySet();
        System.out.println("CUSTOMERS LIST:");
        System.out.printf("%-5s%-25s%-16s%-12s%-14s%-18s%-20s%-18s%-20s%-15s%s\n",
                "No.", "Full_Name", "Birthday", "Gender", "Id_Number", "Phone_Number", "Email", "Customer_Type", "Address",
                "Service_Id", "Service_Name");
        for (Integer key : customerKeys) {
            System.out.print(key + ".   ");
            customersMapList.get(key).showInfo();
        }
        System.out.println("----------------------------------End Customers List-----------------------------------");
    }

}
