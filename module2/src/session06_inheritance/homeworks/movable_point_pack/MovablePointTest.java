package session6_inheritance.homeworks.movable_point_pack;

public class MovablePointTest {
    public static void main(String[] args) {
        MovablePoint mp = new MovablePoint();
        System.out.println(mp.toString());

        mp.setSpeed(1,2);
        System.out.println(mp.toString());
        mp.move();
        System.out.println(mp.toString());
        mp.move();
        System.out.println(mp.toString());
        mp.setYSpeed(1);
        System.out.println(mp.toString());
        mp.move();
        System.out.println(mp.toString());
    }
}
