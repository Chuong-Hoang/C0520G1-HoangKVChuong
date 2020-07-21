package session06_inheritance.demo;

public class AnimalTest {
    public static void main(String[] args) {
       Animal animal = new Animal();
       animal.roam();
       animal.sleep();

       System.out.println();
       Dog d = new Dog();
       d.roam();
       d.sleep();
       d.chaseBall();
       System.out.println(d.roam("Kitchen"));
       System.out.println();

       Animal a = new Dog(); // ép kiểu ngầm định
       a.sleep();
       a.roam();
       a.eat();
       System.out.println(((Dog) a).roam("Living room"));
       ((Dog) a).chaseBall();



    }
}
