package vn.codegym.chuong.model.main_model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.chuong.model.sub_model.Division;
import vn.codegym.chuong.model.sub_model.EducationDegree;
import vn.codegym.chuong.model.sub_model.Position;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee implements Validator {
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

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Contract> contractList;

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

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;

        // name
        if (employee.getEmployeeName().isEmpty()) {
            errors.rejectValue("employeeName", "employeeName.notValid");
        }

        // address
        if (employee.getEmployeeAddress().isEmpty()) {
            errors.rejectValue("employeeAddress", "employeeAddress.notValid");
        }

        // phone-number
        if (!employee.getEmployeePhone().matches("^[0][\\d]{9,10}$")) {
            errors.rejectValue("employeePhone", "employeePhone.notValid");
        }

        // salary
        if (!employee.getEmployeeSalary().matches("^[1-9]+[\\.]?[\\d]{1,}$")) {
            errors.rejectValue("employeeSalary", "employeeSalary.notValid");
        }

        // Id card
        if (!employee.getEmployeeIdCard().matches("^[0][\\d]{9}([\\d]{3})?$")) {
            errors.rejectValue("employeeIdCard", "employeeIdCard.notValid");
        }

        // email
        if (!employee.getEmployeeEmail().matches("^([a-z]+[a-zA-Z0-9_.]*@[a-z]{2,}[\\.][\\w]{2,})$")) {
            errors.rejectValue("employeeEmail", "employeeEmail.notValid");
        }

    }
}
