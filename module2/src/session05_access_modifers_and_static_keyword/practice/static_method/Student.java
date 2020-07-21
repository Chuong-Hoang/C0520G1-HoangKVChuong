package session05_access_modifers_and_static_keyword.practice.static_method;

public class Student {
    private int rollNo;
    private String name;
    private static String college = "CODEGYM"; // private: only accessible in this class.
    // static: class variable/field/attribute is common for class and all instances of this class.

    Student(int r, String n){
        rollNo = r;
        name = n;
    }

    // static method can be invoked by 3 means:
    // Class.method(); object.method(); method()
    static void change(String s){
        college = s;
    }

    void display(){
        System.out.println(rollNo + " - " + name + " - " + college);
    }
}
