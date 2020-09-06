package main.bo.employee_bo;

import main.model.employee_model.Employee;
import java.util.Comparator;

public class EmployeeSortByNameBO implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getEmployeeName().compareTo(o2.getEmployeeName());
    }
}
