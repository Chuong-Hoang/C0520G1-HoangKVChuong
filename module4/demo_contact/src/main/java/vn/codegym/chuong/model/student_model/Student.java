package vn.codegym.chuong.model.student_model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.chuong.common.Validation;

import javax.persistence.*;

@Entity
public class Student implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String name;
    private String gender;
    private String phone;
    private String birthday;
    private String email;
    private String address;

    private String code;
    private boolean status = true;

    @ManyToOne
    @JoinColumn(name = "divisionId")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "hobbyId")
    private Hobby hobby;


    public Student() {
    }

    public Student(String name, String gender, String phone,
                   String birthday, String email, String address) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
    }

    public Student(String name, String gender, String phone,
                   String birthday, String email, String address,
                   Division division, Hobby hobby) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.division = division;
        this.hobby = hobby;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long id) {
        this.studentId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // validation
    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;

        // name
        if (student.getName().isEmpty()) {
            errors.rejectValue("name", "name.notValid");
        }

        // phone
        if (!student.getPhone().matches("^[0][\\d]{9,10}$")) {
            errors.rejectValue("phone", "phone.notValid");
        }

        // email
        if (!student.getEmail().matches("^([a-z]+[a-zA-Z0-9_.]*@[a-z]{2,}[\\.][\\w]{2,})$")) {
            errors.rejectValue("email", "email.notValid");
        }

//        // birthday (way 1)
//        if(!Validation.checkBirthday(student.getBirthday())){
//            errors.rejectValue("birthday", "birthday.notValid");
//        }

        // birthday (way 2)
        if(!Validation.checkDurationFromNow(student.getBirthday(), 18*12, -1) ||
        Validation.checkDurationFromNow(student.getBirthday(), 100*12, -1)){
            errors.rejectValue("birthday", "birthday.notValid");
        }

        // address
        if(!Validation.checkName(student.getAddress())){
            errors.rejectValue("address", "address.notValid");
        }

//        // code
//        if(!Validation.checkCode(student.getCode())){
//            errors.rejectValue("code", "code.notValid");
//        }

        // gender
        if(!Validation.checkGender(student.getGender())){
            errors.rejectValue("gender", "gender.notValid");
        }
    }
}
