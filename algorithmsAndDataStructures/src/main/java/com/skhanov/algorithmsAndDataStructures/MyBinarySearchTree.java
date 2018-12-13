package com.skhanov.algorithmsAndDataStructures;

public class MyBinarySearchTree<K extends Comparable<K>, V> {

	private class Node {
		K k;
		V v;
		Node left;
		Node right;
		int size;
		int height;

		public Node(K k, V v, int size, int height) {
			this.k = k;
			this.v = v;
			this.size = size;
			this.height = height;
		}
	}

	private Node root;

	public boolean isEmpty() {
		return root == null;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	public boolean isBalanced() {
		return isBalanced(root);
	}

	private boolean isBalanced(Node node) {
		if(node == null || height(node.left) == height(node.right) || 
			height(node.left) + 1 == height(node.right) ||
			height(node.left) == height(node.right) + 1) {
			return true;
		} else {
			return false;
		}
			
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		return node.size;
	}

	public V get(K k) {
		return get(root, k);
	}

	private V get(Node node, K k) {
		if (k == null) {
			throw new IllegalArgumentException("Ключ не может принимать значение Null");
		}
		int comparation = k.compareTo(node.k);
		if (comparation == 0) {
			return node.v;
		} else if (comparation > 0) {
			return get(node.right, k);
		} else if (comparation < 0) {
			return get(node.left, k);
		}

		return null;
	}

	public boolean contain(K k) {
		return get(k) != null;
	}

	public void put(K k, V v) {
		root = put(root, k, v);
	}

	private Node put(Node node, K k, V v) {
		if (k == null) {
			throw new IllegalArgumentException("Ключ не может принимать значение null");
		}
		if (node == null) {
			return new Node(k, v, 1, 0);
		}
		int comparable = k.compareTo(node.k);
		if (comparable == 0) {
			node.v = v;
		} else if (comparable < 0) {
			node.left = put(node.left, k, v);
			node.height = node.left.height + 1;
		} else if (comparable > 0) {
			node.right = put(node.right, k, v);
			node.height = node.right.height + 1;
		}
		node.size = size(node.left) + size(node.right) + 1;
		return node;
	}

	public Node min(Node node) {
		if (node.left == null) {
			return node;
		} else {
			return min(node.left);
		}
	}

	public Node max(Node node) {
		if (node.right == null) {
			return node;
		} else {
			return max(node.right);
		}
	}

	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node node) {
		if (node.left == null) {
			return node.right;
		}
		node.left = deleteMin(node.left);
		return node;
	}

	public void deleteMax() {
		root = deleteMax(root);
	}

	private Node deleteMax(Node node) {
		if (node.right == null) {
			return node.left;
		}
		node.right = deleteMax(node.right);
		return node;
	}

	public void delete(K k) {
		root = delete(root, k);
	}

	private Node delete(Node node, K k) {
		if (node == null) {
			return null;
		}
		int compare = k.compareTo(node.k);
		if (compare > 0) {
			node.right = delete(node.right, k);
		} else if (compare < 0) {
			node.left = delete(node.left, k);
		} else if (compare == 0) {
			if (node.left == null) {
				return node.right;
			}
			if (node.right == null) {
				return node.left;
			}
			Node tempNode = node;
			node = max(node.left);
			node.left = deleteMax(tempNode.left);
			node.right = tempNode.right;
			tempNode = null;
		}
		node.size = size(node.left) + size(node.right) + 1;
		return node;
	}

}
