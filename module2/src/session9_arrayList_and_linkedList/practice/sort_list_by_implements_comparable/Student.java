package session9_arrayList_and_linkedList.practice.sort_list_by_implements_comparable;

public class Student implements Comparable {
    private int studentID;
    private String name;
    private int age;

    public Student(int studentID, String name, int age) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
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
        return  "name = '" + name + '\'' +
                " age = " + age;
    }

    @Override
    public int compareTo(Object o) {
        Student otherStudent = (Student) o;
        int result = this.name.compareTo(otherStudent.getName());
        if(result == 0) {
            if(this.age > otherStudent.getAge()) return 1;
            else if(this.age < otherStudent.getAge()) return -1;
            else return 0;
        }

        return result;
    }
}
