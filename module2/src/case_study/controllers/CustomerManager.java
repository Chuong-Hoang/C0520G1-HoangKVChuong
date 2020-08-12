package case_study.controllers;

import case_study.commons.*;
import case_study.models.*;
import case_study.views.SortingCustomerNames;

import java.util.*;

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




    // Customer of Furama RESORT
    public void addANewCustomer() {
        String name = "";
        String birthday = "";
        String gender = "";
        String idNumber = "";
        String phoneNumber = "";
        String email = "";
        String customerType = "";
        String address = "";
        Service service;
        Customer customer = null;

        Scanner sc = new Scanner(System.in);
        boolean isValid;

        //Input customer name
        do {
            isValid = true;
            System.out.print("Input name: ");
            try {
                name = sc.nextLine();
                if (!InputValidation.validatePersonName(name)) {
                    isValid = false;
                    throw new NameException("Only the first characters in each word must be uppercase.");
                }
            } catch (NameException ex) {
                System.out.println(ex);
            }
        } while (!isValid);

        //Input customer birthday
        do {
            isValid = true;
            System.out.print("Input birthday: ");
            try {
                birthday = sc.nextLine();
                if (!InputValidation.validateBirthday(birthday)) {
                    isValid = false;
                    throw new BirthdayException("Birthday must format as dd/mm/yyyy and yyyy > 1900 and customer year-old" +
                            "must be greater than 18.");
                }
            } catch (BirthdayException ex) {
                System.out.println(ex);
            }
        } while (!isValid);

        //Input customer gender
        do {
            isValid = true;
            System.out.print("Input gender: ");
            try {
                gender = sc.nextLine();
                if (!InputValidation.validateGender(gender)) {
                    isValid = false;
                    throw new GenderException("Gender must be 'Male/Female/Unknown.");
                }
                String genderLower = gender.toLowerCase();
                String genderUpper = gender.toUpperCase();
                gender = genderUpper.substring(0, 1).concat(genderLower.substring(1));
            } catch (GenderException ex) {
                System.out.println(ex);
            }
        } while (!isValid);

        //Input Id Card Number
        do {
            isValid = true;
            System.out.print("Input idNumber: ");
            try {
                idNumber = sc.nextLine();
                if (!InputValidation.validateIdCard(idNumber)) {
                    isValid = false;
                    throw new IdCardException("Id number must have 9 digits and format as 'XXX XXX XXX'.");
                }
            } catch (IdCardException ex) {
                System.out.println(ex);
            }
        } while (!isValid);


        System.out.print("Input phoneNumber: ");
        phoneNumber = sc.nextLine();

        do {
            isValid = true;
            System.out.print("Input email: ");
            try {
                email = sc.nextLine();
                if (!InputValidation.validateEmail(email)) {
                    isValid = false;
                    throw new EmailException("Email format must be abc@abc.abc");
                }
            } catch (EmailException ex) {
                System.out.println(ex);
            }
        } while (!isValid);

        //Input customer type
        System.out.print("Input customerType (1.Diamond/2.Platinum/3.Gold/4.Silver/5.Member): ");
        int option = Integer.parseInt(sc.nextLine());
        switch (option) {
            case 1:
                customerType = "Diamond";
                break;
            case 2:
                customerType = "Platinum";
                break;
            case 3:
                customerType = "Gold";
                break;
            case 4:
                customerType = "Silver";
                break;
            case 5:
                customerType = "Member";
                break;
            default:
                customerType = "N/A";
                break;
        }

        //Input customer address
        System.out.print("Input address: ");
        address = sc.nextLine();

        //Create new customer object
        customer = new Customer(name, birthday, gender, idNumber, phoneNumber, email, customerType, address);
        customer.showInfo();

        //Add new customer object into customerObjectList
        this.customerObjectList.add(customer);
    }

    public void displayCustomerList() {
        System.out.printf("%-25s%-16s%-12s%-14s%-18s%-20s%-18s%-20s%-15s%s\n",
                "Full_Name", "Birthday", "Gender", "Id_Number", "Phone_Number", "Email", "Customer_Type", "Address",
                "Service_Id", "Service_Name");
        SortingCustomerNames sortingCustomerNames = new SortingCustomerNames();
        Collections.sort(this.customerObjectList, sortingCustomerNames);
        for (Customer customer : this.customerObjectList) {
            customer.showInfo();
        }
        System.out.println(". . . . . . . . . . . . . . .End Customers List . . . . . . . . . . . . . . . . . . .");

    }

    public void deleteCustomer(String idNumber) {
        if (customerObjectList.isEmpty()) {
            System.out.println("Cannot delete any customer. The customer list is empty...");
        } else {
            boolean isFound = false;
            for (Customer customer : this.customerObjectList) {
                if (idNumber.compareTo(customer.getIdNumber()) == 0) {
                    this.customerObjectList.remove(customer);
                    customer.showInfo();
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                System.out.println("__Customer Id number " + idNumber + " was removed from the list__");
            } else {
                System.out.println("=> Customer Id number " + idNumber + " not found in the list.");
            }
        }
    }
}
