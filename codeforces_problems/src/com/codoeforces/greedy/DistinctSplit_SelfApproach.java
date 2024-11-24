package com.codoeforces.greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DistinctSplit_SelfApproach {

	private static void solve(Scanner sc, List<Integer> list) {
		//length of string
		int n = sc.nextInt();
		//reading a length n string
		int len = n;
		String s = sc.next();
		// main logic
		Set<Character> set1 = new HashSet<>();
		Set<Character> set2 = new HashSet<>();
		int i = 0, j = s.length()-1;
		while (i <= j && i < s.length() && j >= 0) {
			char ch1 = s.charAt(i);
			// ch1 is present in set1 already then add it to set2 otherwise add it to set1
			// itself.
			if (set1.contains(ch1) && !set2.contains(ch1)) {
				set2.add(ch1);
			} else {
				set1.add(ch1);
			}

			// ch2 is present in set2 already then add it to set1 otherwise add it to set2
			// itself.
			char ch2 = s.charAt(j);
			if(i < j) {
				if (set2.contains(ch2) && !set1.contains(ch2)) {
					set1.add(ch2);
				} else {
					set2.add(ch2);
				}
			}
			// move both pointer towards each other
			i++;
			j--;
		}
		System.out.println(set1);
		System.out.println(set2);
		list.add(set1.size() + set2.size());
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		int t = sc.nextInt();
		while (t-- > 0) {
			solve(sc, list);
		}
		//print the answer
		for(int val : list) {
			System.out.println(val);
		}
	}
}
// last test cases are failing among 5 test cases
//5
//2
//aa
//7
//abcabcd
//5
//aaaaa
//10
//paiumoment
//4
//aazz
