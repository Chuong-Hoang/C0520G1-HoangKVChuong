package vn.codegym.furama.model.sub_model;

import vn.codegym.furama.model.main_model.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long divisionId;
    private String divisionName;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public Division() {
    }

    public Division(String divisionName) {
        this.divisionName = divisionName;
    }
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Long getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
}
