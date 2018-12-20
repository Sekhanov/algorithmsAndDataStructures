package com.skhanov.algorithmsAndDataStructures;

public class ChainingHashTable<K, V> {
	
	private static final int INITIAL_CAPACITY = 97;
	private Object[] keyHashTable = new Object[INITIAL_CAPACITY];
	private int size;

	private class Node {
		private K k;
		private V v;
		private Node next;
		
		
		public Node(K k, V v, Node next) {
			this.k = k;
			this.v = v;
			this.next = next;
		}		
	}
	
	// & 0x7fffffff - расчет по модулю (старший бит отвечающий за знак всегда будет 0)
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % INITIAL_CAPACITY;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public V get(K k) {
		if(k == null) {
			throw new IllegalArgumentException("Значение ключа не може быть null");
		}
		int i = hash(k);
		@SuppressWarnings("unchecked")
		Node node = (Node) keyHashTable[i];
		while(node != null) {
			if(node.k.equals(k)) {
				return node.v;
			}
			node = node.next;
		}
		return null;
		
	}
	
	public boolean contains(K k) {
		return get(k) != null;
	}
	

	
	public void put(K k, V v) {
		if(k == null) {
			throw new IllegalArgumentException("Значение ключа не может быть null");			
		}
		int i = hash(k);
		@SuppressWarnings("unchecked")
		Node node = (Node) keyHashTable[i];
		while(node != null) {
			if(node.k.equals(k)) {
				node.v = v;
				return;
			}
			node = node.next;
		}
		keyHashTable[i] = new Node(k, v, node);
		size++;
	}	
	
	public V delete(K k) {
		if(k == null) {
			throw new IllegalArgumentException("Значение ключа не может быть null");
		}
		int i = hash(k);
		@SuppressWarnings("unchecked")
		Node node = (Node) keyHashTable[i];
		if(node != null) {
			if(node.k.equals(k)) {
				node = node.next;
				
			}
		}
		return null;
		
		
	}


}
