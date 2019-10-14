package com.skhanov.algorithmsAndDataStructures;


/**
 * MyLinkedListHashTable
 */
public class MyLinkedListHashTable<K, V> {

    private static final int INITIAL_SIZE = 10;
    private int size;
    private Object[] data;

    public MyLinkedListHashTable() {
        this.data = new Object[INITIAL_SIZE];
    }

    private class Node {
        private K k;
        private V v;
        private Node next;

        private Node(K k, V v, Node next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    private int hash(K k) {
        return (k.hashCode() & 0x7fffffff) % data.length;
    }

    @SuppressWarnings("unchecked")
    private Node cast(Object o){
        return (Node) o;
    }
    

    public void put(K k, V v) {
        if(k == null) {
            throw new IllegalArgumentException();
        }
        int hash = hash(k);
        Node tempNode = cast(data[hash]);
        while(tempNode != null) {
            if(tempNode.k.equals(k)) {
                tempNode.v = v;
            }
            tempNode = tempNode.next;
        }
        data[hash] = new Node(k, v, cast(data[hash]));
        size++;
    }

    public V get(K k) {
        if(k == null) {
            throw new IllegalArgumentException();
        }
        int hash = hash(k);
        Node tempNode = cast(data[hash]);
        while(tempNode != null) {
            if(tempNode.k.equals(k)) {
                return tempNode.v;
            }
            tempNode = tempNode.next;
        }
        return null;
    }
    
}