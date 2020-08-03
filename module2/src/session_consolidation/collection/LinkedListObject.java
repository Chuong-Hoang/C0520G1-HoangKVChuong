package session_consolidation.collection;
import java.util.*;

public class LinkedListObject {
    public static void main(String[] args) {
        List<Worker> myList = new LinkedList<>();
        Worker w1 = new Worker("Chuong", "F001", 32);
        Worker w2 = new Worker("Thanh", "F002", 30);
        Worker w3 = new Worker("Minh", "F003", 35);
        Worker w4 = new Worker("Anh", "F004", 22);
        Worker w5 = new Worker("Phuong", "F005", 25);
        Worker w6 = new Worker("Minh", "F006", 21);
        Worker w7 = new Worker("Minh", "F007", 38);

        myList.add(w1);
        myList.add(w2);
        myList.add(w3);
        myList.add(w4);
        myList.add(w5);
        myList.add(w6);
        myList.add(w7);

        Collections.sort(myList, Collections.reverseOrder());
        Iterator iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}
