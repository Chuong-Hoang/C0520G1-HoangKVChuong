package vn.codegym.furama.model.sub_model;

import vn.codegym.furama.model.main_model.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eductionDegreeId;
    private String educationDegreeName;

    @OneToMany(mappedBy = "educationDegree", cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public EducationDegree() {
    }

    public EducationDegree(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Long getEductionDegreeId() {
        return eductionDegreeId;
    }

    public void setEductionDegreeId(Long eductionDegreeId) {
        this.eductionDegreeId = eductionDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }
}
