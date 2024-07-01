package com.wissen;

import java.util.*;
public class FibonacciSeriesInTheRange {

	public static List<Integer> fib(int start, int end) {
		List<Integer> list = new ArrayList<Integer>();
		int first = 0;
		int second = 1;
		int sum = first+second;
		
		//edge case
		if(start == 0) 
			list.add(first);
			list.add(second);
		
		while(sum <= end) {
			if(sum >= start) {
				list.add(sum);
			}
			first = second;
			second = sum;
			sum = first + second;
		}
		return list;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(fib(n, m));
	}

}
