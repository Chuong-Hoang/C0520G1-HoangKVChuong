package session6_inheritance.practice;

public class SquareTest {
    public static void main(String[] args) {
        Shape s = new Square();
        System.out.println(s);
        s.setColor("violet");
        System.out.println(s.toString());
        System.out.println();

        Shape s2 = new Square(15);
        System.out.println(s2);
        s2.setColor("white");
        System.out.println(s2.toString());
        System.out.println();

        Square s3 = new Square("Bisque", false, 33);
        System.out.println(s3);
        s3.setSide(55);
        s3.setColor("Yellow");
        s3.setFilled(true);
        System.out.println(s3.toString());
        System.out.println();

        Shape s4 = new Square("Brown", true, 111);
        System.out.println(s4.toString());
        ((Square) s4).setSide(222);
        System.out.println(s4.toString());
    }
}
