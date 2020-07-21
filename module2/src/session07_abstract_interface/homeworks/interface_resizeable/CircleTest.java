package session07_abstract_interface.homeworks.interface_resizeable;

public class CircleTest {
    public static void main(String[] args) {

        Circle cc = new Circle(100);
        System.out.println("Radius: " + cc.getRadius());
        System.out.println("Area: " + cc.getArea());
        cc.resize(10);
        System.out.println("Radius: " + cc.getRadius());
        System.out.println("Area: " + cc.getArea());
    }
}
