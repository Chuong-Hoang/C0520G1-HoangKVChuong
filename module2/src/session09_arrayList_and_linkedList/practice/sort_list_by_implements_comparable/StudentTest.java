package session9_arrayList_and_linkedList.practice.sort_list_by_implements_comparable;

import java.util.ArrayList;
import java.util.Collections;

public class StudentTest {
    public static void main(String[] args) {
        ArrayList myList = new ArrayList();

        myList.add(new Student(1, "Chuong", 32));
        myList.add(new Student(2, "Mai", 26));
        myList.add(new Student(3, "Hang", 35));
        myList.add(new Student(4, "Binh", 22));
        myList.add(new Student(5, "Binh", 33));
        myList.add(new Student(6, "Binh", 18));

        for(Object object : myList) {
            System.out.println(object);
        }

        System.out.println("After sort: ");
        Collections.sort(myList);

        for(Object object : myList) {
            System.out.println(object);
        }

    }

}
