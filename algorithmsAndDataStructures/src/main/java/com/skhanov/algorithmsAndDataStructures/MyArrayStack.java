package com.skhanov.algorithmsAndDataStructures;

import java.util.NoSuchElementException;

public class MyArrayStack<E> {
	
	protected static int INITIAL_CAPACITY = 10;
	
	private int size;
	private Object[] stack;
	private int top = -1;
	
	public MyArrayStack() {
		size = 0;
		stack = new Object[INITIAL_CAPACITY];		
	}
	
	public MyArrayStack(int size) {
		this.size = size;
		stack = new Object[size * 2];		
	}
	
	private void resize(int capacity) {
		Object[] temp = new Object[capacity];
		for(int i = 0; i < size; i++) {
			temp[i] = stack[i];
		}
		stack = temp;		
	}
	
	@SuppressWarnings("unchecked")
	private E castE(Object o) {
		return (E) o;
	}
	
	public void push(E e) {
		if(size == stack.length) {
			resize(stack.length * 2);			
		}
		stack[++top] = e;
		size++;
	}
	
	public E pop() {
		if(isEmpty()) {
			throw new NoSuchElementException("Стек пуст");
		}
		E result = castE(stack[top--]);
		stack[top + 1] = null;
		size--;
		if(top == stack.length / 4) {
		resize(stack.length / 2);
	}		
		return result;		
	}
	
	public E peek() {
		return castE(stack[top]);
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	@Override
	public String toString() {
		String s = "" ;
		for (Object object : stack) {
			if(object != null) {
				s += castE(object) + ", ";
			}
		}
		return s;
	}
	
	public int size() {
		return size;
	}
	
}
