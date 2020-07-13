package session10_stack_and_queue.homeworks.check_palindrome_using_queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {

        Scanner newScanner = new Scanner(System.in);

        System.out.print("Input a string: ");
        String input = newScanner.nextLine().toLowerCase();

        System.out.println("Check Palindrome: " + isPalindromeString(input));
    }

    public static boolean isPalindromeString(String input) {
        Stack newStack = new Stack();
        Queue newQueue = new LinkedList();
        Character sym;
        boolean isTheSame = false;
        for (int i = 0; i < input.length(); i++) {
            sym = input.charAt(i);
            newStack.push(sym);
            newQueue.offer(sym);
        }

        for (int i = 0; i < input.length(); i++) {
            isTheSame = newStack.pop().equals(newQueue.poll());
            if(!isTheSame) break;
        }
        return isTheSame;
    }
}
