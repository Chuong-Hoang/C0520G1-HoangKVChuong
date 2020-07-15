package session6_inheritance.homeworks.point_pack;

public class Point3DTest {
    public static void main(String[] args) {
        Point3D p1 = new Point3D();
        System.out.println("P1: " + p1);
        System.out.println();

        p1.setZ(2.0f);
        System.out.println("P1: " + p1.toString());

        p1.setXY(1.0f, 1.5f);
        System.out.println("P1: " + p1);
        System.out.println();

        p1.setXYZ(0.2f, 0.4f, 0.8f);
        System.out.println("P1: " + p1.toString());
        System.out.println();

        Point2D p2 = new Point3D(1.0f, 2.0f, 3.0f);
        System.out.println("P2: " + p2.toString());

        System.out.println("Z = " + ((Point3D) p2).getZ());

    }
}
