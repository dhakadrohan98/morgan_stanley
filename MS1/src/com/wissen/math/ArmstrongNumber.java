package com.wissen.math;

public class ArmstrongNumber {

	//TC: O((log10n) ^ 2)
	//SC: O(1)
	public static boolean isArmstrong(int num) {
		int n = num;
		//find the no. of digits
		int digits = (int)Math.log10(n) + 1;
		int armstrong = 0;
		
		while(n != 0) {
			int rem = n % 10;
			armstrong += (int) Math.pow(rem, digits);
			n /= 10;
		}
		
		if(num == armstrong) {
			return true;
		}
		
		return false;
		
	}
	public static void main(String[] args) {
		int n1 = 153; //armstrong
		int n2 = 120; //not
		int n3 = 1253; //not
;		int n4 = 1634; ////armstrong
		System.out.println(isArmstrong(n1));
		System.out.println(isArmstrong(n2));
		System.out.println(isArmstrong(n3));
		System.out.println(isArmstrong(n4));
	}

}
