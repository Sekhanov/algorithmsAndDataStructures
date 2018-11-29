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
	
	


}
