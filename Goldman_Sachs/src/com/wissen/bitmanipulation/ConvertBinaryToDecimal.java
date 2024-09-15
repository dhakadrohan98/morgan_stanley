package com.wissen.bitmanipulation;

public class ConvertBinaryToDecimal {

//	TC: O(len of string)
//	SC: O(1)

	public static int convertBinaryToDecimal(String str) {
		int num = 0;
		int p2 = (int) Math.pow(2,0);  
		int n = str.length();
		
		//start from the last
		for(int i = n - 1; i >= 0; i--) {
			if(str.charAt(i) == '1') {
				num += p2;
			}
			// 2 * 2 for calculating the power of 2 for next bit position
			//2 * 1 = 2 (2^1)
			//2 * 2 = 4 (2^2)
			//4 * 2 = 8 (2^3)
			//8 * 2 = 16 (2^4)
			p2 = p2 * 2;
		}
		
		return num;
	}
	public static void main(String[] args) {
		String str = "1101";
		System.out.println(convertBinaryToDecimal(str));

	}

}
