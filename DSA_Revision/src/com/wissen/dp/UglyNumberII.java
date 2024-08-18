package com.wissen.dp;

public class UglyNumberII {

	// TC: O(n)
	// SC: O(n)

	public int nthUglyNumber(int n) {
		int[] t = new int[n + 1];
		// t[i] = ith ugly number
		// we will return t[n] = nth ugly number

		t[1] = 1; // 1st ugy number

		int i2 = 1; // i2th ugly number
		int i3 = 1; // i3rd ugly number
		int i5 = 1; // i5th ugly number

		for (int i = 2; i <= n; i++) {
			int i2th_ugly = t[i2] * 2;
			int i3rd_ugly = t[i3] * 3;
			int i5th_ugly = t[i5] * 5;

			int minUglyNum = Math.min(i2th_ugly, Math.min(i3rd_ugly, i5th_ugly));
			t[i] = minUglyNum;

			//whatever uglyth numbers are minimum, increment that only.
			if (minUglyNum == i2th_ugly) {
				i2++;
			}

			if (minUglyNum == i3rd_ugly) {
				i3++;
			}

			if (minUglyNum == i5th_ugly) {
				i5++;
			}
		}
		return t[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
