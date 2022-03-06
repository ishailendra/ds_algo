package datastructure;

// Implementing ArrayList

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DynamicArray<E> {

    private static final int defaultCapacity = 10;
    private int size = 0;
    private Object[] arr;
    private int capacity;

    public DynamicArray(){
        arr = new Object[defaultCapacity];
    }

    /***
     * Add a new value in dynamic array
     * @param e value to be added
     * @return true after adding a value
     */
    public boolean add(E e) {
        resize();
        arr[size] = e;
        size++;
        return true;
    }

    private void resize() {
        if(size == arr.length) {
            capacity = 2*size;
            arr = Arrays.copyOf(arr, capacity);
        }
    }

    public int size() {
        return size;
    }

    /***
     * Remove an element from the end in dynamic array
     * @return
     */
    public E remove () {
        E oldValue = (E) arr[size-1];
        arr[size-1] = null;
        size--;
        return oldValue;
    }

    public E remove(int index) {
        E oldValue = (E) arr[index];
        fastRemove(index);
        return  oldValue;
    }

    private void fastRemove(int index) {
        int newSize = size - 1;
        if(newSize > 1)
            System.arraycopy(arr, index +1, arr, index, size-1- index);
        arr[newSize] = null;
        size = newSize;
    }

    public int remove (Object o) {
        int i = getIndex(o);
        fastRemove(i);
        return i;
    }

    private int getIndex(Object o) {
        int i = 0;
        if(o == null){
            for(; i<arr.length; i++){
                if(arr[i] == null) {
                    break;
                }
            }
        }
        else {
            for(; i<arr.length; i++){
                if(arr[i].equals(o)) {
                    break;
                }
            }
        }
        return i;
    }

    public int capacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        return (E)arr[index];
    }

    public boolean insert(Object o, int index) {
        Objects.checkIndex(index, size);
        fastAdd((E) o, index);
        return true;
    }

    private void fastAdd(E o, int index) {
        Objects.checkIndex(index, size);
        resize();
        System.arraycopy(arr, index, arr, index +1, size- index);
        arr[index] = o;
        size++;
    }

    public boolean prepend(Object o) {
        Objects.checkIndex(0, size);
        fastAdd((E) o, 0);
        return true;
    }

    public int find(Object o) {
        return getIndex(o);
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[");
        for(int i = 0; i<size; i++){
            strBuilder.append(arr[i]+", ");
        }
        String arrString = strBuilder.toString();
        arrString = arrString.substring(0, arrString.length()-2) + "]";
        return  arrString;
    }
}
