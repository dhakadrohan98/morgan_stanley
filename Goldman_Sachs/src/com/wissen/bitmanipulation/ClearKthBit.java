package com.wissen.bitmanipulation;

import java.util.Arrays;

public class ClearKthBit {

	public static void main(String[] args) {
		int n = 13;
		int k = 2;
		
		//How to get 1011?
		
		// 1 << 2    = 0100
		// ~(1 << 2) = 1011
		
		//    1101 -> 13
		//  & 1011
		
		// => 1001 -> 9
		int res = n & (~(1 << k));
		System.out.println(res);
		
		int k1 = 1;
		int k2 = 3; 
		System.out.println(n & (~(1 << k1) )); // 13
		System.out.println(n & (~(1 << k2) )); // 5

	}

}
