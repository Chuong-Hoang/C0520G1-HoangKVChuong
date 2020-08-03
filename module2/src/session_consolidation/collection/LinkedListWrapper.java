package session_consolidation.collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListWrapper {
    public static void main(String[] args) {
        List<Integer> myList = new LinkedList<>();

        myList.add(6);
        myList.add(77);
        myList.add(14);
        myList.add(8);
        myList.add(35);
        myList.add(22);
        myList.add(1);

        Collections.sort(myList, Collections.reverseOrder());
        System.out.println("Use Iterator to traverse List");
        Iterator<Integer> iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
