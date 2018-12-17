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
	public void bynarySearchTree() {
		MyBinarySearchTree<Integer, String> myBinarySearchTree = new MyBinarySearchTree<>();
		myBinarySearchTree.put(1, "1");
		myBinarySearchTree.put(2, "2");
		myBinarySearchTree.put(4, "4");	
		myBinarySearchTree.put(5, "5");	
		assertTrue(myBinarySearchTree.height() == 4);
		assertFalse(myBinarySearchTree.isBalanced());
		myBinarySearchTree.delete(1);
		myBinarySearchTree.delete(5);
		assertTrue(myBinarySearchTree.isBalanced());		
		
		MyBinarySearchTree<Integer, String> myBinarySearchTree2 = new MyBinarySearchTree<>();
		myBinarySearchTree2.put(3, "3");
		myBinarySearchTree2.put(1, "1");
		myBinarySearchTree2.put(4, "4");	
		myBinarySearchTree2.put(5, "5");	
		myBinarySearchTree2.put(2, "2");
		myBinarySearchTree2.delete(1);
		myBinarySearchTree2.delete(5);
		assertTrue(myBinarySearchTree2.height() == 2);
	}
	
	
//	0 --- 1 ---- 2    6
//	|            |	
//	3---- 4 ---- 5	
	@Test
	public void graphDfs() {
		Graph graph = new Graph(7);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(2, 5);
		graph.addEdge(5, 4);
		graph.addEdge(4, 3);
		DepthFirstPath depthFirstPath = new DepthFirstPath(graph, 0);
		assertTrue(depthFirstPath.hasPathTo(5));
		assertFalse(depthFirstPath.hasPathTo(6));	
		BreadthFirstPaths breadthFirstPaths = new BreadthFirstPaths(graph, 0);
		assertTrue(breadthFirstPaths.hasPathTo(5));
		assertFalse(breadthFirstPaths.hasPathTo(6));
		assertEquals(3, breadthFirstPaths.distTo(5));
		assertEquals(1, breadthFirstPaths.distTo(3));
		
	}
	

}







