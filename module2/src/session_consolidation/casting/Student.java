package session_consolidation.casting;

import java.util.Stack;

public class Student extends Pupil {
    private double gpa;
    protected int age = 15;

    public Student(double gpa) {
        this.gpa = gpa;
    }

    public Student(String id, String name, String address, int age, double gpa) {
        super(id, name, address, age);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public static void main(String[] args) {
        Pupil newPupil = new Student(7.73);
        System.out.println(newPupil.getAge());
        //newPupil.getGpa(); // cannot get gpa because the reference of the Student object is of Pupil class.
        Student otherStudent = new Student(8.72);
        System.out.println(otherStudent.getGpa());
        System.out.println(otherStudent.age);

        Stack<Student> studentStack = new Stack<>();
        studentStack.addElement(new Student(8.9));
     
    }
}
