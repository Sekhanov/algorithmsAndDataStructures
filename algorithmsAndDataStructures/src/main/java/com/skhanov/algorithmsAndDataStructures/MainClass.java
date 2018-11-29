package com.skhanov.algorithmsAndDataStructures;

public class MainClass {
	public static void main(String[] args) {
		lesson2HW();
	}
	
	private static void lesson2HW() {		
		MySortedArray<Integer> intList1 = new MySortedArray<>();	
		for (int i = 0; i < 100000; i++) {
			int random =(int) (Math.random() *1000);
			intList1.add(random);
		}		

		long startTime1 = System.currentTimeMillis();
		intList1.selectitioSort();
		System.out.println("selection sort time: " + (System.currentTimeMillis() - startTime1));
		
		MySortedArray<Integer> intList2 = new MySortedArray<>();	
		for (int i = 0; i < 100000; i++) {
			int random =(int) (Math.random() *1000);
			intList2.add(random);
		}	
		
		long startTime2 = System.currentTimeMillis();
		intList2.insertionSort();
		System.out.println("selection sort time: " + (System.currentTimeMillis() - startTime2));
	}
	
}
