package com.wissen.bitmanipulation;

public class BitManipulationLearning {

	public static void main(String[] args) {
		int num1 = 23;
		int num2 = 17;
		// AND operation
		System.out.println(23 & 17);
		
		//OR operator
		System.out.println(23 | 27);
		
		//XOR operator
		System.out.println(21 ^ 23);
		//xor of any number with 0 itself
		System.out.println(8 ^ 0);
		
		
		//One’s complement operator (Negation operator)
		// ~x = -(x+1)
		System.out.println(~5);

	}

}
