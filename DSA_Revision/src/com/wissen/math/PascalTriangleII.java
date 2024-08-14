package com.wissen.math;

import java.util.*;

public class PascalTriangleII {

	// TC: O(N^2)
	// SC: less than O(N^2)
	public List<Integer> getRow(int rowIndex) {
		List<Integer> prev = new ArrayList<>();
		// go from 0 till rowIndex(3) -> 0,1,2,3
		for (int i = 0; i < rowIndex + 1; i++) {
			List<Integer> curr = new ArrayList<>();
			//iterate from 0 till i+1 index ->  0,1,2,..,i
			for (int j = 0; j < i + 1; j++) {
				//add first & last element as 1 for each row
				if (j == 0 || j == i) {
					curr.add(1);
				} else {
					//add sum of two previous prev[row-1[[col-1] + prev[row-1[[col] elements
					curr.add(prev.get(j) + prev.get(j - 1));
				}
			}
			//make curr row to prev for next row elements calculation or store the result of given rowIndex
			prev = curr;
		}

		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// TC: O(N^2)
	// SC: O(N^2)
	public List<Integer> getRow1(int rowIndex) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> row = new ArrayList<>(), pre = null;
		for (int i = 0; i <= rowIndex; i++) {
			row = new ArrayList<>();
			// compute all column for curr row with the help of prev row
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					row.add(1);
				} else {
					row.add(pre.get(j - 1) + pre.get(j));
				}
			}
			// assign curr row to prev for next row calculation
			pre = row;
			// add the curr computed row to res
			res.add(row);
		}
		return row;
	}

}
