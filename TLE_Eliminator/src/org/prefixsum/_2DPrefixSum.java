package org.prefixsum;

import java.util.Scanner;

//TC: O(n+q)
//SC: O(n)
public class _2DPrefixSum {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // rows
		int m = sc.nextInt(); // cols
		int[][] arr = new int[n][m];
		// read n*m array values
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int[][] pre = new int[n][m];
		//logic for 2D prefix sum
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				//for current element
				pre[i][j] = arr[i][j];
				//adding above portion
				if(i > 0) {
					pre[i][j] += pre[i-1][j];
				}
				//adding below portion
				if(j > 0) {
					pre[i][j] += pre[i][j-1];
				}
				//some portion are added twice hence subtract it
				if(i > 0 && j > 0) {
					pre[i][j] -= pre[i-1][j-1];
				}
			}
		}
		
		//print 2d array
		for(int[] a : pre) {
			for(int val : a) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}

//Test cases:

//1.
//5 5
//2 6 5 9 10
//3 4 1 6 1
//2 7 3 2 2
//1 3 5 4 3
//6 7 9 11 4
