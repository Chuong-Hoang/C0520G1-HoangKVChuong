package session10_stack_and_queue.practice.using_comparable;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "name = '" + name + '\'' +
                ", age = " + age +
                ", gender = '" + gender + '\'';
    }

    @Override
    public int compareTo(Person p) {
        return this.getAge() - p.getAge();
    }
}
