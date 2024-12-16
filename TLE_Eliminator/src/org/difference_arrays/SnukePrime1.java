package org.difference_arrays;

import java.util.Scanner;

public class SnukePrime1 {

	static double N = 1e6+1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] diff = new long[(int)N];
		long n = sc.nextLong();
		long C = sc.nextLong();
		
		for(int i = 0; i < n; i++) {
			long l = sc.nextLong();
			long r = sc.nextLong();
			long x = sc.nextLong();
			diff[(int)l] += x;
			diff[(int)r+1] -= x;
		}
		
		//prefix sum
		for(int i = 1; i < n; i++) {
			diff[i] += diff[i-1];
		}
		
		int ans = Integer.MAX_VALUE;
		//
		for(int i=1; i < n; i++) {
			ans += Math.min(ans, diff[i]);
		}
		
		System.out.println(ans);

	}

}
