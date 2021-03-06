package case_study.controllers;
import case_study.models.*;
import case_study.views.SortingCustomerNames;
import java.util.*;

public class BookingManager {
    private static List<Customer> bookingList;
    private Map<Integer, Villa> villasMapList = new TreeMap<>();
    private Map<Integer, House> housesMapList = new TreeMap<>();
    private Map<Integer, Room> roomsMapList = new TreeMap<>();
    private Map<Integer, Customer> customersMapList = new TreeMap<>();

    public BookingManager() {
        bookingList = new ArrayList<>();
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

    //........................................... Manipulation Maps ...............................................//

    //Add new customer into bookingList
    public void addNewBooking(Customer customer) {
        bookingList.add(customer);
    }

    //Show bookingList
    public void showBookingList(){
        //Sorting booking-list by name and year of birth
        Collections.sort(bookingList, new SortingCustomerNames());

        //Display booking List
        System.out.println("___________ THE BOOKINGS LIST ___________");
        System.out.printf("%-8s%-25s%-16s%-12s%-14s%-18s%-20s%-18s%-20s%-15s%s\n",
                "No.", "Full_Name", "Birthday", "Gender", "Id_Number", "Phone_Number", "Email",
                "Customer_Type", "Address", "Service_Id", "Service_Name");
        int i = 1;
        for (Customer customer : bookingList) {
            System.out.printf("%-8s", i +".");
            customer.showInfo();
            i++;
        }
        System.out.println(". . . . . . . . . . . . . . . . End Bookings List . . . . . . . . . . . . . . . . . . .");
    }

    public Map<Integer, Room> getRoomsMapList(List<Service> roomsList) {

        //Clear Map before add new services
        roomsMapList.clear();

        //Add room objects into Map
        int i = 1;
        for (Service room : roomsList) {
            roomsMapList.put(i, (Room) room);
            i++;
        }

        //Get Map List
        return roomsMapList;
    }

    public void showRoomsMapList(Map<Integer, Room> roomsMapList) {
        //Show Map list
        Set<Integer> roomKeys = roomsMapList.keySet();
        System.out.println("ROOM SERVICES LIST:");
        System.out.printf("%-5s%-12s%-15s%-12s%-14s%-14s%-12s%-15s%-21s%-11s%s\n","No.", "Service_Id",
                "Service_Name", "Used_Area", "Rent_Type", "Max_People", "Rent_Fee",
                "Free_Service", "Extra_Service_Name", "E.S_Unit", "E.S_Price");
        for (Integer key : roomKeys) {
            System.out.printf("%-5s", key + ".");
            roomsMapList.get(key).showInfo();
        }
        System.out.println("----------------------------------End Rooms List-----------------------------------");
    }

    public Map<Integer, House> getHousesMapList(List<Service> housesList) {
        //Clear Map before add new services
        housesMapList.clear();

        //Add house objects into Map
        int i = 1;
        for (Service house : housesList) {
            housesMapList.put(i, (House) house);
            i++;
        }

        //Get Map List
        return housesMapList;
    }

    public void showHousesMapList(Map<Integer, House> housesMapList){
        //Show Map List
        Set<Integer> houseKeys = housesMapList.keySet();
        System.out.println("HOUSE SERVICES LIST:");
        System.out.printf("%-5s%-12s%-15s%-12s%-14s%-14s%-12s%-12s%-15s%-15s%-21s%-11s%s\n", "No.", "Service_Id",
                "Service_Name", "Used_Area", "Rent_Type", "Max_People", "Rent_Fee", "Room_Std.",
                "Other_Utils", "Story_Number", "Extra_Service_Name", "E.S_Unit", "E.S_Price");
        for (Integer key : houseKeys) {
            System.out.printf("%-5s", key + ".");
            housesMapList.get(key).showInfo();
        }
        System.out.println("----------------------------------End Houses List-----------------------------------");
    }

    public Map<Integer, Villa> getVillasMapList(List<Service> villasList) {
        //Clear Map before add new services
        villasMapList.clear();

        //Add villa objects into Map
        int i = 1;
        for (Service villa : villasList) {
            villasMapList.put(i, (Villa) villa);
            i++;
        }

        //Get Map List
        return villasMapList;
    }

    public void showVillasMapList(Map<Integer, Villa> villasMapList){
        //Show Map list
        Set<Integer> villaKeys = villasMapList.keySet();
        System.out.println("___________________________________VILLA SERVICES LIST___________________________________");
        System.out.printf("%-5s%-12s%-15s%-12s%-14s%-14s%-12s%-12s%-15s%-15s%-15s%-21s%-11s%s\n","No.", "Service_Id",
                "Service_Name", "Used_Area", "Rent_Type", "Max_People", "Rent_Fee", "Room_Std.",
                "Other_Utils", "Sw.Pool_Area", "Story_Number", "Extra_Service_Name", "E.S_Unit", "E.S_Price");
        for (Integer key : villaKeys) {
            System.out.printf("%-5s", key + ".");
            villasMapList.get(key).showInfo();
        }
        System.out.println("------------------------------------ End Villas List -----------------------------------");
    }

    public Map<Integer, Customer> getCustomersMapList(List<Customer> customersList) {
        //Sorting name before get customer object
        Collections.sort(customersList, new SortingCustomerNames());

        //Add each key and value as customer object into Map
        int i = 1;
        for (Customer customer : customersList) {
            customersMapList.put(i, customer);
            i++;
        }

        //Get customersMapList
        return customersMapList;
    }
    public void showCustomersMapList(Map<Integer, Customer> customersMapList) {
        //Show the customersMapList
        Set<Integer> customerKeys = customersMapList.keySet();
        System.out.println("___________________________________CUSTOMERS LIST________________________________________");
        System.out.printf("%-5s%-25s%-16s%-12s%-14s%-18s%-20s%-18s%-20s%-15s%s\n",
                "No.", "Full_Name", "Birthday", "Gender", "Id_Number", "Phone_Number", "Email",
                "Customer_Type", "Address", "Service_Id", "Service_Name");
        for (Integer key : customerKeys) {
            System.out.printf("%-5s", key + ".");
            customersMapList.get(key).showInfo();
        }
        System.out.println("---------------------------------- End Customers List -----------------------------------");
    }
}
