package session10_stack_and_queue.practice.deploy_queue_using_array;
import java.util.Arrays;

public class MyArrayQueue {
    private int capacity;
    private int[] queueArr;
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;

    public MyArrayQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[this.capacity];
    }

    public boolean isQueueFull() {
        boolean status = false;
        if(currentSize == capacity) {
            status = true;
        }
        return status;
    }

    public boolean isQueueEmpty() {
        boolean status = false;
        if(currentSize == 0) {
            status = true;
        }
        return status;
    }

    void addQueue(int item) {
        if(isQueueFull()) {
            System.out.println("Overflow! Unable to add element: " + item);
        } else {
            tail++;
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Element " + item + " is pushed to Queue.");
        }
    }

    void removeQueue() {
        if(isQueueEmpty()) {
            System.out.println("Underflow! Unable to remove element from Queue!");
        } else {
            head++;
            System.out.println("Pop operation done. Element " + queueArr[head - 1] + " removed.");
            queueArr[head - 1] = 0;
            currentSize--;
        }
    }

    void showQueue() {
        for(int x : queueArr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
