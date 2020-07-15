package session6_inheritance.homeworks.circle_pack;

import session6_inheritance.homeworks.circle_pack.Circle;

public class CircleTest {
    public static void main(String[] args) {
        Circle c = new Circle();
        System.out.println(c);
        System.out.println();

        c.setColor("NAVY");
        c.setRadius(5);
        System.out.println(c.toString());
        System.out.println();

        Circle c2 = new Circle(10, "INDIGO");
        System.out.println(c2);
        System.out.println("Area of c2: " + c2.getArea());
        System.out.println("Perimeter of c2: " + c2.getPerimeter());
    }
}
