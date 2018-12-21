package com.skhanov.algorithmsAndDataStructures;

public class LinearProbingHashTable<K, V> {

	private static final int INITIAL_CAPACITY = 97;
	private int size;
	private Object[] keys;
	private Object[] values;
	
	public LinearProbingHashTable() {
		keys = new Object[INITIAL_CAPACITY];
		values = new Object[INITIAL_CAPACITY];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean contains(K k) {
		return get(k) != null;
	}

	@SuppressWarnings("unchecked")
	public V get(K k) {
		if(keys == null) {
			throw new IllegalArgumentException();
		}
		for(int i = hash(k); keys[i] != null; i = (i + 1) % INITIAL_CAPACITY) {
			if(keys[i].equals(k)) {
				return (V) values[i];
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public void put(K k, V v) {
		if(k == null) {
			throw new IllegalArgumentException("Ключ не может иметь знаение null");
		}
		int i;
		for(i = hash(k); keys[i] != null; i = (i + 1) / INITIAL_CAPACITY) {
			if(((K) keys[i]).equals(k)) {
				values[i] = values;
				return;
			}
		}
		keys[i] = k;
		values[i] = v;
		size++;
	}

	private int hash(K k) {		
		return (k.hashCode() & Integer.MAX_VALUE) % keys.length;
	}
}
