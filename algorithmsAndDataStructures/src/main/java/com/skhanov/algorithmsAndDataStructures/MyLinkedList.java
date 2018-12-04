package com.skhanov.algorithmsAndDataStructures;

public class MyLinkedList<E> {
	
	private static class Node<E> {
		private E e;
		private Node<E> next;
		
		private Node(E e) {
			this.e = e;			
		}
		
		private boolean isNext() {
			return next != null;
		}		
			
		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj) {
			Node<E> eqNode = (Node<E>) obj;
			return this.e.equals(eqNode.e);
		}
		
		@Override
		public String toString() {			
			return e.toString();
		}
		
	}
	
	private Node<E> current;
	
	public boolean isEmpty() {
		return current == null;
	}
	
	public void insert(E e) {
		Node<E> temp = new Node<E>(e);
		temp.next = current;
		current = temp;
	}
	
	public boolean delete(E e) {
		boolean result = false;
		Node<E> deletedNode = new Node<E>(e);
		Node<E> temoNode = current;
		while(temoNode.isNext()) {
			if(current.equals(deletedNode)) {
				current = current.next;
				result = true;
				break;
			}
			if(temoNode.next.equals(deletedNode)) {
				temoNode.next = temoNode.next.next;
				result = true;
				break;
			}
			temoNode = temoNode.next;
		}
		
		return result;
	}
	
	
	@Override
	public String toString() {
		String result = "";
		Node<E> tempNode = current;
		while(tempNode != null) {
			if(tempNode.isNext()) {
				result += tempNode.e + ", ";
				tempNode = tempNode.next;
			} else {
				result +=  tempNode.e;
				tempNode = tempNode.next;
			}
		}
		return result;
	}
	
}
