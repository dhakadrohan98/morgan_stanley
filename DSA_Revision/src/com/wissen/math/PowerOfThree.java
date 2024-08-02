package com.wissen.math;

public class PowerOfThree {
	
	// 21032 / 21040 test cases passed.
	public static boolean isPowerOfThree(int n) {
	    // Edge case
	    if (n <= 0) {
	        return false;
	    }
	    
	    // Loop to divide n by 3 until n is less than 3
	    while (n % 3 == 0) {
	        n /= 3;
	    }
	    
	    // If n becomes 1, it is a power of three
	    return n == 1;
	}
	 
	public static void main(String[] args) {
		int n1 = 27;
		int n2 = 45;
		int n3 = 1;
		int n4 = 6;
		int n5 = 9;
		System.out.println(isPowerOfThree(n1));
	}
}
