package session09_arrayList_and_linkedList.practice.linked_list;

public class MyLinkedList {
    private Node head;
    private int numNodes;

    //constructor of MyLinkedList class
    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    // relationship: MyLinkedList HAS-A class Node
    private class Node {
        private Node next;
        private Object data;

        //constructor of inner-class Node
        public Node(Object data) {
            this.data = data;
        }

        //method getData() of the inner-class Node
        public Object getData() {
            return this.data;
        }
    }

    //set add(index, object) method of outer class MyLinkedList
    public void add(int index, Object data) {
        Node temp = head;
        Node holder;

        for(int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    //set addFirst(Object data) method of outer class MyLinkedList
    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    //set get(int index) method of outer class MyLinkedList
    public Node get(int index) {
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //set printList() method of outer class MyLinkedList
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
