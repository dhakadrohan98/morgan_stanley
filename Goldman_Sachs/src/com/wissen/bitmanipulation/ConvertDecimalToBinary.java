package com.wissen.bitmanipulation;

public class ConvertDecimalToBinary {

	//TC: O(logn) base to the 2
	//SC: O(logn) base to the 2
	public static String convertBinaryToDecimal(int num) {
		
		StringBuilder sb = new StringBuilder();
		
		while(num != 0) {
			sb.append(num % 2);
			num = num / 2;
		}
		sb.reverse();
		return sb.toString();
	}
	
	
	// 13 -> 1101
	
	/*
	 * 13 / 2 -> 1 
	 * 6  / 2 -> 0 
	 * 3  / 2 -> 1 
	 * 1  / 2 -> 1
	 * 0
	 */
	public static void main(String[] args) {
		int num = 13;
		int num1 = 23;
		System.out.println(convertBinaryToDecimal(num1));

	}

}
