package datastructure;

import java.util.Objects;

public class DoublyLinkedList<E> {

    private Node<E> head;
    private int size;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }

        Node(E item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public boolean add(E item) {
        Node<E> newNode = new Node<>(item);

        if(this.head == null) {
            this.head = newNode;
            size++;
            return true;
        }
        Node<E> temp = this.head;
        while(temp.next != null) {
            temp = temp.next;
        }
        newNode.prev = temp;
        temp.next = newNode;
        size++;
        return true;
    }

    public boolean addFront(E item) {
        Node<E> newNode = new Node<>(item);
        if(this.head == null) {
            this.head = newNode;
            size++;
            return true;
        }

        this.head = new Node<>(item, this.head, null);
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

        while(temp.next.next != null) {
            temp = temp.next;
        }
        E e = temp.next.item;
        temp.next = null;
        size--;
        return e;
    }

    public E removeFront() {
        if(this.head == null) {
            Objects.checkIndex(0, size);
        }

        Node<E> temp = this.head;
        E e = this.head.item;

        this.head = this.head.next;
        this.head.prev = null;
        size--;

        return e;
    }

    public boolean insert(int index, E e) {
        Objects.checkIndex(index, size);

        if(index == 0) {
            addFront(e);
        }

        Node<E> newNode = new Node<>(e);
        Node<E> temp = this.head;

        for (int i = 1; ; i++) {
            if(temp == null) {
                this.head = newNode;
                break;
            }

            if(i == index) {
                newNode.next = temp.next;
                temp.next.prev = newNode;
                newNode.prev = temp;
                temp.next = newNode;
                break;
            }

            temp = temp.next;
        }
        size++;
        return true;
    }

    public void reverse() {
        Node<E> temp = null;
        Node<E> current = this.head;
        /* swap next and prev for all nodes of
         doubly linked list */
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        /* Before changing head, check for the cases like
         empty list and list with only one node */
        if (temp != null) {
            this.head = temp.prev;
        }
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

