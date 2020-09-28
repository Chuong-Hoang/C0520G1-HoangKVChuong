package vn.codegym.customer_jpa_spring.service;

import vn.codegym.customer_jpa_spring.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer obj);

    void delete(int id);

    void deleteMany(List<Integer> list);
}
