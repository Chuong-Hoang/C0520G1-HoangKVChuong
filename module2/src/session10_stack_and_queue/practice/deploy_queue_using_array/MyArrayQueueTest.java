package session10_stack_and_queue.practice.deploy_queue_using_array;

public class MyArrayQueueTest {
    public static void main(String[] args) {
        MyArrayQueue myQueue = new MyArrayQueue(4);
        myQueue.addQueue(999);
        myQueue.showQueue();
        myQueue.addQueue(5);
        myQueue.showQueue();
        myQueue.addQueue(6);
        myQueue.showQueue();
        myQueue.addQueue(7);
        myQueue.showQueue();
        myQueue.addQueue(333);
        myQueue.showQueue();

        System.out.println("-------------");
        myQueue.removeQueue();
        myQueue.showQueue();
        myQueue.removeQueue();
        myQueue.showQueue();
        myQueue.removeQueue();
        myQueue.showQueue();
        myQueue.removeQueue();
        myQueue.showQueue();
        myQueue.removeQueue();
        myQueue.showQueue();
    }
}
