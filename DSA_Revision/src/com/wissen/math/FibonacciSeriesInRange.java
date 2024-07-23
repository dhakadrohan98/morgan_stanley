package com.wissen.math;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSeriesInRange {
	
	private static List<Integer> getFibInRange(int num1, int num2) {
		List<Integer> list = new ArrayList<>();
		int i = 0, j = 1;
		int sum = i + j;
		while (sum <= num2) { // if sum of two prev. no. is within the range
			if (sum >= num1) {
				list.add(sum);
			}
			// changing two prev pointers
			i = j;
			j = sum;
			sum = i + j;
		}
		return list;
	}
	
	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 90;
		System.out.println(getFibInRange(num1, num2));

	}

}
