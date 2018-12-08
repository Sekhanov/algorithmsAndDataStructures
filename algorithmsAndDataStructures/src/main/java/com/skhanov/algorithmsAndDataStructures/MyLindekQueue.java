package com.skhanov.algorithmsAndDataStructures;

import java.util.Iterator;

public class MyLindekQueue<E> implements Iterable<E> {
	
	private MyTwoLinkedList<E> queue = new MyTwoLinkedList<>();
	
	public void enqueue(E e) {
		queue.insertLast(e);
	}
	
	public E dequeue() {
		return queue.deleteFirst();
	}
	
	public E peek() {
		return queue.get(0);
	}
	
	public int size() {
		return queue.size();
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {		
		return queue.iterator();
	}

}
