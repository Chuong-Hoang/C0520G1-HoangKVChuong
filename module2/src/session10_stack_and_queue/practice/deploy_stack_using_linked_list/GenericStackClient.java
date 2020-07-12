package session10_stack_and_queue.practice.deploy_stack_using_linked_list;

public class GenericStackClient {
    private static void stackOfStrings() {
        MyGenericStack<String> stack = new MyGenericStack<>();
        stack.push("Five");
        stack.push("Four");
        stack.push("Three");
        stack.push("Two");
        stack.push("One");
        System.out.println("1.Size of stack after push operation: " + stack.size());
        System.out.println("2.Pop elements from stack:");
        while (!stack.isEmpty()) {
            System.out.printf(" %s" + "\n", stack.pop());
        }
        System.out.println("3.Size of stack after pop operation: " + stack.size());
    }

    private static void stackOfInteger() {
        MyGenericStack<Integer> stack = new MyGenericStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("1.Size of stack before push operation: " + stack.size());
        System.out.println("2.Pop elements from stack:");
        while(!stack.isEmpty()) {
            System.out.printf("Pop element: %s" + "\n", stack.pop());
        }
        System.out.println("3.Size of stack after pop operation: " + stack.size());
    }

    public static void main(String[] args) {
        System.out.println("--Stack of String--");
        stackOfStrings();
        System.out.println();
        System.out.println("--Stack of Integer--");
        stackOfInteger();
    }
}
