package session7_abstract_interface.practice.interface_comparator;
import java.util.Arrays;
import session6_inheritance.homeworks.circle_pack.*;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circleList = new Circle[4];
        circleList[0] = new Circle();
        circleList[1] = new Circle(3.5);
        circleList[1].setColor("RED");
        circleList[2] = new Circle(0.5, "YELLOW");
        circleList[3] = new Circle(2.5, "WHITE");

        System.out.println("Before sort:");
        for(Circle c : circleList) {
            System.out.println(c);
        }

        CircleComparator circleComparator = new CircleComparator();
        Arrays.sort(circleList, circleComparator);


        System.out.println();
        System.out.println("After sort: ");
        for(Circle c : circleList) {
            System.out.println(c);
        }
    }
}
