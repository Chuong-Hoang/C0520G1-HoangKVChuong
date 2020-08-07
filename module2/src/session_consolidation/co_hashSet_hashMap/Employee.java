package session_consolidation.co_hashSet_hashMap;

import java.util.Objects;

public class Employee {
    private String id;
    private String name;
    private String position;
    private int salary;

    public Employee() {
    }

    public Employee(String id, String name, String position, int salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id = '" + id + '\'' +
                ", name = '" + name + '\'' +
                ", position = '" + position + '\'' +
                ", salary = " + salary;
    }

    @Override
    public boolean equals(Object obj) {
        Employee otherEmployee = (Employee) obj;
        if(this.id.compareTo(otherEmployee.getId()) == 0){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 111 + id.hashCode();
    }


}
