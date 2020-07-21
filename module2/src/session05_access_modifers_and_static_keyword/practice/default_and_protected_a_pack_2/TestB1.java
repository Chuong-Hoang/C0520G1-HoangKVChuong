package session05_access_modifers_and_static_keyword.practice.default_and_protected_a_pack_2;
import session05_access_modifers_and_static_keyword.practice.default_and_protected_a_pack.*; // Have to import pakage a_pack into this class for using class B1

public class TestB1 extends B1 {
    public static void main(String[] args) {
        System.out.println("You are using main method in class TestB1 extends from class B1");
        System.out.println("So it can access protected method msg() from class B1 in package a_pack.");
        TestB1 tb1 = new TestB1();
        tb1.msg();
    }
}
