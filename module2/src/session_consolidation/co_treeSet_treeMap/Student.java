package session_consolidation.co_treeSet_treeMap;

public class Student implements Comparable {
    private String id;
    private String name;
    private String address;
    private int age;

    public Student() {
    }

    public Student(String id, String name, String address, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
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
        return "id = '" + id + '\'' +
                ", name = '" + name + '\'' +
                ", address = '" + address + '\'' +
                ", age = " + age;
    }

    @Override // This method is overridden for using in TREE_SET and TREE_MAP.
    public int compareTo(Object obj) {
        Student otherStudent = (Student) obj;
        if (this.name.equals(otherStudent.getName())) {
            return 0;
        } else {
            return this.name.compareTo(otherStudent.getName());
        }
    }
}