package session10_stack_and_queue.practice.deploy_queue_using_linked_list;

public class MyLinkedListQueueTest {
    public static void main(String[] args) {
        MyLinkedListQueue queue = new MyLinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue();
        System.out.println("Dequeued item is: " + queue.dequeue().key);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        queue.dequeue();
        System.out.println("Dequeued item is: " + queue.dequeue().key);

    }
}
