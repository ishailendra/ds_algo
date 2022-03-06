package tester;

import datastructure.DoublyLinkedList;
import datastructure.DynamicArray;
import datastructure.SinglyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {

        //dynamicArrayTester();
        singlyLinkedListTester();
        //doublyLinkedListTester();

    }

    private static void doublyLinkedListTester() {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.add(5);

        System.out.println(dll.toString());

        dll.addFront(0);
        System.out.println(dll.toString());

        dll.remove();
        System.out.println(dll.toString());

        dll.removeFront();
        System.out.println(dll.toString());

        dll.insert(1, 10);
        System.out.println(dll.toString());

        dll.reverse();
        System.out.println(dll.toString());
    }

    private static void singlyLinkedListTester() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();

        sll.add(1);
        sll.add(2);
        sll.add(3);
        sll.add(4);

        System.out.println(sll.toString());

        sll.addFront(0);

        System.out.println(sll.toString());
        System.out.println(sll.get(3));

        sll.remove();
        System.out.println(sll.toString());

        System.out.println(sll.removeFront());
        System.out.println(sll.toString());

        sll.insert(0, 10);
        System.out.println(sll.toString());

        sll.insert(3, 11);
        System.out.println(sll.toString());

        sll.reverse();
        System.out.println(sll.toString());

        sll.remove(11);
        System.out.println(sll.toString());
    }

    private static void dynamicArrayTester() {
        //Dynamic Array Test Code

        DynamicArray<Integer> dArr = new DynamicArray<>();
        for (int i = 0; i < 15; i++) {
            dArr.add(i);
        }
        System.out.println(dArr.size() + " " + dArr.toString());

        dArr.insert(25, 3);
        System.out.println(dArr.size() + " " + dArr.toString());

        dArr.remove();
        System.out.println(dArr.size() + " " + dArr.toString());

        dArr.remove(5);
        System.out.println(dArr.size() + " " + dArr.toString());

        dArr.remove((Integer) 25);
        System.out.println(dArr.size() + " " + dArr.toString());

        System.out.println("Size: " + dArr.size() + "Capacity: " + dArr.capacity() + " isEmpty: " + dArr.isEmpty() + " ");

        System.out.println(dArr.find(13) + " " + dArr.get(2));
    }
}
