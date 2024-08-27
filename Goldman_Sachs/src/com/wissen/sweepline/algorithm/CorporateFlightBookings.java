package com.wissen.sweepline.algorithm;

public class CorporateFlightBookings {
	// TC: O(2*n)
	// SC: O(n)
	public int[] corpFlightBookings(int[][] nums, int n) {
		int[] sweepLine = new int[n];
		int m = nums.length;
		// sweep line algorithm applied here
		for (int i = 0; i < m; i++) {
			int start = nums[i][0] - 1;
			int end = nums[i][1];
			int val = nums[i][2];

			sweepLine[start] += val;
			if (end < n) {
				sweepLine[end] -= val;
			}
		}
		// apply prefix sum concept now
		int[] prefixSum = new int[n];
		prefixSum[0] = sweepLine[0];

		for (int i = 1; i < n; i++) {
			prefixSum[i] = prefixSum[i - 1] + sweepLine[i];
		}

		return prefixSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}

//Sweep line algorithm Explanation:

//sweep line + prefix sum

//[1, r] - +x

//[1- +x ,,, r+1 = -x]

//pf[i] = a[0] +a[1] ... a[i]

//bookings=[[(1,2),10],[2,3,20], [2,5,25]], n = 5

//[1,   2,   3,   4,   5] --
//+10       -10,
//   +20       -20
//   +25
//
//........................

//10   55   45    25   25

//id 1 = +10 , id 3 = -10
//id 2 = +20 , id 4 = -20
//id_2 = +25 , id_6 = -25
