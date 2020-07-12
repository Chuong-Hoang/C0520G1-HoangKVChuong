package session10_stack_and_queue.practice.deploy_stack_using_array;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(999);

        System.out.println("------------");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
