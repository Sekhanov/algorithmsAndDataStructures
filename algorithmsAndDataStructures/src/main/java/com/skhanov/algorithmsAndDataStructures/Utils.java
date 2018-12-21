package com.skhanov.algorithmsAndDataStructures;

public class Utils {

	public static boolean checkBrackets(String expression) {
		MyArrayStack<Character> stack = new MyArrayStack<>(expression.length());
		char[] charArra = expression.toCharArray();
		for (char c : charArra) {
			switch (c) {
			case '[':
			case '{':
			case '(':
				stack.push(c);
				break;
			case ')':
			case '}':
			case ']':
				if (!stack.isEmpty()) {
					char c1 = stack.pop();
					if ((c1 == '(' && c != ')') || (c1 == '[' && c != ']') || (c1 == '{' && c != '}')) {
						System.out.println("Error brackets");
					}
				}
				break;
			}
		}
		return stack.isEmpty();
	}

	public static String stringReverse(String s) {
		char[] chArr = s.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		MyArrayStack<Character> chStack = new MyArrayStack<>();
		for (char c : chArr) {
			chStack.push(c);
		}
		int charCount = chStack.size();
		for (int i = 0; i < charCount; i++) {
			stringBuilder.append(chStack.pop());
		}

		return stringBuilder.toString();

	}

	public static int fibonacchiRecursion(int i) {
		if (i == 1 || i == 2) {
			return 1;
		} else {
			return fibonacchiRecursion(i - 1) + fibonacchiRecursion(i - 2);
		}
	}

	public static int factorialRecursion(int i) {
		if (i == 1) {
			return 1;
		} else {
			return factorialRecursion(i - 1) * i;
		}
	}

	public static int powRecurson(int a, int b) {
		if (b == 1) {
			return a;
		}
		return powRecurson(a, b - 1) * a;
	}

	public static int powCicle(int a, int b) {
		int result = a;
		while (b > 1) {
			result *= a;
			b--;
		}
		return result;

	}

	public static void hanoiRec(int n, char from, char to, char add) {
		if (n == 0)	return;
		hanoiRec(n - 1, from, add, to);
		System.out.println(from + " " + to);
		hanoiRec(n - 1, add, to, from);

	}
	
	public static void recurCountDown(int i) {
		System.out.print(i + " ");
		if(i == 1) {
			System.out.println();
			return;
		} else {
			recurCountDown(i - 1);
		}
	}

	public static void cicleCoundDown(int i) {
		while(i > 0) {
			System.out.print(i + " ");
			i--;
		}
		System.out.println();
	}
	
	public static MyBinarySearchTree<Integer, Integer> fillBinarySearchTree(int elementCont, int height) {
		MyBinarySearchTree<Integer, Integer> myBinarySearchTree = new MyBinarySearchTree<>();
		for(int i = 1; i < elementCont; i++) {
			myBinarySearchTree.put(randomInt(), randomInt());
			if(myBinarySearchTree.height() > 6) {
				return myBinarySearchTree;
			}
		}
		return myBinarySearchTree;
		
	}

	private static int randomInt() {		
		return (int) (Math.random() * 200 - 100);
	}
	
	public static int nextPrime(int i) {
		i = i + 1;
		while(i <= Integer.MAX_VALUE) {
			if(isPrime(i)) return i;
			i++;
		}
		return 0;
	}
	
	public static boolean isPrime(int i) {
		if(i== 1) return false;
		for(int j = 2; j * j <= i; j++) {
			if(i % j == 0) {
				return false;
			}
		}
		return true;
	}
}
