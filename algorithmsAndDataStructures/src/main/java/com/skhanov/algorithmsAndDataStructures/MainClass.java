package com.skhanov.algorithmsAndDataStructures;

public class MainClass {
	
	public static void main(String[] args) {

//		lesson2HW();	
//		lesson3HW();
//		lesson4HW();
		lesson5HW();
	}
	
	private static void lesson5HW() {
//		System.out.println(Utils.factorialRecursion(10));
//		System.out.println(Utils.fibonacchiRecursion(10));
//		System.out.println(Utils.powCicle(2, 10));
//		System.out.println(Utils.powRecurson(2, 10));
		Utils.hanoiRec(2, 'A', 'B', 'C');
		
	}

	private static void lesson4HW() {
		System.out.println("MyLinkedList");
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
		myLinkedList.insert(1);
		myLinkedList.insert(2);
		myLinkedList.insert(3);
		myLinkedList.insert(4);
		myLinkedList.insert(5);
		System.out.println(myLinkedList);
		myLinkedList.delete(4);
		myLinkedList.delete(5);
		System.out.println(myLinkedList);
		
		
		System.out.println("MyTwoLinkedList");
		MyTwoLinkedList<Integer> myTwoLinkedList = new MyTwoLinkedList<>();
		myTwoLinkedList.insertFirst(3);
		myTwoLinkedList.insertFirst(4);
		myTwoLinkedList.insertFirst(5);
		myTwoLinkedList.insertFirst(6);
		myTwoLinkedList.insertLast(1);
		myTwoLinkedList.insertLast(2);
		myTwoLinkedList.forEach(e -> System.out.print(e + " "));
		System.out.println();
		System.out.println(myTwoLinkedList.get(2));
		System.out.println(myTwoLinkedList.set(2, 555));
		System.out.println(myTwoLinkedList.delete(3));
		myTwoLinkedList.forEach(e -> System.out.print(e + " "));
		myTwoLinkedList.insert(3, 333);
		System.out.println();
		myTwoLinkedList.forEach(e -> System.out.print(e + " "));
		
		System.out.println("MyLinkedList");
		MyLindekQueue<Integer> myLindekQueue = new MyLindekQueue<>();
		myLindekQueue.enqueue(1);
		myLindekQueue.enqueue(2);
		myLindekQueue.enqueue(3);
		myLindekQueue.enqueue(4);
		myLindekQueue.forEach(e -> System.out.print(e + " "));
		myLindekQueue.dequeue();
		myLindekQueue.dequeue();
		System.out.println();
		myLindekQueue.forEach(e -> System.out.print(e + " "));
		System.out.println();
		
		
		System.out.println("myLindekStack");
		MyLindekStack<Integer> myLindekStack = new MyLindekStack<>();
		myLindekStack.push(1);
		myLindekStack.push(2);
		myLindekStack.push(3);
		myLindekStack.push(4);
		myLindekStack.forEach(e -> System.out.print(e + " "));
		myLindekStack.pop();
		myLindekStack.pop();
		System.out.println();
		myLindekStack.forEach(e -> System.out.print(e + " "));
		
	}

	private static void lesson3HW() {
			MyArrayStack<Integer> arrStack = new MyArrayStack<>();
			arrStack.push(5);
			arrStack.push(4);
			arrStack.push(12);
			System.out.println("arrStack: " + arrStack);
			System.out.println(arrStack.peek());
			arrStack.pop();
			arrStack.pop();
			System.out.println("arrStack: " + arrStack);;	
			
			System.out.println("checkBrackets1 "  + Utils.checkBrackets("[(2 + 2){}]"));
			System.out.println("checkBrackets2 "  + Utils.checkBrackets("[(2 + 2){()}]"));
			System.out.println("checkBrackets3 "  + Utils.checkBrackets("[(2 + 2){]"));
		
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
			System.out.println("myArrayQueue " + myArrayQueue);
		
		System.out.println("String revers with stack - " + Utils.stringReverse("1234567890abcdefg"));
		
		MyArrayDequeue<Integer> intDeq = new MyArrayDequeue<>();
		intDeq.insertRight(444);
		intDeq.insertRight(333);
		intDeq.insertLeft(1);
		intDeq.insertLeft(2);
		intDeq.insertLeft(3);
		intDeq.insertLeft(4);
		intDeq.insertLeft(5);
		intDeq.insertLeft(6);
		intDeq.insertLeft(7);
		intDeq.insertLeft(8);
		intDeq.insertLeft(9);
		intDeq.insertLeft(10);
		intDeq.insertRight(555);
		intDeq.insertRight(555);
		intDeq.insertRight(555);
		System.out.println("intDeq: "  + intDeq);
		intDeq.removeLeft();
		intDeq.removeRight();
		intDeq.removeRight();
		intDeq.removeLeft();
		intDeq.removeLeft();
		intDeq.removeLeft();
		intDeq.removeRight();
		intDeq.removeRight();
		intDeq.removeRight();
		intDeq.removeRight();
		intDeq.removeRight();
		intDeq.removeRight();
		System.out.println("intDeq: "  + intDeq);
		
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
