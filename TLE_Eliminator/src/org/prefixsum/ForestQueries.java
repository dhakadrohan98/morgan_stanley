package org.prefixsum;

import java.util.Scanner;

public class ForestQueries {

	private static void solve(Scanner sc, int[][] pre, int[][] queries, int k) {
		// In problem, 1based indexing are given
		// reduce the input to 0th based indexing according to code template
		int l1 = queries[k][0] - 1;
		int r1 = queries[k][1] - 1;
		int l2 = queries[k][2] - 1;
		int r2 = queries[k][3] - 1;

		int ans = pre[l2][r2];

		if (l1 > 0) {
			ans -= pre[l1 - 1][r2];
		}
		if (r1 > 0) {
			ans -= pre[l2][r1 - 1];
		}
		if (l1 > 0 && r1 > 0) {
			ans += pre[l1 - 1][r1 - 1];
		}
		System.out.println(ans);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // rows
		int q = sc.nextInt(); // q queries

		char[][] forest = new char[n][n];
		for (int i = 0; i < n; i++) {
			String row = sc.next();
			for (int j = 0; j < n; j++) {
				forest[i][j] = row.charAt(j);
			}
		}

		// calculate prefix sum
		int[][] pre = new int[n][n];
		// logic for 2D prefix sum
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// for current element
				if (forest[i][j] == '*') {
					pre[i][j] = 1;
				} else {
					pre[i][j] = 0;
				}
				// adding above portion
				if (i > 0) {
					pre[i][j] += pre[i - 1][j];
				}
				// adding below portion
				if (j > 0) {
					pre[i][j] += pre[i][j - 1];
				}
				// some portion are added twice hence subtract it
				if (i > 0 && j > 0) {
					pre[i][j] -= pre[i - 1][j - 1];
				}
			}
		}

		// process for k queries
		int[][] queries = new int[q][4];
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < 4; j++) {
				queries[i][j] = sc.nextInt();
			}
		}

		int k = 0;
		// process queries
		while (q-- > 0) {
			solve(sc, pre, queries, k);
			k += 1;
		}
		sc.close();
	}
}

//4 1
//. * . .
//* . * *
//* * . .
//* * * *
//3 1 3 1

//4 3
//.*..
//*.**
//**..
//****
//2 2 3 4
//3 1 3 1
//1 1 2 2

//4 4
//. * . *
//* . * *
//* * . .
//* * * .
