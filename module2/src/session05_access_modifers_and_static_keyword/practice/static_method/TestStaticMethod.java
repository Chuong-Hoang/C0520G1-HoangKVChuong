package session05_access_modifers_and_static_keyword.practice.static_method;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change("college: BKDN"); // static method change() is invoked by class Student, not need any object.

        //Creating objects
        Student st1 = new Student(1101, "Chuong");
        Student st2 = new Student(1111, "Dat");
        Student st3 = new Student(1121, "Quang");
        //st3.change("college: changed to ST3");

        //Calling default (no access_modifier) display() method --> within package

        st1.display();
        st2.display();
        st3.display();

    }
}
