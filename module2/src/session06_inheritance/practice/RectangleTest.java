package session06_inheritance.practice;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle();
        System.out.println(rec);
        System.out.println(rec.toString());
        System.out.println();

        Shape rec2 = new Rectangle(30, 10);
        System.out.println(rec2);
        System.out.println(rec2.toString());
        System.out.println();

        Rectangle rec3 = new Rectangle("blue", true, 50, 10);
        System.out.println(rec3);
        rec3.setWidth(100);
        System.out.println(rec3.toString());
        System.out.println();

    }
}
