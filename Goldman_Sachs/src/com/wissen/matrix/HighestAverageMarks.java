package com.wissen.matrix;

import java.util.*;
import java.util.Map.Entry;

public class HighestAverageMarks {

	//TC: O(n^2)
	//SC: O(n^2)
	
	public static int highestAvgMarks(String[][] mat) {
		int highest = Integer.MIN_VALUE;
		Map<String, List<Integer>> hmap = new HashMap<>();
		int highestAvg = 0;
		
		for(int i=0; i<mat.length; i++) {
			String name = mat[i][0];
			int val = Integer.valueOf(mat[i][1]);
			if(hmap.containsKey(name)) {
				List<Integer> temp = hmap.get(name);
				temp.add(val);
				hmap.put(name, temp);
			}
			//if hmap doesn't contain key
			else {
				List<Integer> temp = new ArrayList<>();
				temp.add(val);
				hmap.put(name, temp);
			}
		}
//		System.out.println(hmap);
		
		//Iterate through entry set
		for(Entry<String,List<Integer>> map: hmap.entrySet()) {
			String key = map.getKey();
			List<Integer> list = map.getValue();
			int sum = 0;
			int count = 0;
			for(int val : list) {
				sum += val;
				count++;
			}
			highestAvg = Math.max(highestAvg, sum/count);
		}

		return highestAvg;
	}

	public static void main(String[] args) {
		String[][] mat = new String[4][2];
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[i].length; j++) {
				mat[i][j] = sc.next();
			}
		}
		
		int ans = highestAvgMarks(mat);
		System.out.println(ans);
	}
}

//Sample input for Highest Average of marks
//i/p: 1
//shubham 55
//shivam 68
//shubham 97
//ritika 97

// i/p: 2
//Karan, 55
//Shivam, 68
//Karan, 97
//dummy, 0
