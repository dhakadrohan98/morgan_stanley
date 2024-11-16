package com.codoeforces.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Monsters {
	
	static class Pair {
		int first;
		int second;
		
		Pair() {}

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
		
	}
	
	static class SortPair implements Comparator<Pair> {

		@Override
		public int compare(Pair p1, Pair p2) {
			if(p1.first == p2.first) {
				return p1.second - p2.second;
			}
			return p2.first - p1.first;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		List<List<Integer>> result = new ArrayList<>();

		while (t > 0) {
			// number of monsters
			int n = sc.nextInt();
			// damage magnitude by Monocarp abilities in a single shot
			int k = sc.nextInt();
			int[] arr = new int[n];
			Pair[] pair = new Pair[n];
			// initial health points of n no. of monsters
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();		 
			}
			//create pair class with negative modulo(arr[i] % k) values as first & (indx+1) as second
			for(int i = 0; i < n; i++) {
				int modulo_neg_element = (arr[i] % k == 0 ? k : arr[i] % k);
				pair[i] = new Pair(modulo_neg_element, i+1);
			}
			
			//sort the pair class
			Arrays.sort(pair, new SortPair());
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(pair[i].second);
			}
			result.add(new ArrayList<>(list));
			t--;
		}
		
		//print the ans
		for(List<Integer> list : result) {
			for(int val : list) {
				System.out.print(val + " ");
			}
			System.out.println();
		}

	}

}

/*
 * 
  	I1
	3 2
	1 2 3
	
	o/p : 2 1 3 
	
	I2
	4 3
	2 8 3 5
	
	o/p: 3 1 2 4
	
	I3
	2 3
	1 1
	
	o/p: 1 2
	
	Combined test case:
	
	3
	3 2
	1 2 3
	2 3
	1 1
	4 3
	2 8 3 5
	
	o/p- 2 1 3 
		 1 2 
		 3 1 2 4 
 */
