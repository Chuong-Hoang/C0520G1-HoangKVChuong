package session5_access_modifers_and_static_keyword.homeworks;

public class TestCircle {
    public static void main(String[] args) {
        Circle c = new Circle(10);
        System.out.println("Radius: " + c.getRadius());
        System.out.println("Area: " + c.getArea());

        Circle c1 = new Circle();
        System.out.println("Radius: " + c1.getRadius());
        System.out.println("Area: " + c1.getArea());
    }
}
