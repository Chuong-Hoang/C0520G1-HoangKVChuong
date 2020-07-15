package session9_arrayList_and_linkedList.homeworks.linked_list;

import org.w3c.dom.Node;
import session6_inheritance.homeworks.circle_pack.Circle;

public class MyLinkedList2Test {
    public static void main(String[] args) {
        MyLinkedList2 myList = new MyLinkedList2();
        System.out.println("Total elements: " + myList.size());
        myList.addFirst(3);
        myList.addFirst(5);
        myList.addFirst(7);
        myList.addFirst(9);
        myList.addFirst(11);
        myList.addFirst(new Circle(15, "red"));
        myList.addFirst(new Circle(40, "blue"));
        System.out.println("Total elements: " + myList.size());
        myList.printList();

        System.out.println("=============");
        System.out.println();
        myList.printList();
        System.out.println("index of 'ZZZ': " + myList.indexOf("ZZZ"));

        System.out.println(myList.contains(new Circle(15, "red")));
        System.out.println(myList.contains(new Circle(40, "blue")));
    }
}
