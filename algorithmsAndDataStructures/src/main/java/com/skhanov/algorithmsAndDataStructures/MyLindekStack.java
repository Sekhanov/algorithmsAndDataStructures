package com.skhanov.algorithmsAndDataStructures;

import java.util.Iterator;

public class MyLindekStack<E> implements Iterable<E> {

	private MyTwoLinkedList<E> myTwoLinkedList = new MyTwoLinkedList<>();
	
	public void push(E e) {
		myTwoLinkedList.insertFirst(e);
	}
	
	public E pop() {
		return myTwoLinkedList.deleteFirst();
	}
	
	public E peek() {
		return myTwoLinkedList.get(0);
	}
	
	public int size() {
		return myTwoLinkedList.size();
	}
	
	public boolean isEmpty() {
		return myTwoLinkedList.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return myTwoLinkedList.iterator();
	}
	
	
}
