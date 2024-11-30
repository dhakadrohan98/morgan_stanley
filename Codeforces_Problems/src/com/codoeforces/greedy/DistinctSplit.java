package com.codoeforces.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DistinctSplit {

	private static void solve(Scanner sc, List<Integer> ans) {
		// length of string
		int n = sc.nextInt();
		// reading a length n string
		int len = n;
		String s = sc.next();
		
		// Main logic
		//contains the  second substring of splited string: f(b)
		Map<Character, Integer> hmap1 = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			hmap1.put(ch, hmap1.getOrDefault(ch, 0) + 1);
		}
		
		Map<Character, Integer> hmap2 = new HashMap<>();
		int maxi = 0;
		//contains the  first substring of splited string : f(a)
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			//include current character into first part of splitted string s
			hmap2.put(ch, hmap2.getOrDefault(ch, 0) + 1);
			
			if(hmap1.containsKey(ch) && hmap1.get(ch) > 0) {
				hmap1.put(ch, hmap1.get(ch) - 1);
				//if curr ch will not be included in 2nd part then remove this key
				if(hmap1.get(ch) == 0) {
					hmap1.remove(ch);
				}
			}
			maxi = Math.max(maxi, hmap2.size() + hmap1.size());
		}
		//add res into ans list
		ans.add(maxi);
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> ans = new ArrayList<>();
		int t = sc.nextInt();
		while (t-- > 0) {
			solve(sc, ans);
		}
		// print the answer
		for (int val : ans) {
			System.out.println(val);
		}
	}
}

//codeforces test case1:
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

// o/p:
//2
//7
//2
//10
//3