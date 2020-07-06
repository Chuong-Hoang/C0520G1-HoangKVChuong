package demo;

public class Human {
    private String name = "aa";
    private int age;
    private String add;
    public static String skin = "yellow";
    public static int count = 0;
    public static String country;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    public String getCount() {
        return "Da them so nguoi la: " + (count);
    }

    public static void getPublic(int code) {
        if (code == 1) {
            country = "VIET NAM";
        } else {
            country = "My";
        }
    }

    public Human() {
    }

    public Human(String name) {
        this.name = name;
    }

    public Human(int age) {
        System.out.println("da vao tuoi");
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void swap(Human p1, Human p2) {
        String temp = p1.name;
        p1.name = p2.name;
        p2.name = temp;
    }

    public void swap1(Human p1, Human p2) {
        Human temp = p1;
        p1 = p2;
        p2 = temp;
    }

    public static void main(String[] args) {
        getPublic(0);
        Human person1 = new Human("Mai", 25);
        Human person2 = new Human("Hong", 17);

        person1.swap1(person1, person2); // swap object
        System.out.println(person1.getName() + ":" + person1.getAge());
        System.out.println(person2.getName() + ":" + person2.getAge());

        person1.swap(person1, person2); // swap attribute
        System.out.println(person1.getName() + ":" + person1.getAge());
        System.out.println(person2.getName() + ":" + person2.getAge());

        Human.getPublic(1);
        System.out.println(person1.country);
        person1.skin = "black";
        person2.skin = "Skin 222";
        System.out.println(person1.skin);
    }

}
