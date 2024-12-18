package com.wissen.array;

import java.util.*;

public class FibonacciInGivenRange {

	//TC: < O(n)
	//SC: O(1)
	public static List<Integer> fibonacciRange(int start, int end) {
		List<Integer> result = new ArrayList<Integer>();
		int first = 0;
		int second = 1;
		int sum = first + second;
		
		while(sum <= end) {
			if(sum >= start) {
				result.add(sum);
			}
			first = second;
			second = sum;
			sum = first + second;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		System.out.println("Print all fibonacci b/w " + start+ " and "+ end + " numbers");
		System.out.println(fibonacciRange(start, end));
		
		
		
	}

}
