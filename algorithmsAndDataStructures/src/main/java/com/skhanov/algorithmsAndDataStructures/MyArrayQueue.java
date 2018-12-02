package com.skhanov.algorithmsAndDataStructures;

public class MyArrayQueue<E> {

	private static final int INITIAL_CAPACITY = 5;
	
	protected int size;
	protected int tail;
	protected int head;


	private Object[] queue;

	
	public MyArrayQueue() {
		queue = new Object[INITIAL_CAPACITY];
		head = 0;
		tail = -1;
		size = 0;


	}
	
	private void resize(int capacity) {
		Object[] tempArr = new Object[capacity];
		for(int i = 0; i < size; i++) {			
			tempArr[i] = queue[(head + i) % size];
		}
		queue = tempArr;
		head = 0;
		tail = size - 1;
		
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void insert(E e) {
		if(size == queue.length) resize(size * 2);
		if(tail == queue.length - 1) tail = -1;
		queue[++tail] = e;		
		size++;
	}
	
	public E remove() {		
		E result = castE(queue[head++]);	
		queue[head - 1] = null;
		if(head == queue.length -1) head = 0;
		size--;
		if(size == queue.length / 4) resize(size / 2);
		return  result;
	}
	
	@SuppressWarnings("unchecked")
	public E castE(Object o) {
		return (E) o;
	}
	
	public E peak() {
		return castE(queue[head]);
	}
	
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < size; i++) {
			int index = (head + i) % queue.length;
			result += castE(queue[index]) + ", ";
		}
		return result;
	}
	
}
