package session07_abstract_interface.practice.interface_comparator;
import session06_inheritance.homeworks.circle_pack.*;

import java.util.Comparator;

// class CircleComparator implements Interface Comparator
public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle c1, Circle c2) {
        if(c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }
}
