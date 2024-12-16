package org.bitmanipulation;

import java.util.*;

public class MakeAlmostEqualWithMod {

	private static void solve(Scanner sc) {
		int n = sc.nextInt();
		long[] arr = new long[n];
		//taking arrays input
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		
		//main logic
		for(int i = 1; i <= 61; i++) {
			//2^1, 2^2, 2^3,..................., 2^61
			long k = 1l << i;
			Set<Long> set = new HashSet<>();
			for(int j = 0; j < n; j++) {
				set.add(arr[j] % k);
			}
			//if set contains exactly two distinct integers then print the value of k & return from here.
			if(set.size() == 2) {
				System.out.println(k);
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			solve(sc);
		}
	}

}
