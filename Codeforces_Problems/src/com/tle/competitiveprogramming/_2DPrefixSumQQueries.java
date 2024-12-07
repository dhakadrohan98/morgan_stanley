package com.tle.competitiveprogramming;

import java.util.Scanner;

public class _2DPrefixSumQQueries {

	private static void solve(Scanner sc, int[][] pre) {
		int l1 = sc.nextInt();
		int r1 = sc.nextInt();
		int l2 = sc.nextInt();
		int r2 = sc.nextInt();
		int ans = pre[l2][r2];
		
		if(l1 > 0) {
			ans -= pre[l1-1][r2];
		}
		if(r1 > 0) {
			ans -= pre[l2][r1-1];
		}
		if(l1 > 0 && r1 > 0) {
			ans += pre[l1-1][r1-1];
		}
		System.out.println(ans);
		
	}
	
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
		
		int q = sc.nextInt();
		while(q-- > 0) {
			solve(sc, pre);
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
//1
//1 1 2 2

//2.
//5 5
//2 6 5 9 10
//3 4 1 6 1
//2 7 3 2 2
//1 3 5 4 3
//6 7 9 11 4
//2
//1 1 2 2
//1 1 2 3
