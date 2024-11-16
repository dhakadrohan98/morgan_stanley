package com.codeforces.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class OlyaAndGameWithArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] result = new int[t];
		
		
		while(t > 0) {
			//number of arrays in the list
			int n = sc.nextInt();
			long mini = (int) Math.pow(9, 18);
			long second_mini_sum = 0;
			long second_mini = (int) Math.pow(9, 18);
			//iteration for n number of arrays
			
			for(int i = 0; i < n; i++) {
				//number of elements in the i-th array
				int m = sc.nextInt();
				long[] arr = new long[m];
				//input for i^th array for m no. of elements
				for(int j = 0; j < m; j++) {
					arr[j] = sc.nextInt();
				}
				//sort the arr to get mini & second_mini
				Arrays.sort(arr);
				mini = Math.min(mini, arr[0]);
				second_mini_sum += arr[1];
				second_mini = Math.min(second_mini, arr[1]);
			} 
			System.out.println(mini + second_mini_sum - second_mini);
			t--;
		}
	}
}
	
	/*
	 * Input-1
	2
	2
	1 2
	2
	4 3
	 */
	
	/*
	 * Input-2
	1
	3
	100 1 6
	 */
	
	/*
	 * Input-3
	3
	4
	1001 7 1007 5
	3
	8 11 6
	2
	2 9
	 */
	
	/* combined input
	3
	2
	2
	1 2
	2
	4 3
	1
	3
	100 1 6
	3
	4
	1001 7 1007 5
	3
	8 11 6
	2
	2 9
	 */
