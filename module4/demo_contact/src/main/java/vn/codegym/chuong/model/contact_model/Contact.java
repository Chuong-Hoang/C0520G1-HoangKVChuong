package vn.codegym.chuong.model.contact_model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.chuong.common.Validation;

import javax.persistence.*;

@Entity
public class Contact implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;
    private String name;
    private String gender;
    private String birthday;
    private String phone;
    private String email;
    private String address;

    private String code;
    private boolean status = true;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private ContactGroup contactGroup;

    public Contact() {
    }

    public Contact(String name, String gender, String birthday, String email, String address, String phone, ContactGroup contactGroup) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.contactGroup = contactGroup;
    }

    public Contact(String name, String gender, String birthday, String email, String address, String phone) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.address = address;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public ContactGroup getContactGroup() {
        return contactGroup;
    }

    public void setContactGroup(ContactGroup contactGroup) {
        this.contactGroup = contactGroup;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Contact.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contact contact = (Contact) target;

        // name
        if (contact.getName().isEmpty()) {
            errors.rejectValue("name", "name.notValid");
        }

        // phone
        if (!contact.getPhone().matches("^[0][\\d]{9,10}$")) {
            errors.rejectValue("phone", "phone.notValid");
        }

        // email
        if (!contact.getEmail().matches("^([a-z]+[a-zA-Z0-9_.]*@[a-z]{2,}[\\.][\\w]{2,})$")) {
            errors.rejectValue("email", "email.notValid");
        }

        // birthday
        if(!Validation.checkBirthday(contact.getBirthday())){
            errors.rejectValue("birthday", "birthday.notValid");
        }

        // address
        if(!Validation.checkName(contact.getAddress())){
            errors.rejectValue("address", "address.notValid");
        }

        // gender
        if(!Validation.checkGender(contact.getGender())){
            errors.rejectValue("gender", "gender.notValid");
        }

    }
}
