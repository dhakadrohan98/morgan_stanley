package com.wissen.bitmanipulation;

public class BitwiseOperatorExample {

	public static void main(String[] args) {
		//bitwise or(|)
		int a = 5;  // 0101 in binary
		int b = 7;  // 0111 in binary
		int result = a | b;  // 0111 in binary, which is 7 in decimal
		System.out.println("a | b = " + result);  // Output: a | b = 7
		
		//Bitwise and (&)
		// 0101 in binary
		// 0111 in binary
		result = a & b;  // 0101 in binary, which is 5 in decimal
		System.out.println("a & b = " + result);  // Output: a & b = 5
		
		//Bitwise xor (^)
		// 0101 in binary
		// 0111 in binary
		result = a ^ b;  // 0010 in binary, which is 2 in decimal
		System.out.println("a ^ b = " + result);  // Output: a ^ b = 2
		
		int c = 4;
		System.out.println(~c); //output = -5
		//formula: ~x = -(x+1)
		// ~4 = -(4+1) = -5

	}

}
