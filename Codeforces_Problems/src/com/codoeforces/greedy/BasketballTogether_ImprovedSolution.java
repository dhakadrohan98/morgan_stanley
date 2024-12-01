package com.codoeforces.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BasketballTogether_ImprovedSolution {

	private static void solve(Scanner sc) {
		int n = sc.nextInt();
		long d = sc.nextLong();
		long[] arr =  new long[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		//main logic
		Arrays.sort(arr);
		for(int i = 0; i < n/2; i++) {
			long temp = arr[i];
			arr[i] = arr[n-1-i];
			arr[n-1-i] = temp;
		}
		
		//print the reversed array
//		for(long val : arr) {
//			System.out.print(val + " ");
//		}
		//100, 90, 80, 70, 60, 50
		int i = 0;
		int players = 0;
		int wins = 0;
		
		while(i < n && players <= n) {
			int ceil_val = (int) Math.ceil((double)(d+1) / (double)arr[i]);
			players += ceil_val;
			if(players <= n) {
				wins++;
			}
			i++;
		}
		System.out.println(wins);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while(t-- > 0) {
			solve(sc);
		}
	}

}

//Individual Test cases

//6 180
//90 80 70 60 50 100
//2

//2 4
//1 2
//0

//4 13
//3 2 1 3
//0


//4 17
//3 2 1 4
//0

//8 16
//1 2 1 1 1 1 1 1
//0

//2 3
//1 2
//1

//5 3
//4 5 9 10 11
//5
//mine o/p: 4

//combined test case:
//	
//7
//6 180
//90 80 70 60 50 100
//2 4
//1 2
//4 13
//3 2 1 3
//4 17
//3 2 1 4
//8 16
//1 2 1 1 1 1 1 1
//2 3
//1 2
//5 3
//4 5 9 10 11



