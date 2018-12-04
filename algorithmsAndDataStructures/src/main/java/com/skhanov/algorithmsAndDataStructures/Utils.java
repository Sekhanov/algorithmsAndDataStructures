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

}
