package com.wissen.math;

import java.util.*;

public class GCD {

	public static int gcd(int num1, int num2) {
		while(num1 % num2 != 0) {
			int rem = num1 % num2;
			num1 = num2;
			num2 = rem;
		}
		return num2;
	}
	
	public static int lcm(int num1, int num2) {
		int lcm = (num1 * num2) / gcd(num1, num2);
		return lcm;
	}

	public static void main(String[] args) {
		int num1 = 36;
		int num2 = 60;

		System.out.println(gcd(num1, num2));
		System.out.println(lcm(num1, num2));
	}

}
