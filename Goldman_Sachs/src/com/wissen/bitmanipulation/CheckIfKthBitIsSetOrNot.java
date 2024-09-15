package com.wissen.bitmanipulation;

public class CheckIfKthBitIsSetOrNot {

//	TC: O(1)
//	SC: O(1)

	//left shift operator and AND operation
	public static void main(String[] args) {
		int n = 13; //binary -> 1101
		int k = 3;
		
		int secondHypotheticalNum = 1 << k;
		
		if((n & secondHypotheticalNum) != 0) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

	}

}
