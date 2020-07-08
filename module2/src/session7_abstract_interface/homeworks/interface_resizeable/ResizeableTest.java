package session7_abstract_interface.homeworks.interface_resizeable;

public class ResizeableTest {
    public static void main(String[] args) {
        Circle c = new Circle(10);
        System.out.println("Circle radius = " + c.getRadius());
        System.out.println("Circle perimeter = " + c.getPerimeter());
        System.out.println("Circle area = " + c.getArea());
        System.out.println();

        c.resize(100);
        System.out.println("Circle radius = " + c.getRadius());
        System.out.println("Circle perimeter = " + c.getPerimeter());
        System.out.println("Circle area = " + c.getArea());
        System.out.println();

        Rectangle r = new Rectangle(10, 20);
        System.out.println("Height: " + r.getHeight());
        System.out.println("Width: " + r.getWidth());
        System.out.println("Perimeter: " + r.getPerimeter());
        System.out.println("Area: " + r.getArea());
        System.out.println();

        r.resize(50);
        System.out.println("Height: " + r.getHeight());
        System.out.println("Width: " + r.getWidth());
        System.out.println("Perimeter: " + r.getPerimeter());
        System.out.println("Area: " + r.getArea());
        System.out.println();

        Square s = new Square(100);
        System.out.println("Side: " + s.getSide());
        System.out.println("Perimeter: " + s.getPerimeter());
        System.out.println("Area: " + s.getArea());
        System.out.println();

        s.resize(-50);
        System.out.println("Side: " + s.getSide());
        System.out.println("Perimeter: " + s.getPerimeter());
        System.out.println("Area: " + s.getArea());
        System.out.println();

        Shape sh = new Circle(100);
        Circle c1 = (Circle) sh;
        System.out.println("Circle radius = " + c1.getRadius());
        System.out.println("Circle perimeter = " + c1.getPerimeter());
        System.out.println("Circle area = " + c1.getArea());
        System.out.println();

        c1.resize(100);
        System.out.println("Circle radius = " + c1.getRadius());
        System.out.println("Circle perimeter = " + c1.getPerimeter());
        System.out.println("Circle area = " + c1.getArea());
        System.out.println();
    }

}
