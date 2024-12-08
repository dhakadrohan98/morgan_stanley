package org.difference_arrays;

import java.util.Scanner;

public class DifferenceArrays_Template {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		//Take Difference array based on 1 based indexing
		long[] diff = new long[n+1];
		int q =  sc.nextInt();
		//construct diff arrays
		while(q-- > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int x = sc.nextInt();
			diff[l] += x;
			diff[r+1] -= x;
		}
		
		//take prefix sum of diff array
		for(int i = 1; i < n; i++) {
			diff[i] += diff[i-1];
		}
		//print by how much diff original array is differing after q queries?
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i] + " - " +  diff[i]);
		}
		
		
	}

}
