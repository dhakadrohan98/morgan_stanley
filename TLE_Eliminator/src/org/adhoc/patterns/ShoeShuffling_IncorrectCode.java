package org.adhoc.patterns;

import java.util.Arrays;
import java.util.Scanner;

//Incorrect code
public class ShoeShuffling_IncorrectCode {

	private static void solve(Scanner sc) {
		int n = sc.nextInt();
		long[] arr = new long[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		//main logic
		//{4,4,4}
		int[] ans = new int[n];
		for(int i = 0; i < n; i++) {
			// i  -> 1
			long temp = arr[i];
			int size = 1;
			ans[i] = i;
			//ans[1] -> 1 
			i++; // i  -> 2
			//check for two conditions - 
			//(i) shuffling shold be done with same shoe size
			//(ii) if a shoe has frequency = 1, then return -1.
			while(i < n && arr[i] ==  temp) {
				ans[i] = ans[i - 1];
				// ans[2] -> 1
				ans[i-1] = i;
				//and[1] -> 2
				i++; //i -> 3
				size++; //size = 2;
			}
			if(size == 1) {
				System.out.println(-1);
				return;
			}
		}
		//print the ans because shuffling is possible
		for(int i = 0; i < n; i++) {
			System.out.print((ans[i] + 1) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			solve(sc);
		}

	}

}

//TC
//3
//6
//1 2 3 4 4 5
//6
//1 1 2 2 3 3
//7
//2 2 3 4 4 5 5

