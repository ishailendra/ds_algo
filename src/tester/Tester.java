package tester;

import datastructure.CustomMap;
import datastructure.DoublyLinkedList;
import datastructure.DynamicArray;
import datastructure.SinglyLinkedList;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Tester {
    public static void main(String[] args) {

        //dynamicArrayTester();
        //singlyLinkedListTester();
        //doublyLinkedListTester();
        //test();
        //testCustomMap();

        long start1 = System.nanoTime();
        factorialRecursion(100);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        factorialIteration(100);
        long end2 = System.nanoTime();

        System.out.println("Recursion: " + (end1-start1)+ "\nIteration: "+ (end2-start2));
    }

    private static void test() {
        Map<Integer, String> hashTable = new Hashtable<>();
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
        sll.add(5);

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

    private static void testCustomMap() {
        CustomMap<String, Integer> map = new CustomMap<>();
        map.put("this", 1);
        map.put("coder", 2);
        map.put("this", 4);
        map.put("hi", 5);
        System.out.println(map.size());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }

    private static int factorialRecursion(int n) {
        if(n == 1 || n == 0) {
            return 1;
        }
        return n * factorialRecursion(n-1);
    }

    private static int factorialIteration(int n) {
        int factorial = 1;
        while(n>0) {
            factorial *= n;
            n--;
        }
        return factorial;
    }

}
