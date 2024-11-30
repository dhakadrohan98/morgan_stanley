package com.codoeforces.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArraysMerging {

	private static void solve(Scanner sc, List<Integer> list) {
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		// input for array a
		// ai -> (1 <= ai <= 4 * 10^5)
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		// input for array b
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}

		// main logic
		// length of longest subarray in array 'a' or 'b' for i value
		int[] fa = new int[2 * n + 1];
		int[] fb = new int[2 * n + 1];
		// length of longest subarray in array 'a' for i value
		for (int i = 0; i < n; i++) {
			int val = a[i];
			int count = 0;
			while (i < n && a[i] == val) {
				count++;
				i++;
			}
			// we have reached to next different value when subarray is ended for 'i' value.
			// pointer i will be incremented by for loop structure itself, that's manually
			// need to
			// decrement the pointer i
			i--;
			fa[val] = Math.max(fa[val], count);

		}

		// length of longest subarray in array 'b' for i
		for (int i = 0; i < n; i++) {
			int val = b[i];
			int count = 0;
			while (i < n && b[i] == val) {
				count++;
				i++;
			}
			// we have reached to next different value when subarray is ended for 'i' value.
			// pointer i will be incremented by for loop structure itself, that's manually
			// need to
			// decrement the pointer i
			i--;
			fb[val] = Math.max(fb[val], count);
		}

		int ans = 0;
		//we will traverse from 1 till 2*n in array 'c'
		//because c array constitutes of a(n) + b(n) length arrays
		for (int i = 1; i <= 2 * n; i++) {
			ans = Math.max(ans, fa[i] + fb[i]);
		}
		list.add(ans);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		int t = sc.nextInt();
		while (t > 0) {
			// for each test case
			solve(sc, list);
			t--;
		}

		for (int val : list) {
			System.out.println(val);
		}
	}

}
