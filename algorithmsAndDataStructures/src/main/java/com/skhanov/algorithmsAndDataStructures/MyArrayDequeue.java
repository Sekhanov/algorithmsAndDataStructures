package com.skhanov.algorithmsAndDataStructures;

public class MyArrayDequeue<E> {

	private static final int INITIAL_CAPACITY = 10;

	private Object[] deque;
	private int tail;
	private int head;
	private int elementsCount;

	public MyArrayDequeue() {
		deque = new Object[INITIAL_CAPACITY];
		head = INITIAL_CAPACITY / 2 - 1;
		tail = head - 1;

	}

	private void resize(int capacity) {
		Object[] temp = new Object[capacity];
		for (int i = 0; i < elementsCount; i++) {
			temp[i] = deque[(head + i) % deque.length];
		}
		deque = temp;
		head = 0;
		tail = elementsCount - 1;

	}

	public void insertLeft(E e) {
		ensureCapacity();
		head--;
		dequeCicle();
		deque[head] = e;
		elementsCount++;
	}

	public void insertRight(E e) {
		ensureCapacity();
		tail++;
		dequeCicle();
		deque[tail] = e;
		elementsCount++;
	}
	
	private void ensureCapacity() {
		if (elementsCount == deque.length) {
			resize(deque.length * 2);
		}
		if (deque.length > INITIAL_CAPACITY && elementsCount == deque.length / 4) {
			resize(deque.length / 2);
		}
		
	}
	
	private void dequeCicle() {
		if(head < 0) head = deque.length - 1;
		if(head == deque.length) head = 0;
		if(tail < 0) tail = deque.length - 1;
		if(tail == deque.length) tail = 0;
		

	}

	public E removeLeft() {
		E result = castE(deque[head]);
		deque[head++] = null;
		dequeCicle();
		elementsCount--;
		ensureCapacity();
		return result;	
	}

	public E removeRight() {
		E result = castE(deque[tail]);
		deque[tail--] = null;
		dequeCicle();
		elementsCount--;
		ensureCapacity();
		return result;
	}

	public E getLeft() {
		return castE(deque[head]);
	}

	public E getRight() {
		return castE(deque[tail]);
	}

	@SuppressWarnings("unchecked")
	private E castE(Object object) {
		return (E) object;
	}
	
	@Override
	public String toString() {
			String result = "";
			for(int i = 0; i < elementsCount; i++) {
				result += castE(deque[(head + i) % deque.length]) + ", ";
			}
		return result;
	}

}
