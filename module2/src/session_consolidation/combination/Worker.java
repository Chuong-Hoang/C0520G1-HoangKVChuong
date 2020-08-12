package session_consolidation.combination;

import java.io.Serializable;

public class Worker implements Serializable, Comparable<Worker> {
    private String id;
    private String name;
    private String birthday;
    private int salary;

    public Worker() {
    }

    public Worker(String id, String name, String birthday, int salary) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
                ", birthday = '" + birthday + '\'' +
                ", salary = " + salary;
    }

    @Override
    public int compareTo(Worker worker) {
        int salaryResult = this.getSalary() - worker.getSalary();
        if(salaryResult == 0) {
            return this.getId().compareTo(worker.getId());
        }
        return  salaryResult;
    }
}
