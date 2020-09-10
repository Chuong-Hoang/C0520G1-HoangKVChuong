package main.bo.customer_bo;

import main.model.customer_model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO {
    // sql manipulation
    public void create(Customer el) throws SQLException;

    //public Customer findById(int id);
    public Customer findById(String id);

    public List<Customer> findAll();

    //public boolean delete(int id) throws SQLException;
    public boolean delete(String id) throws SQLException;

    //public boolean update(Customer el) throws SQLException;
    public boolean update(String id, Customer el) throws SQLException;

    List<Customer> findByName(String str);

    // 3.10 Task 10
    public List<Customer> deleteOnScreen(String id);
}
