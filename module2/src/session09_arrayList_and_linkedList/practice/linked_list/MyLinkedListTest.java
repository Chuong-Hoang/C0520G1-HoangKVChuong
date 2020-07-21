package session09_arrayList_and_linkedList.practice.linked_list;

public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("--Testing MyLinkedList--");
        MyLinkedList myList = new MyLinkedList(10);
        myList.add(1, 1);
        myList.add(2, 2);
        myList.add(3, 5);
        myList.printList();
        System.out.println("----------");
        myList.add(3, 9);
        myList.printList();

        myList.addFirst(0);
        System.out.println();
        myList.printList();
        System.out.println();
        System.out.println("Element index 3: " + myList.get(3));
        System.out.println();
    }
}
