package session06_inheritance.demo;

class Faculty extends Employee {
    public Faculty() {
        //This line refer to constructor Employee();
        System.out.println("(4) Faculty performing its tasks...");
    }

    public static void main(String[] args) {
        new Faculty();
    }
}

class Employee extends Person {
    public Employee(String s) {
        System.out.println(s);
    }

    public Employee() {
        //This line refer to constructor Person();
        this("(2) Employee overloading its tasks!"); //Invoke Employee(String s);
        System.out.println("(3) Employee performing its tasks!!!");
    }
}

class Person {
    public Person() {
        System.out.println("(1) Person class performing its tasks.");
    }
}
