package session06_inheritance.homeworks.point_pack;

public class Point2DTest {
    public static void main(String[] args) {
        Point2D p1 = new Point2D();
        System.out.println("Point 1: " + p1.toString());
        System.out.println();

        p1.setXY(2.5f, 4.7f);
        System.out.println("Point 1: " + p1);
    }
}
