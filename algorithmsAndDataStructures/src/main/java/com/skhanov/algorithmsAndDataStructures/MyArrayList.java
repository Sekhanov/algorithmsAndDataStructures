package com.skhanov.algorithmsAndDataStructures;

public class MyArrayList<E> {
	
	private static int INITIAL_CAPACITY = 10;
	
	private Object[] list;
	private int size;
	
	public MyArrayList() {
		this.list = new Object[INITIAL_CAPACITY];
		this.size = 1;
	}
	
	public MyArrayList(int size) {
		this.list = new Object[size];
		this.size = size;
		
	}	
	
	public int size() {
		return size;
	}
	
	public void add(E e) {
		ensureCapacity(++size);
		list[size] = e;
	}

	private void ensureCapacity(int size) {
		if(size == list.length) {
			resize(2 * list.length);
		}
		if(size == list.length / 4 && size > 0) {
			size = list.length / 2;
			resize(list.length / 2);
		}
		
	}

	private void resize(int newSize) {
		Object[] tempArr = new Object[newSize];
		for(int i = 0; i < size; i++) {
			tempArr[i] = list[i];
		}
		list = tempArr;
		
	}
	
	public boolean delete(E e) {
		boolean result = false;
		for(int i = 0; i < size; i++) {
			if(list[i].equals(e)) {
				while(i < size -1) {
					list[i] = list[i + 1];
				}
				list[size - 1] = null;
				size--;
			}
		}
		ensureCapacity(size);
		return result;		
	}
	
    public boolean find(E e) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
    
    
}
