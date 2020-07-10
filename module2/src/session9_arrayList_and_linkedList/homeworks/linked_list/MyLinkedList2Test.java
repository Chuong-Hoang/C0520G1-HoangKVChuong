package session9_arrayList_and_linkedList.homeworks.linked_list;

import org.w3c.dom.Node;

public class MyLinkedList2Test {
    public static void main(String[] args) {
        MyLinkedList2 myList = new MyLinkedList2();
        System.out.println("Total elements: " + myList.size());
        myList.addFirst(3);
        myList.addFirst(5);
        myList.addFirst(7);
        myList.addFirst(9);
        myList.addFirst(11);
        System.out.println("Total elements: " + myList.size());
        myList.printList();

        myList.addLast(100);
        System.out.println("Total elements: " + myList.size());
        myList.printList();

        myList.add(3, "ZZZ");
        myList.printList();
        System.out.println("Total elements: " + myList.size());

        System.out.println();
        System.out.println("After clone:");
        MyLinkedList2 newList = myList.clone();
        newList.printList();

        System.out.println();
        System.out.println(myList.contains("ZZZ"));
        System.out.println();
        myList.printList();
        System.out.println("index of 'ZZZ': " + myList.indexOf("ZZZ"));
        myList.get(6);
        myList.get(0);
        System.out.println();

        myList.remove(0);
        myList.printList();
        System.out.println(myList.remove(5));
        System.out.println();
        myList.printList();
    }
}
