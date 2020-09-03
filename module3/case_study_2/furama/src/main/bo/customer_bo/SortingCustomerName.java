package main.bo.customer_bo;

import main.model.Customer;

import java.util.Comparator;

public class SortingCustomerName implements Comparator<Customer> {
    @Override
    public int compare(Customer u1, Customer u2) {
        return u1.getCustomerName().compareTo(u2.getCustomerName());
    }
}
