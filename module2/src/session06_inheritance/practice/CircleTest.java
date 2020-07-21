package session06_inheritance.practice;

public class CircleTest {
    public static void main(String[] args) {
        Shape sh = new Circle();
        System.out.println(sh);
        System.out.println(sh.toString());
        System.out.println();

        Circle c = new Circle();
        System.out.println(c);
        System.out.println(c.toString());
        System.out.println();

        Object o = new Circle();
        System.out.println(o);
        System.out.println(o.toString());
        System.out.println();

        Circle c1 = new Circle(10.0);
        System.out.println(c1);
        System.out.println(c1.toString());
        System.out.println();

        Circle c2 = new Circle("red", true, 15.5);
        System.out.println(c2);
        System.out.println(c2.toString());
    }
}
