package main.bo.customer_bo;

import main.model.customer_model.Customer;

import java.util.Comparator;

public class CustomerSortByNameBO implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getCustomerName().compareTo(o2.getCustomerName());
    }
}
