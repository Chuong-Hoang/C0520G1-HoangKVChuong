package session06_inheritance.demo;

public class Animal {
    private String name = "SSS";

    public Animal() {
        System.out.println("An animal is created");
    }

    public void sleep() {
        System.out.println("Animal sleeps");
    }

    public void eat() {
        System.out.println("Animal eats");
    }

    public void roam() {
        System.out.println("Animal is roaming");
    }
}

class Dog extends Animal {
    private String skin = "yellow";

    public Dog() {
        // Animal();
        System.out.println("A dog is created");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping.");
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    public String roam(String place) {
        return "Dog is roaming at " + place;
    }

    public void chaseBall() {
        System.out.println("This dog is chasing a ball");
    }
}


