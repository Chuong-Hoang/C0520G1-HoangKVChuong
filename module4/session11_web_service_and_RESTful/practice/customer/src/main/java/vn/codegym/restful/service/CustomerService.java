package vn.codegym.restful.service;

import vn.codegym.restful.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer model);

    void remove(int id);
}
