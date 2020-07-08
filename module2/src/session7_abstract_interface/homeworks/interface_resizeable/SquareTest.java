package session7_abstract_interface.homeworks.interface_resizeable;

public class SquareTest {
    public static void main(String[] args) {
        Square s = new Square(10);
        System.out.println("side: " + s.getSide());
        System.out.println("height: " + s.getHeight());
        System.out.println("width: " + s.getWidth());
        System.out.println("perimeter: " + s.getPerimeter());
        System.out.println("area: " + s.getArea());

        System.out.println();
        s.resize(100);
        System.out.println("side: " + s.getSide());
        System.out.println("height: " + s.getHeight());
        System.out.println("width: " + s.getWidth());
        System.out.println("perimeter: " + s.getPerimeter());
        System.out.println("area: " + s.getArea());

    }
}
