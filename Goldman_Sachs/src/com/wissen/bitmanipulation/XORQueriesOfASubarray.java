package com.wissen.bitmanipulation;

public class XORQueriesOfASubarray {

	// TC: O(n) calculate prefix/cumulative xor + O(q) //iterate through queries
	// SC: O(n) //store prefix/cumulative xor

	// TC: O(n)
	public static int[] cumulativeXor(int[] arr) {
		int n = arr.length;
		int[] cumulative = new int[n];
		// cumulative xor of [0,0] will be arr[0] itself
		cumulative[0] = arr[0];

		for (int i = 1; i < n; i++) {
			cumulative[i] = cumulative[i - 1] ^ arr[i];
		}
		return cumulative;
	}

	//main motive xor of two same number is always 0 or negligible
	public static int[] xorQueries(int[] arr, int[][] queries) {
		int n = arr.length;
		int q = queries.length;
		int[] res = new int[q];
		int indx = 0;

		int[] cumulative = cumulativeXor(arr);

		for (int[] temp : queries) {
			int start = temp[0];
			int end = temp[1];

			if (start == end) {
				res[indx++] = arr[start];
			} else if (start == 0) {
				res[indx++] = cumulative[end];
			}

			else {
				res[indx++] = cumulative[end] ^ cumulative[start - 1];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
