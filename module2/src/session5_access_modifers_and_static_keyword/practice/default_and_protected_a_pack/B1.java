package session5_access_modifers_and_static_keyword.practice.default_and_protected_a_pack;

public class B1 {
    protected void msg(){
        System.out.println("This is protected method msg() in class B1 of package a_pack");
        System.out.println("It can be accessed within package a_pack.");
        System.out.println("It can be accessed outside package a_pack ONLY BY inheritance.");
    }
}
