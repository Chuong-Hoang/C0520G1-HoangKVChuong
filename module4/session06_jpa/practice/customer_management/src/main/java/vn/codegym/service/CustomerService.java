package vn.codegym.service;

import vn.codegym.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer el);

    void update(int id, Customer el);

    void remove(int id);
}
