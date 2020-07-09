package session9_arrayList_and_linkedList.homeworks.linked_list;

import session9_arrayList_and_linkedList.practice.linked_list.MyLinkedList;

import java.util.Collections;
import java.util.List;

public class MyLinkedList2 {
    private Node head;
    private int numNodes;

    public MyLinkedList2() {}

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, Object element) {
        Node temp = head;
        Node backNode;
        for(int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        backNode = temp.next;
        temp.next = new Node(element);
        temp.next.next = backNode;
        numNodes++;
    }

    public void addFirst(Object obj) {
        Node temp = head;
        head = new Node(obj);
        head.next = temp;
        numNodes++;
    }

    public void addLast(Object obj) {
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(obj);
        numNodes++;
    }

    public Object remove(int index) {
        Node temp = head;
        Node holder = null;

        if(index < 0 || index > this.size()) holder = null;
        else if (index == 0) {
            holder = temp;
            head = temp.next;

        } else {

            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            holder = temp.next;
            temp.next = holder.next;

        }

        numNodes--;
        return holder;
    }

    public int size() {
        int count = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public MyLinkedList2 clone() {
        MyLinkedList2 newList = new MyLinkedList2();
        Node temp = head;
        newList.addFirst(temp);

        while(temp.next != null) {
            temp = temp.next;
            newList.addLast(temp);
        }

        return newList;
    }

    public boolean contains(Object obj) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == (new Node(obj)).data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(Object obj) {
        Node temp = head;
        int index = -1;
        for(int i = 0; temp != null; i++) {
            if (temp.data == (new Node(obj)).data) {
                index = i;
                break;
            }
            temp = temp.next;
        }
        return index;
    }

    public Object get(int index) {
        Node temp = head;
        for(int i = 0; i < index && temp != null; i++) {
            temp = temp.next;
        }
        System.out.println(temp.data);
        return temp;
    }



















    public void printList() {
        Node temp = head;
        String str = "";
        while(temp != null) {
            str += temp.data + "\n";
            temp = temp.next;
        }
        System.out.println(str);
    }


}
