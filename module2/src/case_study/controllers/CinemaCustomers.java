package case_study.controllers;

import case_study.models.Customer;

import java.util.*;

public class CinemaCustomers {
    private List<Customer> customerObjectList;
    private static Queue<Customer> cinemaCustomerList;

    public CinemaCustomers() {
        cinemaCustomerList = new LinkedList<>();
    }

    public CinemaCustomers(Queue<Customer> cinemaCustomerList) {
        this.cinemaCustomerList = cinemaCustomerList;
    }

    public Queue<Customer> getCinemaCustomerList() {
        return cinemaCustomerList;
    }

    public void setCinemaCustomerList(Queue<Customer> cinemaCustomerList) {
        this.cinemaCustomerList = cinemaCustomerList;
    }

    public List<Customer> getCustomerObjectList() {
        return customerObjectList;
    }

    public void setCustomerObjectList(List<Customer> customerObjectList) {
        this.customerObjectList = customerObjectList;
    }

    //Operational Methods()

    //Customers of Furama Cinema
    public void addCinemaCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input ticket-buying-customer Id number: ");
        String customerId = sc.nextLine();
        System.out.println("New cinema customer Id:" + customerId);
        boolean isFound = false;
        for (Customer customer : this.customerObjectList) {
            if (customerId.compareTo(customer.getIdNumber()) == 0) {
                cinemaCustomerList.offer(customer);
                customer.showInfo();
//                cinemaCustomerList.add(customer);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            System.out.println("Customer id: " + customerId + " has been added to cinema customers list.");
            System.out.println("........................................................................");
            System.out.print("Add another customer? Yes(1) / No(0)? ");
            int option = Integer.parseInt(sc.nextLine());
            if (option == 1) {
                addCinemaCustomer();
            }
        } else {
            System.out.println("Customer with Id " + customerId + " not found in the data.");
        }
    }

    //Display cinema customers list
    public void displayCinemaCustomerList() {
        System.out.println("_______________CINEMA CUSTOMERS LIST_____________");
        System.out.printf("%-6s%-25s%-16s%-12s%-14s%-18s%-20s%-18s%-20s%-15s%s\n",
                "No.","Name", "Birthday", "Gender", "ID_Number", "Phone_Number", "Email", "Customer_Type", "Address",
                "Service_Id", "Service_Name");

        int i = 1;
        for (Customer customer : cinemaCustomerList) {
            System.out.printf("%-6s", i + ".");
            customer.showInfo();
            i++;
        }
        System.out.println("--------------- End Cinema_Customers_List --------------");
    }
}
