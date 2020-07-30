package case_study.controllers;

import case_study.models.Employee;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EmployeeManager {
    private Map<String, Employee> employeeMapList;

    public EmployeeManager() {
        employeeMapList = new TreeMap<>();
    }

    public EmployeeManager(Map<String, Employee> employeeMapList) {
        this.employeeMapList = employeeMapList;
    }

    public Map<String, Employee> getEmployeeMapList() {
        return employeeMapList;
    }

    public void setEmployeeMapList(Map<String, Employee> employeeMapList) {
        this.employeeMapList = employeeMapList;
    }

    public void displayEmployeeList() {
        Set<String> employeeIds = this.employeeMapList.keySet();
        System.out.println("________________Employees List_________________");
        System.out.printf("%-20s%-25s%-20s%s\n", "Employee_Id", "Employee_Name","Employee_Age", "Employee_Address");
        for (String id : employeeIds) {
            this.employeeMapList.get(id).toString();
        }
        System.out.println("..................End Employees List................");
    }
}
