package main.bo.employee_bo;

import main.model.employee_model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO {
    // sql manipulation
    public void create(Employee el) throws SQLException;

    //public Employee findById(int id);
    public Employee findById(String id);

    public List<Employee> findAll();

    //public boolean delete(int id) throws SQLException;
    public boolean delete(String id) throws SQLException;

    //public boolean update(Employee el) throws SQLException;
    public boolean update(String id, Employee el) throws SQLException;

    List<Employee> findByName(String str);
}
