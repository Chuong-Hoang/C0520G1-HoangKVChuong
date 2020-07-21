package session05_access_modifers_and_static_keyword.practice.static_property;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car car1 = new Car("Corolla", "C1211T", "Black", "Toyota");
        System.out.println(Car.numberOfCars);
        System.out.println(car1.numberOfCars);
        Car car2 = new Car("Grandis", "G1102T", "Bisque","Toyota");
        System.out.println(Car.numberOfCars);
        System.out.println(car2.numberOfCars);
        Car car3 = new Car("Civic", "C0210H", "White", "Honda");
        System.out.println(Car.numberOfCars);
        System.out.println(car3.numberOfCars);
    }
}
