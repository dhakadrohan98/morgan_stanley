package org.bitmanipulation;

public class BitManipulationFunction {

	//TC: O(logn) + 1
	//
	public static void main(String[] args) {
		int num1 = 29;
		int num2 = 28;
		System.out.println("Bit manipulation function on int data type");
		System.out.println(Integer.bitCount(num2));
		System.out.println(Integer.numberOfLeadingZeros(num2));
		System.out.println(Integer.numberOfTrailingZeros(num2));
		
		System.out.println("Bit manipulation function on long data type");
		System.out.println(Long.numberOfLeadingZeros(num2));
		System.out.println(Long.numberOfTrailingZeros(num2));
		boolean b = true;
		System.out.println(Byte.SIZE + " bits"); 

	}

}
