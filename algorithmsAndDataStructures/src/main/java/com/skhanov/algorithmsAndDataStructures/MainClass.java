package com.skhanov.algorithmsAndDataStructures;

import java.util.Queue;

public class MainClass {
	
	public static void main(String[] args) {

//		lesson2HW();	
		lesson3HW();
	}
	
	private static void lesson3HW() {
//			MyArrayStack<Integer> arrStack = new MyArrayStack<>();
//			arrStack.push(5);
//			arrStack.push(4);
//			arrStack.push(12);
//			System.out.println(arrStack);
//			System.out.println(arrStack.peek());
//			arrStack.pop();
//			arrStack.pop();
//			System.out.println(arrStack);;
//			arrStack.pop();
//			arrStack.pop();
//			
//			System.out.println(Utils.checkBrackets("[(2 + 2){}]"));
		
			MyArrayQueue<Integer> myArrayQueue = new MyArrayQueue<>();
			myArrayQueue.insert(1);
			myArrayQueue.insert(2);
			myArrayQueue.insert(3);
			myArrayQueue.insert(4);
			myArrayQueue.insert(5);
			myArrayQueue.remove();
			myArrayQueue.remove();
			myArrayQueue.remove();
			myArrayQueue.insert(6);
			myArrayQueue.insert(6);
			myArrayQueue.insert(6);
			myArrayQueue.insert(6);
			myArrayQueue.insert(6);
			System.out.println(myArrayQueue);

		}

	private static void lesson2HW() {	
		MySortedArray<Integer> sortedInt = new MySortedArray<>();		
		sortedInt.add(3);
		sortedInt.add(2);
		sortedInt.add(5);
		sortedInt.add(1);
		sortedInt.add(6);
		System.out.println("добавление с автоматической сортировкой: " + sortedInt );
		System.out.println("индекс элемента 3: " + sortedInt.find(3));
		
		
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
		System.out.println("insertion sort time: " + (System.currentTimeMillis() - startTime2));
	}
	
}
