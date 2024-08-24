package com.wissen.math;

public class FindTheClosestPalindrome_104_217 {

	public static String nearestPalindromic(String s) {
		int n = s.length();
		
		//edge case if a n is of length of 1
        if(n == 1) {
            int num = Integer.valueOf(s);
            return String.valueOf(num-1);
        }
		int half = n / 2;
		StringBuilder sb = new StringBuilder();
		// odd length substring
		if (n % 2 != 0) {
			sb.append(s.substring(0, half + 1));
			String beforeHalfExclusive = sb.substring(0, half);
			sb.append(beforeHalfExclusive);

		} else {
			sb.append(s.substring(0, half));
			StringBuilder nextHalf = new StringBuilder(sb);
			sb.append(nextHalf.reverse());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "123";

		String s1 = "3256";
		String res = nearestPalindromic(s1);
		System.out.println(res);

	}
}
