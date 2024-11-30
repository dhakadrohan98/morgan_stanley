package com.codeforces.combinatorics;

import java.util.Scanner;

public class SkiResort {

	//TC: O(2*n)
	//SC: O(n)
	private static void solve(Scanner sc) {
//		length of the array (temperatures)
		int n = sc.nextInt();
//		minimum number of days at the resort
		int k = sc.nextInt();
//		maximum comfortable temperature for Dima
		long q = sc.nextLong();
//		 array a will store temparatures for n days. At i-th day, the temperature will be ai degrees
		long[] a = new long[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
			if(a[i] > q) {
				//not a comfortable temparature
				a[i] = 0;
			} else {
				//a comfortable temparature
				a[i] = 1;
			}
		}
		
		long ans = 0, len = 0;
		for(int i = 0; i < n; i++) {
			if(a[i] == 1) {
				len += 1;
				
			} else {
				if(len >= k) {
					long m = (len-k+1);
					//no. of subarrays for m len arrays
					ans += (m *(m+1)/2);
				}
				//reset the length to 0;
				len = 0;
			}
		}
		//if till last index len is greater than 0.
		if(len >= k) {
			long m = (len-k+1);
			ans += (m *(m+1)/2);
		}
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t > 0) {
			solve(sc);
			t--;
		}

	}
}
