package session7_abstract_interface.homeworks.interface_resizeable;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle(10, 20);
        System.out.println("Width: " + rec.getWidth());
        System.out.println("Height: " + rec.getHeight());
        System.out.println("Perimeter: " + rec.getPerimeter());
        System.out.println("Area: " + rec.getArea());

        System.out.println();
        rec.resize(Math.random()*100);
        System.out.println("Width: " + rec.getWidth());
        System.out.println("Height: " + rec.getHeight());
        System.out.println("Perimeter: " + rec.getPerimeter());
        System.out.println("Area: " + rec.getArea());
    }
}
