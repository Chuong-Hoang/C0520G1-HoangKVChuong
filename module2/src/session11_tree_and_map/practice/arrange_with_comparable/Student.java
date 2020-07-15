package session11_tree_and_map.practice.arrange_with_comparable;

public class Student implements Comparable<Student>{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "name = '" + name + '\'' +
                ", age = " + age;
    }

    @Override
    public int compareTo(Student student) {
        int resultAge = this.age - student.getAge();
        if(resultAge == 0) {
            return this.name.compareTo(student.name);
        }
        return resultAge;
    }
}
