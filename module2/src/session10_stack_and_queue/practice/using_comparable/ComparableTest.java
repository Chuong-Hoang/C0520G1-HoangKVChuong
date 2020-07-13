package session10_stack_and_queue.practice.using_comparable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

public class ComparableTest {
    public static void main(String[] args) {
        ArrayList<Person> myList = new ArrayList<>();
        myList.add(new Person("Chuong", 32, "male"));
        myList.add(new Person("Chung", 30, "male"));
        myList.add(new Person("Hong", 31, "female"));
        myList.add(new Person("Duy", 27, "male"));
        myList.add(new Person("Hang", 35, "female"));
        myList.add(new Person("Phuong", 22, "female"));

        Collections.sort(myList);

        //print myList by using normal for-i
        System.out.println("--- Using normal for-i ---");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
        System.out.println();

        //print myList by using for-each
        System.out.println("--- Using for-each ---");
        for(Person x : myList) {
            System.out.println(x);
        }
        System.out.println();

        //print myList by using Iterator interface
        System.out.println("--- Using Iterator --> iterator() ---");
        Iterator<Person> iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }

    }

}
