package com.wissen.DSAproblems;

import java.util.*;

public class FibonacciNumbersInTheRange {

//	0,1,1,2,3....
	// 1 to 50
	// 2-7
	// 4-9

	// 2,3,5,8,13,21,34

	// 4,5,9,14,23
	public static void main(String[] args) {

		LinkedHashMap<Integer, Integer> hmap = new LinkedHashMap<Integer, Integer>();
		List<Integer> list = new ArrayList<Integer>();
		int n = 1000000;
		int first = 0;
		int second = 1;
//		list.add(0);
//		list.add(1);
//
//		for (int i = 1; i <= n - 2; i++) {
//			int sum = first + second;
//			list.add(sum);
//			first = second;
//			second = sum;
//		}
		
		hmap.put(0, 0);
		hmap.put(1, 1);
		for(int i=3; i<=n-2; i++) {
			fib(i, hmap);
		}
		
		System.out.println(hmap);
		
//		List<Integer> fibonacciInRange = fibonacciInRange(1, 50, list);
//		System.out.println(fibonacciInRange);
	}
	
//	public static List<Integer> fibonacciInRange(int start, int end,List<Integer> list ) {
//		List<Integer> result = new ArrayList<Integer>();
//		for(int count = start; count <= end; count++) {
//			if(list.contains(count)) {
//				result.add(count);
//			}
//		}
//		return result;
//	}

	//memoization
	public static int fib(int n, Map<Integer, Integer> hmap) {
		
		if(n==0 || n==1) {
			return 1;
		}
		
		if(hmap.containsKey(n)) {
			return hmap.get(n);
		}
		
		int left = fib(n-1, hmap);
		int right = fib(n-2, hmap);
		hmap.put(n, left+right);
		return n;
	}

}
