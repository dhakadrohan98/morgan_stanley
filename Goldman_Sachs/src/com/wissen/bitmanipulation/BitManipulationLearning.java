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
		//Xor of any number with 0 itself
		System.out.println(8 ^ 0);
	
		//One’s complement operator (Negation operator)
		// ~x = -(x+1)
		System.out.println(~5);
		System.out.println(~(-6));
		
		//left shift operator
		System.out.println(23<<1); //23 * (2^1)
		System.out.println(23<<2); //23 * (2^2)
		System.out.println(23<<3); //23 * (2^3)
		
		//right shift operator
		System.out.println(23>>1); // 23 / (2^1)
		System.out.println(23>>2); // 23 / (2^2)
		System.out.println(23>>3); // 23 / (2^3)
		
		
		

	}

}
