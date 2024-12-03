package com.codeforces.math;

import java.util.Scanner;

public class Raspberries {

	private static void solve(Scanner sc) {
		int n = sc.nextInt();
		int k = sc.nextInt();
		//a1, a2,......., an
		int a;
		//keep track of even no.
		int even = 0;
		int ans = (int) 10e9;
		for(int i = 0; i < n; i++) {
			a = sc.nextInt();
			int op = (k - (a%k)) % k;
			ans = Math.min(ans, op);
			if(a % 2 == 0) {
				even++;
			}
		}
		// if k is not a prime number
		if(k == 4) {
			ans = Math.min(ans, Math.max(0, 2 - even));
		}
		System.out.println(ans);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0) {
			solve(sc);
		}

	}

}

//Test case

//1
//2 4
//9 8
//op: 0

//1

