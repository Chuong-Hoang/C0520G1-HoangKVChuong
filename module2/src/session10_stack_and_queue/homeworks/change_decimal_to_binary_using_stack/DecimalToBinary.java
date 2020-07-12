package session10_stack_and_queue.homeworks.change_decimal_to_binary_using_stack;
import java.util.Stack;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Input a decimal number: ");
        int number = myScanner.nextInt();

        Stack<Integer> myStack = new Stack<>();
        int modulo;
        int factor = number;
        String str = "";

        if (number == 0)  str += "00";
        else if (number == 1) str += "01";
        else {
            while (factor != 0) {
                modulo = factor % 2;
                myStack.push(modulo);
                factor = factor / 2;
            }

            while (!myStack.isEmpty()) {
                str += myStack.pop();
            }
        }
        System.out.println("Binary Number: " + str);
    }
}
