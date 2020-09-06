package main.bo.customer_bo;

import main.dao.customer_dao.CustomerDAO;
import main.dao.customer_dao.CustomerDAOImplement;
import main.model.customer_model.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerBOImplement implements CustomerBO {
    CustomerDAO customerDAO = new CustomerDAOImplement();

    @Override
    public void create(Customer el) throws SQLException {
        this.customerDAO.create(el);
    }

    @Override
    public Customer findById(String id) {
        return this.customerDAO.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerDAO.findAll();
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return this.customerDAO.delete(id);
    }

    @Override
    public boolean update(String id, Customer el) throws SQLException {
        return this.customerDAO.update(id, el);
    }

    @Override
    public List<Customer> findByName(String str) {
        return this.customerDAO.findByName(str);
    }

}
