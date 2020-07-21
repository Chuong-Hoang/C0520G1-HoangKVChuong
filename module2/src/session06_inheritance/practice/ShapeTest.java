package session06_inheritance.practice;

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("purple", false);
        System.out.println(shape);
    }
}
