package com.wissen.math;

import java.util.*;

public class FractionToDecimalRecurring {
	
//	In the worst case, the loop iterates through all possible remainders (from 1 to denominator - 1).
//	Therefore, TC: O(denominator).
//	The maximum number of entries in the HashMap is equal to the denominator (since the remainder 
//	can take values from 1 to denominator - 1).
//	Thus, SC: O(denominator).
	public static String fractionToDecimal(int numerator, int denominator) {

		StringBuilder ans = new StringBuilder();
		// Use Long for numerator to handle potential overflow
		Map<Long, Integer> hmap = new HashMap<>();

		// Handle the sign
		if (numerator != 0) {
			if (numerator < 0 || denominator < 0) {
				ans.append("-");
			}
		}

		// Store absolute value of num & den for sign free processing
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);

		long q = num / den;
		long r = num % den;
		// add quotient into ans
		ans.append(q);

		if (r == 0) {
			return ans.toString();
		} else {
			ans.append(".");
			// while rem != 0 or !hmap.containsKey(rem)
			while (r != 0) {
				if (hmap.containsKey(r)) {
					int len = hmap.get(r);
					ans.insert(len, "(");
					ans.insert(ans.length(), ")");
					break;
				} else {
					hmap.put(r, ans.length());
					// put one zero just after remainder while remainder acting as new quotient
					r = r * 10;
					q = r / den;
					r = r % den;
					// add quotient into ans
					ans.append(q);
				}
			}
		}
		return ans.toString();
	}

	public static void main(String[] args) {
		int num = 93;
		int den = 7;
		System.out.println(fractionToDecimal(num, den));
		
		System.out.println("13.285714");
		StringBuilder sb = new StringBuilder();
		sb.append("13.285714");
		sb.insert(3, "(");
		System.out.println(sb.toString());
		sb.insert(10, ")");
		System.out.println(sb.toString());
	}

}
