package main.dao.employee_dao;

import main.model.employee_model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    public void create(Employee el) throws SQLException;

    //public Customer findById(int id);
    public Employee findById(String id);

    public List<Employee> findAll();

    public boolean delete(String id) throws SQLException;
    //public boolean delete(int id) throws SQLException;

    //public boolean update(Employee el) throws SQLException;
    public boolean update(String id, Employee el) throws SQLException;

    List<Employee> findByName(String str);

}
