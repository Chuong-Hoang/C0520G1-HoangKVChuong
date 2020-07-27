package case_study.controllers;
import case_study.models.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManager {
    private List<Customer> customerObjectList;

    public CustomerManager() {
        this.customerObjectList = new ArrayList<>();
    }

    public CustomerManager(List<Customer> customerObjectList) {
        this.customerObjectList = customerObjectList;
    }

    public List<Customer> getCustomerObjectList() {
        return customerObjectList;
    }

    public void setCustomerObjectList(List<Customer> customerObjectList) {
        this.customerObjectList = customerObjectList;
    }

    public void addANewCustomer() {
        String name;
        String birthday;
        String gender;
        String idNumber;
        String phoneNumber;
        String email;
        String customerType;
        String address;
        Services services;
        Customer customer = null;

        Scanner sc = new Scanner(System.in);

        System.out.print("Input name: ");
        name = sc.nextLine();

        System.out.print("Input birthday: ");
        birthday = sc.nextLine();

        System.out.print("Input gender: ");
        gender = sc.nextLine();

        System.out.print("Input idNumber: ");
        idNumber = sc.nextLine();

        System.out.print("Input phoneNumber: ");
        phoneNumber = sc.nextLine();

        System.out.print("Input email: ");
        email = sc.nextLine();

        System.out.print("Input customerType: ");
        customerType = sc.nextLine();

        System.out.print("Input address: ");
        address = sc.nextLine();

        customer = new Customer(name, birthday, gender, idNumber, phoneNumber, email, address, customerType);
        this.customerObjectList.add(customer);
    }

    public void showCustomerList() {
        for (Customer customer : customerObjectList) {
            customer.showInfo();
        }
    }
}
