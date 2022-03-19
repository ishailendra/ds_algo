package datastructure;

import java.util.Stack;

public class CustomQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CustomQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int x) {

        stack1.push(x);
    }

    public int pop() {

        if (stack2.isEmpty() && stack1.isEmpty()) return -1;
        if (stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {

        if (stack2.isEmpty() && stack1.isEmpty()) return -1;
        if (stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }


    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);
        queue.push(7);
        queue.push(8);
        queue.push(9);
        queue.push(10);

        queue.pop();


    }
}
