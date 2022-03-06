package datastructure;

import java.util.*;

public class SinglyLinkedList<E> {

    private Node<E> head;
    private int size = 0;

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E item) {
            this.item = item;
            this.next = null;
        }

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> temp = this.head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.item;
    }

    public boolean add(E item) {
        Node<E> newNode = new Node<>(item);
        if (this.head == null) {
            this.head = newNode;
            size++;
            return true;
        }

        Node<E> temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;

        size++;
        return true;
    }

    public boolean addFront(E item) {
        this.head = new Node<>(item, this.head);
        size++;
        return true;
    }

    public E remove() {
        if (this.head == null) {
            Objects.checkIndex(0, size);
        }
        else if(this.head.next == null) {
            size--;
            return null;
        }
        Node<E> temp = this.head;

        while (temp.next.next != null) {
            temp = temp.next;
        }
        E e = temp.item;
        temp.next = null;
        size--;
        return e;
    }

    public E removeFront() {
        if (this.head == null) {
            Objects.checkIndex(0, size);
        }
        E e = this.head.item;
        this.head = this.head.next;
        size--;
        return e;
    }

    public void remove(E e) {
        Node<E> temp = head;
        while(head != null && head.item == e){
            head = head.next;
        }
        while(temp != null && temp.next != null) {
            if(temp.next.item == e) {
                temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
            }
        }

//        return head;
    }

    public boolean insert(int index, E e) {
        Objects.checkIndex(index, size);

        if (index == 0) {
            addFront(e);
        }
        Node<E> newNode = new Node<>(e);
        Node<E> temp = this.head;

        for (int i = 1; ; i++) {
            if (temp == null) {
                break;
            }
            if (i == index) {
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        size++;
        return true;
    }

    public void reverse() {
        Node<E> previous = null;
        Node<E> current = this.head;
        Node<E> forward;

        while (current != null) {
            forward = current.next;
            current.next = previous;
            previous = current;
            current = forward;
        }

        this.head = previous;
    }

    @Override
    public String toString() {
        if (this.head == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node<E> temp = this.head;

        while (temp != null) {
            sb.append(temp.item + ", ");
            temp = temp.next;
        }

        return sb.toString().substring(0, sb.length() - 2) + "]";
    }

}

