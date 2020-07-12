package session10_stack_and_queue.practice.deploy_stack_using_array;

public class MyStack {
    private int[] arr;
    private int size = 0;
    private int index = -1;

    public MyStack(int size) {
        arr = new int[size];
    }

    boolean isEmpty() {
        boolean status = false;
        if (size == 0) {
            status = true;
        }
        return status;
    }

    boolean isFull() {
        boolean status = false;
        if (size == arr.length) {
            status = true;
        }
        return status;
    }

    void push(int element) {
        if (isFull()) {
            System.out.println("Stack full! Cannot push element " + element);
        } else {

            arr[index+1] = element;
            index++;
            size++;
            System.out.println("Element " + element + " has been pushed to stack.");
        }
    }

    void pop() {
        if(isEmpty() || index < 0) {
            System.out.println("Stack empty! Cannot remove element.");
        } else {
            int temp = arr[index];
            arr[index] = 0;
            index--;
            size--;
            System.out.println("Element " + temp + " has been popped.");
        }
    }
}
