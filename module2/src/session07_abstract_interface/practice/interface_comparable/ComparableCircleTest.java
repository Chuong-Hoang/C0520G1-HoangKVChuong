package session7_abstract_interface.practice.interface_comparable;
import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circleList = new ComparableCircle[3];
        circleList[0] = new ComparableCircle(3.5);
        circleList[1] = new ComparableCircle();
        circleList[1].setColor("Navy");
        circleList[2] = new ComparableCircle("Yellow", false,2.5);

        System.out.println("Before sort:");
        for(ComparableCircle c : circleList) {
            System.out.println(c);
        }

        Arrays.sort(circleList);
        System.out.println();

        System.out.println("After sort:");
        for(ComparableCircle c : circleList) {
            System.out.println(c);
        }

    }
}
