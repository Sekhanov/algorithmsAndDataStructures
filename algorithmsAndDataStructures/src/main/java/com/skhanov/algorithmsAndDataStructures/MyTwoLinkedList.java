package com.skhanov.algorithmsAndDataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyTwoLinkedList<E> implements Iterable<E> {

	private class Node {
		private E e;
		private Node previous;
		private Node next;

		public Node(E e, Node previous, Node next) {
			this.e = e;
			this.previous = previous;
			this.next = next;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(this == obj) return true;
			if(obj == null) return false;
			if(!this.getClass().equals(obj.getClass())) {
				return false;
			}
			@SuppressWarnings("unchecked")
			Node node = (Node) obj;
			return this.e.equals(node.e);
		}
	}
	
	private class MyTwoLinkedListIterator implements Iterator<E> {
		
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			E result = current.e;
			current = current.next;
			return result;
		}
		
	}

	private int size;
	private Node first;
	private Node last;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void insertFirst(E e) {
		if (isEmpty()) {
			first = new Node(e, null, null);
			last = first;
		} else {
			Node newNode = new Node(e, null, first);
			first.previous = newNode;
			first = newNode;
		}
		size++;
	}

	public void insertLast(E e) {
		if(isEmpty()) {
			last = new Node(e, null, null);
			first = last;
		} else {
			 Node newNode = new Node(e, last, null);
			 last.next = newNode;
			 last = newNode;
		}
		size++;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyTwoLinkedListIterator();
	}
	
	public E deleteFirst() {
		E result = first.e;
		first = first.next;
		first.previous = null;
		return result;		
	}
	
	public E deleteLast() {
		E result = last.e;
		last = last.previous;
		last.next = null;
		return result;
	}
	
	public boolean delete(E e) {
		Node current = first;
		while(current != null && !current.e.equals(e)) {
			current = current.next;
			if(current == null) return false;
		}
		current.previous.next = current.next;
		current.next.previous = current.previous;
		current.previous = null;
		current.next = null;
		size--;
		
		return true;
	}
	
	public boolean find(E e) {
		Node current = first;
		while(current != null && !current.e.equals(e)) {
			current = current.next;			
		}
		return current != null;
		
	}
	
}
