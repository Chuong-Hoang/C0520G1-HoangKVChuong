package session07_abstract_interface.practice.animal_and_interface_edible;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for(Animal a : animals) {
            System.out.println(a.makeSound());
        }

        System.out.println(((Chicken) animals[1]).howToEat());
        System.out.println(((Tiger) animals[0]).howToEat());
        System.out.println();

        Fruit f = new Fruit() {
            @Override
            public String howToEat() {
                return "This method howToEat() is overridden in an Anonymous class";
            }
        };
        System.out.println(f.howToEat());

        Fruit apple = new Apple();
        System.out.println(apple.howToEat());
        Fruit orange = new Orange();
        System.out.println(orange.howToEat());
    }
}
