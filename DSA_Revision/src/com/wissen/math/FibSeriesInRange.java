package com.wissen.math;
import java.util.ArrayList;
import java.util.List;
public class FibSeriesInRange {
	private static void printFibonacci(int num) {
		int i = 0, j = 1;
		System.out.print(i + ", " + j + ", ");
		int counter = 1;

		while (counter < num - 1) {
			int sum = i + j;
			System.out.print(sum + ", ");
			i = j;
			j = sum;
			counter++;
		}
	}

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
		List<Integer> fibInRange = getFibInRange(5, 90);
		System.out.println(fibInRange);

	}

}
