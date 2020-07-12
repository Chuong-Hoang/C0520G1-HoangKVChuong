package session10_stack_and_queue.homeworks.deploy_queue_using_doubly_linked_list;

import java.util.Collections;

public class MyQueue {
    private Node front;
    private Node rear;

    public MyQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enQueue(int data) {
        Node temp = new Node(data);
        if(this.rear == null) {
            this.front = this.rear = temp;
        } else {
            this.rear.link = temp;
            this.rear = temp;
        }
        this.rear.link = this.front;
    }

    public void deQueue() {
       if(this.front == null) {
           System.out.println("Queue is empty");
       } else {
           this.front = this.front.link;
           this.rear.link = this.front;
       }
    }

    public void displayQueue() {
        Node temp = this.front;

        while(temp.link != this.front) {
            System.out.println("Element: " + temp.data);
            temp = temp.link;
        }
        System.out.println("Element: " + this.rear.data);
    }

}

class Node {
    public int data;
    public Node link;

    public Node(int data) {
        this.data = data;
        this.link = null;

    }
}
