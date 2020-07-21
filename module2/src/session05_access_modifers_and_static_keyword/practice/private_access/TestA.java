package session05_access_modifers_and_static_keyword.practice.private_access;

public class TestA {
    public static void main(String[] args) {
        A obj = new A();
        //System.out.println(obj.data); // compile-time error
        //obj.msg(); // compile-time error
    }
}
