package com.codeforces.twopointers;

import java.util.Scanner;

//TC: O(2*n)
//where 1 <= n <= 2 * 10^5
public class TrafficLightImprovedSolution {
	private static void solve(Scanner sc) {
		int n = sc.nextInt();
		//read character from first index of string through next() method of scanner class
		char c = sc.next().charAt(0);
		String s = sc.next();
		s = s + s;
		int ans = 0;
		int green_signal_ind = s.length();
		
		for(int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) == 'g') {
				green_signal_ind = i;
			}
			
			if(s.charAt(i) == c) {
				ans = Math.max(ans, green_signal_ind - i);
			}
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t > 0) {
			solve(sc);
			t--;
		}

	}

}
