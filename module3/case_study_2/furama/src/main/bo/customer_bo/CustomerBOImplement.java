package main.bo.customer_bo;

import main.dao.customer_dao.CustomerDAO;
import main.dao.customer_dao.CustomerDAOImplement;
import main.model.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerBOImplement implements CustomerBO {
    CustomerDAO customerDAO = new CustomerDAOImplement();

    @Override
    public void create(Customer customer) throws SQLException {
        this.customerDAO.create(customer);
    }

    @Override
    public Customer findById(int id) {
        return this.customerDAO.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerDAO.findAll();
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return this.customerDAO.delete(id);
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        return this.customerDAO.update(customer);
    }

    @Override
    public List<Customer> findByName(String nameString) {
        return this.customerDAO.findByName(nameString);
    }

}
