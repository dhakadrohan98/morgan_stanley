package com.codeforces.string;

import java.util.Scanner;

//TC: O(t*len)
//SC: O(2*10^5)
public class SwapAndDelete {

	public static void main(String[] args) {
		// inputs
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String[] str = new String[200000];

		for (int i = 0; i < t; i++) {
			str[i] = sc.next();
		}

		for (int i = 0; i < t; i++) {
			String s = str[i];

			// main logic
			int cost = 0;
			int[] arr = new int[2];

			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '0') {
					arr[0]++;
				} else {
					arr[1]++;
				}
			}

			for (int k = 0; k < s.length(); k++) {
				char ch = s.charAt(k);
				if (ch == '1') {
					if (arr[0] > 0) {
						arr[0]--;
					} else {
						cost = s.length() - k;
						break;
					}
				} else { // ch == '0'
					if (arr[1] > 0) {
						arr[1]--;
					} else {
						cost = s.length() - k;
						break;
					}
				}
			}

			System.out.println(cost);
		}
	}

}
