package com.codeforces.constructive_algo;

import java.util.Scanner;

public class BeautifulArray {

	private static void solve(Scanner sc) {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int b = sc.nextInt();
		long s = sc.nextLong();
		
		//main logic
		//out of ( range values give beauty as b, when divided by k. )
		if((s < (k*(long) b) || s > ( (k* (long)b) + ((k-1l) * n)))) {
			System.out.println(-1);
			return;
		}
		long[] arr = new long[n];
		arr[0] = k * (long)b;
		s -= (k * (long)b);
		
		for(int i = 0; i < n; i++) {
			long x = Math.min(k-1l, s);
			arr[i] += x;
			s -= x;
		}
		//print the array
		for(long val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0) {
			solve(sc);
		}
		sc.close(); // Close the scanner to avoid resource leak
	}

}
