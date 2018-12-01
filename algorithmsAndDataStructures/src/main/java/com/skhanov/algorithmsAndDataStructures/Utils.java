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

}
