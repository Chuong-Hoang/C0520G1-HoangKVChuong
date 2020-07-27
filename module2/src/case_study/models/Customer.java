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
    private Services services;

    public Customer() {
    }

    // Constructor has attribute service
    public Customer(String name, String birthday, String gender, String idNumber, String phoneNumber,
                    String email, String customerType, String address,
                    Services services) {
        this(name, birthday, gender, idNumber, phoneNumber,
                email, customerType, address);
        this.services = services;
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

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public void showInfo() {
        System.out.println("Show customer information here...");
        System.out.printf("%-25s%-14s%-9s%-14s%-13s%-20s%-12s%-25s%s\n",
                name, birthday, gender, idNumber, phoneNumber, email, customerType, address,
                services.getServiceName());
    }
}
