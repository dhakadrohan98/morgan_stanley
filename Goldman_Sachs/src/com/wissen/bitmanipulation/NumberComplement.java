package com.wissen.bitmanipulation;

public class NumberComplement {

	// T.C : O(log2(num))
	// S.C : O(1)
	public int findComplement(int num) {
		int numberOfBits = (int) (Math.log(num) / Math.log(2)) + 1;

		for (int i = 0; i < numberOfBits; i++) {
			num = num ^ (1 << i); // Take XOR to flip
		}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
