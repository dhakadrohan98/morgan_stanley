package com.wissen.bitmanipulation;

public class MinimumBitFlipstoConvertNumber {

	// TC: O(logn) where n is the maximum value b/w start & goal
	// SC: O(1)
	public int minBitFlips(int start, int goal) {
		//xor operation will tell about how many bits need to be flipped
		int xor = start ^ goal;
		int count = 0;

		// count the no. of set bits after performing xor OPs on start & target
		// TC: O(logn) where n is the maximum value b/w start & goal
		while (xor > 0) {
			xor = xor & (xor - 1);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
