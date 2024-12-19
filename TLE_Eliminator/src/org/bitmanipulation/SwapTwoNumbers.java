package org.bitmanipulation;

public class SwapTwoNumbers {

	public static void main(String[] args) {
		int a = 2;
		int b = 5;
		a = a ^ b;
		b = b ^ a;
		System.out.println("b: " + b);
		a = a ^ b;
		System.out.println("a: " + a);
		

	}

}
