package com.codoeforces.greedy;

import java.util.Arrays;
import java.util.Scanner;

// 5 test cases passed
//2 3
//1 2
public class BasketballTogether {

	private static void solve(Scanner sc) {
		int n = sc.nextInt();
		long d = sc.nextLong();
		long[] arr =  new long[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		//main logic
		Arrays.sort(arr);
		int j = n-1;
		int maxWins = 0;
		while(j >= 0) {
			long quotient = d / arr[j];
			long rem =  d % arr[j];
			long noOfPlayers = quotient;
			if(rem > 0)  {
				noOfPlayers += 1; 
			}
			if((j - (int)noOfPlayers) >= 0) {
				maxWins += 1;
			}
			j = j - (int)noOfPlayers;
		}
		System.out.println(maxWins);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		solve(sc);
		
	}
}

//Test cases

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
