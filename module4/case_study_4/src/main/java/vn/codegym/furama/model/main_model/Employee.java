package vn.codegym.furama.model.main_model;

import vn.codegym.furama.model.sub_model.Division;
import vn.codegym.furama.model.sub_model.EducationDegree;
import vn.codegym.furama.model.sub_model.Position;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    private String employeeName;
    private String employeeBirthday;
    private String employeeIdCard;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    private String employeeSalary;

    @ManyToOne
    @JoinColumn(name = "positionId")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "divisionId")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "educationDegreeId")
    private EducationDegree educationDegree;

    public Employee() {
    }

    public Employee(String employeeName, String employeeBirthday, String employeeIdCard,
                    String employeePhone, String employeeEmail, String employeeAddress, String employeeSalary,
                    Position position, Division division, EducationDegree educationDegree) {
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.employeeSalary = employeeSalary;
        this.position = position;
        this.division = division;
        this.educationDegree = educationDegree;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }
}
