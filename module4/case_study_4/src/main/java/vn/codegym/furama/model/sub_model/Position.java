package vn.codegym.furama.model.sub_model;

import vn.codegym.furama.model.main_model.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long positionId;
    private String positionName;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public Position() {
    }

    public Position(String positionName) {
        this.positionName = positionName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
