package datastructure;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class CustomStack_Array<E> {
    private int top;
    private int default_capacity = 10;

    private int capacity;

    private Object arr[];

    public CustomStack_Array() {
        this.top = -1;
        arr = new Object[default_capacity];
    }

    public boolean isEmpty() {
        return top<0;
    }

    public int size() {
        return top+1;
    }

    public boolean push(E e) {
        resize();
        arr[++top] = e;
        return true;
    }

    public E pop() {
        E e = (E) arr[top];
        arr[top--] = null;
        return e;
    }

    public E peek() {
        Objects.checkIndex(0, top);
        return (E) arr[0];
    }

    private void resize() {
        if(top+1 == arr.length) {
            capacity = 2*top;
            arr = Arrays.copyOf(arr, capacity);
        }
    }


    public String toString() {
        String str = "";
        for (int i = 0; i <= top; i++) {
            str += arr[i] + "  ";
        }
        return str;
    }
    public static void main(String[] args) {
        CustomStack_Array stack = new CustomStack_Array();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        System.out.println(stack.toString());

        stack.pop();
        System.out.println(stack.toString());

        System.out.println(stack.peek());

    }
}
