package com.wissen.bitmanipulation;

public class ConvertBinaryToDecimal {

	public static int convertBinaryToDecimal(String str) {
		int num = 0;
		int p2 = 1;
		int n = str.length();
		
		//start from the last
		for(int i = n - 1; i >= 0; i--) {
			if(str.charAt(i) == '1') {
				num += p2;
			}
			p2 = p2 * 2;
		}
		
		return num;
	}
	public static void main(String[] args) {
		String str = "1101";
		System.out.println(convertBinaryToDecimal(str));

	}

}
