package com.skhanov.algorithmsAndDataStructures;

public class MySortedArray<E extends Comparable<E>> extends MyArrayList<E> {
	
	public void selectitioSort() {
		for (int i = 0; i < size - 1; i++) {
			int min = i;
			for(int j = i + 1; j < size; j++) {
				if(castE(list[i]).compareTo(castE(list[j])) > 0) {
					exchange(min, j);
				}
			}
		}
	}
	
	public void insertionSort() {
		for(int i = 0; i < size; i++) {
			for(int j = i; j > 0; j--) {
				if(castE(list[j]).compareTo(castE(list[j - 1])) < 0) {
					exchange(j, j - 1);
				} else {
					break;
				}
			}
		}
	}

	private void exchange(int i, int j) {
		E temp = castE(list[i]);
		list[i] = list[j];
		list[j] = temp;
		
	}

	@Override
	public void add(E e) {		
		super.add(e);
		int i = this.size() - 1;
		while(i > 0 && get(i).compareTo(get(i - 1)) < 0) {
			exchange(i, i - 1);
			i--;
		}
		
	}
	
	
	
	@Override
	public int find(E e) {		
		int low = 0;
		int high = size - 1;
		while(low <= high) {
			int mid = low + (high -  low) / 2;
			if(e.compareTo(castE(list[mid])) > 0) {
				low = mid + 1;
			} else if(e.compareTo(castE(list[mid])) < 0) {
				high = mid - 1;
			} else {
				return mid;
			}			
		}
		return 0;
	}
	
	public boolean find(E e, int low, int high) {
		if(low > high) return false;
		int mid = low + (high - low) / 2;
		if(e.compareTo(castE(list[mid])) == 0) {
			return true;
		} else if(e.compareTo(castE(list[mid])) > 0) {
			return find(e, mid + 1, high);
		} else {
			return find(e, low, mid - 1);
		}		
	}


}
