package session6_inheritance.homeworks.movable_point_pack;

public class PointTest {
    public static void main(String[] args) {
        Point p = new Point();
        System.out.println("P: " + p.toString());

        p.setX(1);
        System.out.println("P: " + p);

        p.setXY(2, 4);
        System.out.println("P: " + p.toString());
    }
}
