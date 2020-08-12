package case_study.models;

public class Customer {
    private String name;
    private String birthday;
    private String gender;
    private String idNumber;
    private String phoneNumber;
    private String email;
    private String customerType;
    private String address;
    private Service service = new Villa("N/A", "N/A");

    public Customer() {
    }

    // Constructor has attribute service <Services>
    public Customer(String name, String birthday, String gender, String idNumber, String phoneNumber,
                    String email, String customerType, String address,
                    Service service) {
        this(name, birthday, gender, idNumber, phoneNumber,
                email, customerType, address);
        this.service = service;
    }

    // Constructor DON'T have attribute service
    public Customer(String name, String birthday, String gender, String idNumber, String phoneNumber,
                    String email, String customerType, String address) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void showInfo() {
        System.out.printf("%-25s%-16s%-12s%-14s%-18s%-20s%-18s%-20s%-15s%s\n",
                name, birthday, gender, idNumber, phoneNumber, email, customerType, address,
                this.getService().getId(), this.getService().getServiceName());
    }
}
