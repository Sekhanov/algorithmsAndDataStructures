package com.skhanov.algorithmsAndDataStructures;

public class MyArrayList<E> {
	
	protected static int INITIAL_CAPACITY = 10;
	
	protected Object[] list;
	protected int size;
	
	public MyArrayList() {
		this.list = new Object[INITIAL_CAPACITY];
		this.size = 0;
	}
	
	public MyArrayList(int size) {
		this.list = new Object[size];
		this.size = size;
		
	}		

	@SuppressWarnings("unchecked")
	protected E castE(Object o) {
		return (E) o;
	}
	
	public int size() {
		return size;
	}
	
	public void add(E e) {
		ensureCapacity();
		list[size++] = e;
		
	}

	private void ensureCapacity() {
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
	
	public boolean remove(E e) {
		boolean result = false;
		for(int i = 0; i < size; i++) {
			if(list[i].equals(e)) {
				while(i < size - 1) {
					list[i] = list[i + 1];
				}
				list[size - 1] = null;
				size--;
			}
		}
		ensureCapacity();
		return result;		
	}
	
    public int find(E e) {
    	int result = 0;
        for (int i = 0; i < size; i++) {
            if (list[i].equals(e)) {
                result =  i;
            }
        }
        return result;
    }
        
    @Override
    public String toString() {
    	String result = "";
    	for (int i = 0; i < size; i++) {
    		if(i == size -1) {
    			result += list[i];
    		} else {
    			result += list[i] + ", ";
			}
		}
    	return result;
    }
    
 	public E get(int index) {    	
    	checkArrBounds(index);
    	return castE(list[index]);    	
    }

	private void checkArrBounds(int index) {
		if(index < 0 || index > size -1) {
    		throw new IndexOutOfBoundsException();
    	}
	}    
	

	public E set(int index, E element) {
    	checkArrBounds(index);
    	E result = castE(list[index]);
    	list[index] = element;
    	return result;
    }
    
}
