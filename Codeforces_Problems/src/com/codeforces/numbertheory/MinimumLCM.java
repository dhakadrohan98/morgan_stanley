package com.codeforces.numbertheory;

import java.util.Scanner;

public class MinimumLCM {

	public static int hcf(int num1, int num2) {
		while (num1 % num2 != 0) {
			int rem = num1 % num2;
			num1 = num2;
			num2 = rem;
		}
		return num2;
	}

	public static int lcm(int num1, int num2) {
		int lcm = (num1 * num2) / hcf(num1, num2);
		return lcm;
	}

	private static void solve(Scanner sc) {
		int n = sc.nextInt();
		//initialize LCM with largest integer value
		int LCM = (int) (Math.pow(2, 11));
		int first_no = 1;
		int second_no = n - 1;
		//find all divisors & lcm (of divisor pair) for n
		for(int d = 2; (d*d) <= n; d++) {
			//first case (b % a = 0)
				//first divisor -> a'
				// n = 12
				// d = 2;
				//a = 2;
			if(n % d == 0) {
				int a = d;
				int b =  n - d;
				//find lcm for current pairs
				int lcm_val = (a*b) / hcf(a, b);
				if(lcm_val < LCM) {
					LCM = lcm_val;
					first_no = a;
					second_no = b;
				}
				
				 	//second divisor -> b'
					// n = 12
					// d = 2;
					//a1 = 12 / 2;
					//a1 = 6;
				int a1 = n / d;
				int b1 = n - a1;
				//find lcm for current pairs
				lcm_val = (a1*b1) / hcf(a1, b1);
				if(lcm_val < LCM) {
					LCM = lcm_val;
					first_no = a1;
					second_no = b1;
				}
			}
		}
		System.out.println(first_no +  " " + second_no);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			solve(sc);
			t--;
		}
	}

}
