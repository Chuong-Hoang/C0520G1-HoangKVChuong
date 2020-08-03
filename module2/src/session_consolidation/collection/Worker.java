package session_consolidation.collection;

public class Worker implements Comparable<Worker> {
    private String name;
    private String id;
    private int age;

    public Worker(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public Worker() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age;
    }

    @Override
    public int compareTo(Worker worker) {
        int nameResult = this.name.compareTo(worker.getName());
        if(nameResult == 0) {
            return this.age - worker.getAge();
        }
        return nameResult;
    }
}
