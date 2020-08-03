package session_consolidation.collection;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListString {
    public static void main(String[] args) {
        List<String> myList = new LinkedList<>();

        myList.add("Hoang");
        myList.add("Loc");
        myList.add("Quang");
        myList.add("Binh");
        myList.add("Nguyen");
        myList.add("Uyen");
        myList.add("Dung");

        Collections.sort(myList, Collections.reverseOrder());
        Collections.reverse(myList);

        System.out.println("Using Iterator to traverse the List:");
        Iterator<String> iterator = myList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
