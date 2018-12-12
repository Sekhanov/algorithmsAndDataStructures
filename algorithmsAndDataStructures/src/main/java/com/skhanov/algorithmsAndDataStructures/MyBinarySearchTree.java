package com.skhanov.algorithmsAndDataStructures;

public class MyBinarySearchTree<K extends Comparable<K>, V> {
	
	private class Node {
		K k;
		V v;
		Node left;
		Node right;
		int size;
		
		public Node(K k, V v, int size) {
			this.k = k;
			this.v = v;
			this.size = size;
		}		
	}
	
	private Node root;
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public int size() {
		return size(root);
	}

	private int size(Node node) {
		return node.size;
	}
	
	public V get(K k) {
		return get(root, k);
	}

	private V get(Node node, K k) {
		if(k == null) {
			throw new IllegalArgumentException("Ключ не может принимать значение Null");
		}
		int comparation = k.compareTo(node.k);
		if(comparation == 0) {
			return node.v;
		}
		if(comparation > 0) {
			return get(node.right, k);
		}
		if(comparation < 0) {
			return get(node.left, k);
		}
		
		return null;
	}
	
	public boolean contain(K k) {
		return get(k) != null;
	}
	
	public void put(K k, V v) {
		if(k == null) {
			throw new IllegalArgumentException("Ключ не может принимать значение null");
		}
	}
	
	
}
