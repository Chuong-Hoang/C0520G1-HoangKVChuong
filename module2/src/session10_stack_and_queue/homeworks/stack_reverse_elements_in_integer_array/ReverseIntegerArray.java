package session10_stack_and_queue.homeworks.stack_reverse_elements_in_integer_array;
import java.util.LinkedList;


public class ReverseIntegerArray {
    public static void main(String[] args) {
        LinkedList<Integer> myStack = new LinkedList<>();
        int[] myArr = {1, 3, 4, 2, 5, 9, 11, 23, 34, 18};

        System.out.println("Before reverse array:");
        for (int x : myArr) {
            myStack.push(x);
            System.out.print(x + " ");
        }

        // Reverse the array
        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = myStack.get(i);
        }
        System.out.println();

        System.out.println("After reverse array:");
        for (int x : myArr) {
            myStack.push(x);
            System.out.print(x + " ");
        }
    }

}
