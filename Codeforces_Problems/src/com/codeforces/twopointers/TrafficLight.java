package com.codeforces.twopointers;

import java.util.Scanner;

//TC: O(2*n)
//where 1 <= n <= 2 * 10^5
//Time limit exceed solution
public class TrafficLight {

	private static void solve(Scanner sc) {
		int n = sc.nextInt();
		//read character
		char c = sc.next().charAt(0);
		String s = sc.next();
		String ss = s + s;
		int[] arr = new int[2*n];
		//we need three pointers
		int i=0, j=0;
		while(i < (2*n)) {
			int curr_gap = 0;
			
			if(ss.charAt(i) == c) {
				
				//check for edge case
				if(s.length() == 1) {
					break;
				}
				j = i;
				while(i < ((2*n)) && ss.charAt(i) != 'g') {
					i++;
					curr_gap++;
				}
				//if curr char at ith(ss) index is g after encountering with character c 
				arr[j++] = curr_gap;
			} else {
				i++;
				j++;
			}
		}
		
		//take the maximum value from arr which will be the number of seconds that we are guaranteed to cross 
		//the road
		int min_sec = Integer.MIN_VALUE;
		for(int val : arr) {
			min_sec = Math.max(val, min_sec);
		}
		System.out.println(min_sec);
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

/*
 * test case 1:
TC: 1
5 r
rggry

TC: 3
3 r
rrg

TC: 4
5 y
yrrgy

TC: 5
7 r
rgrgyrg

TC: 6
9 y
rrrgyyygy
*/
