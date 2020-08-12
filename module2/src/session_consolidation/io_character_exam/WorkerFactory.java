package session_consolidation.io_character_exam;

public class WorkerFactory {
    private String id;
    private String name;
    private int age;
    private int salary;

    public WorkerFactory() {
    }

    public WorkerFactory(String id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
                ", age = " + age +
                ", salary = " + salary;
    }
}
