package com.skhanov.algorithmsAndDataStructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

public class AppTest {
	
	@Test
	public void checkBracketsUtil() {
		assertTrue(Utils.checkBrackets("[(2 + 2){()}]"));
		assertFalse(Utils.checkBrackets("[(2 + 2){]"));
	}
	
	@Test
	public void stringReversUtil() {		
		assertEquals(null, "gfedcba", Utils.stringReverse("abcdefg"));
	}
	
	@Test
	public void factorialUtil() {
		assertTrue(3628800 == Utils.factorialRecursion(10));
	}
	
	@Test
	public void pow() {
		assertTrue(1024 == Utils.powRecurson(2, 10));
		assertTrue(2048 == Utils.powCicle(2, 11));
	}
	
	@Test
	public void recursionFindInList() {
		MySortedArray<Integer> mySortedArray = new MySortedArray<>();
		mySortedArray.add(4);
		mySortedArray.add(3);
		mySortedArray.add(7);
		mySortedArray.add(5);
		mySortedArray.add(12);
		mySortedArray.insertionSort();
		assertTrue(mySortedArray.find(3, 0, mySortedArray.size - 1));		
	}
	
	@Test
	public void BynarySearchTree() {
		MyBinarySearchTree<Integer, String> myBinarySearchTree = new MyBinarySearchTree<>();
		myBinarySearchTree.put(1, "1");
		myBinarySearchTree.put(2, "2");
		myBinarySearchTree.put(4, "4");	
		myBinarySearchTree.put(5, "5");	
		assertTrue(myBinarySearchTree.height() == 3);
		assertFalse(myBinarySearchTree.isBalanced());
		myBinarySearchTree.delete(5);
		myBinarySearchTree.delete(4);
		//TODO сокращение высоты при удалении
	}
	

}







