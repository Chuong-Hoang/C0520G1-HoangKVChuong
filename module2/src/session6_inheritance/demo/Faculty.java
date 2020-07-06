package session6_inheritance.demo;

class Faculty extends Employee {
    public Faculty() {
        System.out.println("Faculty performing its tasks...");
    }

    public static void main(String[] args) {
        new Faculty();
    }
}

class Employee extends Person {
    public Employee() {
        this("Employee overloading its tasks!");
        System.out.println("Employee performing its tasks!!!");
    }
    public Employee(String s) {
        System.out.println(s);
    }
}

class Person {
    public Person(){
        System.out.println("Person class performing its tasks.");
    }
}
