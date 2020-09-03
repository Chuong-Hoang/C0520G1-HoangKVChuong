package main.bo.customer_bo;

import main.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO {
    // sql manipulation
    public void create(Customer customer) throws SQLException;

    public Customer findById(int id);

    public List<Customer> findAll();

    public boolean delete(int id) throws SQLException;

    public boolean update(Customer user) throws SQLException;

    List<Customer> findByName(String nameString);
}
