package session5_practice_default_and_protected_a_pack;

public class C1 {
    public static void main(String[] args) {
        System.out.println("You are at main() of class C1 in package a_pack");
        System.out.println("Class C1 can access public/default class B1 in the same package.");
        System.out.println("So class C1 can create object of class B1");
        System.out.println("and this object using protected method msg().");
        B1 b = new B1();
        b.msg();
    }
}
