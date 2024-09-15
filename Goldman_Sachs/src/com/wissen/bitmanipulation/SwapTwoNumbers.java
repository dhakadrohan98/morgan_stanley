package com.wissen.bitmanipulation;

public class SwapTwoNumbers {

	public static void main(String[] args) {
		int a = 5;
		int b = 4;
		
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		
		System.out.println("a: " + a + " b: " + b);

	}

}
