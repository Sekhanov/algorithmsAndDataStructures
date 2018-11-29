package com.skhanov.algorithmsAndDataStructures;

public class MySortedArray<E extends Comparable<E>> extends MyArrayList<E> {
	
	public void selectitioSort() {
		for (int i = 0; i < size - 1; i++) {
			for (int j = i; j > 0; j--) {
				if(castE(list[i]).compareTo(castE(list[j])) > 0) {
					exchange(i, j);
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
