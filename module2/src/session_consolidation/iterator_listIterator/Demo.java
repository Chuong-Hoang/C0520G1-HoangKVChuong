package session_consolidation.iterator_listIterator;
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        Iterator iterator = list.iterator();
        System.out.println("List traversal with Iterator");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        ListIterator<Integer> listIterator = list.listIterator();
        System.out.println("List forward traversal with ListIterator");
        while (listIterator.hasNext()) {
            System.out.println(listIterator.nextIndex() + ". " + listIterator.next());
        }
        System.out.println();

        System.out.println("List backward traversal with ListIterator");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previousIndex() + ". " + listIterator.previous());
        }

        //ListIterator can only use for List
        //Iterator can use for all collection framework(List, Set, Queue, Map)
        Map<Integer, String> myMap = new TreeMap<>();

        myMap.put(1, "Hello");
        myMap.put(2, "Goodbye");
        myMap.put(3, "Good afternoon");
        myMap.put(4, "Good evening");
        myMap.put(5, "Good morning");

        System.out.println("Iterator for Map traversal");
        Iterator iterator1 = myMap.keySet().iterator();
        while (iterator1.hasNext()) {
            System.out.println(myMap.get(iterator1.next()));
        }
    }
}
