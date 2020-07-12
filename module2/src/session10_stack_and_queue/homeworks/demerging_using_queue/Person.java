package session10_stack_and_queue.homeworks.demerging_using_queue;

public class Person {
    private String name;
    private String birthday;
    private String gender;

    public Person(String name, String birthday, String gender) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "name = '" + name + '\'' +
                ", birthday = '" + birthday + '\'' +
                ", gender = '" + gender + '\'';
    }
}
