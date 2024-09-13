package com.wissen.bitmanipulation;

public class CumulativeXor {

	//calculate cumulative xor of given array
	public static void main(String[] args) {
		int[] arr = {1,3,4,8};
		int n = arr.length;
		int[] cumulative = new int[n];
		
		cumulative[0] = arr[0];
//		cumulative[n-1] = arr[n-1];
		
		for(int i = 1; i < n; i++) {
			cumulative[i] = cumulative[i-1] ^ arr[i];
		}
		
		for(int val: cumulative) {
			System.out.println(val);
		}

	}

}
