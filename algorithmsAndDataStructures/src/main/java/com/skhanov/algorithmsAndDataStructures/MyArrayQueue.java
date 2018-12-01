package com.skhanov.algorithmsAndDataStructures;

public class MyArrayQueue<E> {

	private static final int INITIAL_CAPACITY = 5;
	
	private int size;
	private int rearIndex;
	private int frontIndex;


	private Object[] queue;

	
	public MyArrayQueue() {
		queue = new Object[INITIAL_CAPACITY];
		frontIndex = 0;
		rearIndex = -1;
		size = 0;


	}
	
	private void resize(int capacity) {
		Object[] tempArr = new Object[capacity];
		for(int i = 0; i < size; i++) {			
			tempArr[i] = queue[(frontIndex + i) % size];
		}
		queue = tempArr;
		frontIndex = 0;
		rearIndex = size - 1;
		
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void insert(E e) {
		if(size == queue.length) resize(size * 2);
		if(rearIndex == queue.length - 1) rearIndex = -1;
		queue[++rearIndex] = e;		
		size++;
	}
	
	public E remove() {		
		E result = castE(queue[frontIndex++]);	
		queue[frontIndex - 1] = null;
		if(frontIndex == queue.length -1) frontIndex = 0;
		size--;
		if(size == queue.length / 4) resize(size / 2);
		return  result;
	}
	
	@SuppressWarnings("unchecked")
	public E castE(Object o) {
		return (E) o;
	}
	
	public E peak() {
		return castE(queue[frontIndex]);
	}
	
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < size; i++) {
			int index = (frontIndex + i) % queue.length;
			result += castE(queue[index]) + ", ";
		}
		return result;
	}
	
}
