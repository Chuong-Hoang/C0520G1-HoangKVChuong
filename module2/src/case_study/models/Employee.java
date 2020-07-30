package case_study.models;

public class Employee {
    private String name;
    private String id;
    private int age;
    private String address;

    public Employee() {
    }

    public Employee(String id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        System.out.printf("%-20s%-25s%-20s%s\n", id, name, age, address);
        return "\"%-20s%-25s%-20s%s\\n\"\",\" id\",\"name \",\"age\",\"address";
    }
}
