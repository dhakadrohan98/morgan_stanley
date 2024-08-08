package com.wissen.math;

import java.util.*;

public class IntegerToEnglisWords {

	//TC: O(log~10(num) + 1)
	//SC: O(1) (fixed sizes map is taken) + O(log~10(num) + 1) stack space
	
	// create three different map to represent the english words for num < 10, 20 &
	// 100
	private static final Map<Integer, String> belowTen = Map.of(0, "", 1, "One", 2, "Two", 3, "Three", 4, "Four", 5,
			"Five", 6, "Six", 7, "Seven", 8, "Eight", 9, "Nine");

	private static final Map<Integer, String> belowTwenty = Map.of(10, "Ten", 11, "Eleven", 12, "Twelve", 13,
			"Thirteen", 14, "Fourteen", 15, "Fifteen", 16, "Sixteen", 17, "Seventeen", 18, "Eighteen", 19, "Nineteen");

	private static final Map<Integer, String> belowHundred = Map.of(2, "Twenty", 3, "Thirty", 4, "Forty", 5, "Fifty", 6,
			"Sixty", 7, "Seventy", 8, "Eighty", 9, "Ninety");

	public static String solve(int num) {
		// Seven diff. cases( < 10, 20, 100, 1000, 1000000, 1000000000 and > 1000000000) need to handle separately
		if (num < 10) {
			return belowTen.get(num);
		}

		if (num < 20) {
			return belowTwenty.get(num);
		}

		if (num < 100) { // 89 = 89 % 10 = 9
			return belowHundred.get(num / 10) + ((num % 10 != 0) ? " " + belowTen.get(num % 10) : "");
		}
		
		if(num < 1000) { // 879/100 = 8 "Eight Hundred" 
			return solve(num/ 100) + " Hundred" + ((num % 100 != 0) ? " " + solve(num % 100) : "");
		}
		//less than 1 million, divide by 1000
		if(num < 1000000) {
			return solve(num/ 1000) + " Thousand" + ((num % 1000 != 0) ? " " + solve(num % 1000) : "");
		}
		
		//less than 1 billion, divide by 1000000(1 million)
		if(num < 1000000000) {
			return solve(num/ 1000000) + " Million" + ((num % 1000000 != 0) ? " " + solve(num % 1000000) : "");
		}
		
		//greater than or equal to 1 billion (last case), divide by 1 Billion(1000000000)
		return solve(num/ 1000000000) + " Billion" + ((num % 1000000000 != 0) ? " " + solve(num % 1000000000) : "");
	}

	private static String numberToWords(int num) {
		if(num == 0) {
			return "Zero";
		}
		return solve(num);
	}

	public static void main(String[] args) {
		int num = 123;
		System.out.println(numberToWords(num));

	}

//	//belowTen map
//	Map<Integer, String> belowTen = new HashMap<>();
//	belowTen.put(0, "");
//	belowTen.put(1, "One");
//	belowTen.put(2, "Two");
//	belowTen.put(3, "Three");
//	belowTen.put(4, "Four");
//	belowTen.put(5, "Five");
//	belowTen.put(6, "Six");
//	belowTen.put(7, "Seven");
//	belowTen.put(8, "Eight");
//	belowTen.put(9, "Nine");
//	
//	//belowTwenty
//	// 10 to 19 (Ten, Eleven, .................., Nineteen)
//	Map<Integer, String> belowTwenty = new HashMap<>();
//	belowTwenty.put(10, "Ten");
//	belowTwenty.put(11, "Eleven");
//	belowTwenty.put(12, "Twelve");
//	belowTwenty.put(13, "Thirteen");
//	belowTwenty.put(14, "Foruteen");
//	belowTwenty.put(15, "Fifteen");
//	belowTwenty.put(16, "Sixteen");
//	belowTwenty.put(17, "Seventeen");
//	belowTwenty.put(18, "Eighteen");
//	belowTwenty.put(19, "Nineteen");
//	
//	//belowHundred map
//	// 1 to 9 (Ten, Twenty, Thirty, ...................., Ninety)
//	Map<Integer, String> belowHundred = new HashMap<>();
//	belowHundred.put(1, "Ten");
//	belowHundred.put(2, "Twenty");
//	belowHundred.put(3, "Thirty");
//	belowHundred.put(4, "Forty");
//	belowHundred.put(5, "Fifty");
//	belowHundred.put(6, "Sixty");
//	belowHundred.put(7, "Seventy");
//	belowHundred.put(8, "Eighty");
//	belowHundred.put(9, "Ninety");

}
