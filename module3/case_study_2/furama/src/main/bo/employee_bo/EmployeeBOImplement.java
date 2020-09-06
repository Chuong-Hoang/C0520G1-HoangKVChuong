package main.bo.employee_bo;

import main.dao.employee_dao.EmployeeDAO;
import main.dao.employee_dao.EmployeeDAOImplement;
import main.model.employee_model.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeBOImplement implements EmployeeBO {
    EmployeeDAO employeeDAO = new EmployeeDAOImplement();

    @Override
    public void create(Employee el) throws SQLException {
        this.employeeDAO.create(el);
    }

    @Override
    public Employee findById(String id) {
        return this.employeeDAO.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return this.employeeDAO.delete(id);
    }

    @Override
    public boolean update(String id, Employee el) throws SQLException {
        return this.employeeDAO.update(id, el);
    }

    @Override
    public List<Employee> findByName(String str) {
        return this.employeeDAO.findByName(str);
    }

}
