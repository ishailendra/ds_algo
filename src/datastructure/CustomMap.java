package datastructure;

import java.util.ArrayList;
import java.util.Collections;
// Code refernce:
//https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/



//Class to represent entire hash table
public class CustomMap<K, V> {

    // A node of chains
    private static class HashNode<K, V> {
        K key;
        V value;
        final int hashCode;
        // Reference to next node
        HashNode<K, V> next;

        //Constructor
        public HashNode(K key, V value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }
    }

    // bucketArray is used to store array of chains
    private ArrayList<HashNode<K, V>> bucketArray;

    //Current capacity of array list
    private int numBuckets;

    //current size of arraylist
    private int size;

    public CustomMap () {
        this.bucketArray = new ArrayList<>();
        this.numBuckets = 10;
        this.size = 0;

        //Create empty chains
        for (int i = 0; i < numBuckets; i++) {
            bucketArray.add(null);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty () {
        return size == 0;
    }

    //This implements hash function to find index for a key
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        index = index < 0 ? index * -1 : index;
        return index;
    }

    // Method to remove a given key
    public V remove (K key) {
        //Apply hash function to find index for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = key.hashCode();

        //Get head of chain
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        //Search for key in its chain
        HashNode<K, V> prev = null;

        while( head != null) {
            //If key found
            if(head.key.equals(key) && hashCode == head.hashCode) {
                break;
            }

            //Else keep moving in chain
            prev = head;
            head = head.next;
        }

        //If key was not there
        if(head == null) {
            return null;
        }

        //Reduce size
        size--;

        //Remove key
        if(prev != null) {
            prev.next = head.next;
        }
        else {
            bucketArray.set(bucketIndex, head.next);
        }

        return head.value;
    }

    //Return value for a key
    public V get(K key) {
        //Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = key.hashCode();

        HashNode<K, V> head = bucketArray.get(bucketIndex);

        //Search key in chain
        while(head != null) {
            if(head.key.equals(key) && hashCode == head.hashCode) {
                return head.value;
            }
            head = head.next;
        }

        //If key not found
        return null;

    }

    //Adds a key value pair to hash
    public void put(K key, V value) {
        //Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = key.hashCode();
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        //Check if key is already present
        while(head != null) {
            if(head.key.equals(key) && hashCode == head.hashCode) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        //Insert key in chain

        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<>(key, value, hashCode);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        //If load factor goes beyond threshold, then double hash table size
        resizeHashTable();
    }

    private void resizeHashTable() {
        if((1.0 * size)/numBuckets >= 0.7) {
            ArrayList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;

            for (int i = 0; i < numBuckets; i++) {
                bucketArray.add(null);
            }
            for (HashNode<K,V> headNode: temp) {
                while(headNode != null) {
                    put(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
}