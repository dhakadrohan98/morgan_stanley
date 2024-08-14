package com.wissen.math;

import java.util.*;
public class PascalTriangle {
	
	//TC: O(n^2)
	//SC: O(n^2) to store each computed element for res
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row, pre = null;
        for(int i = 0; i < numRows; i++) {
            row = new ArrayList<>();
            //compute all column for curr row with the help of prev row
            for(int j=0; j<=i; j++) {
                if(j == 0 || j == i) {
                    row.add(1);
                }
                else {
                    row.add(pre.get(j-1) + pre.get(j));
                }
            }
            //assign curr row to prev for next row calculation
            pre = row;
            //add the curr computed row to res
            res.add(row);
        }
        return res;
    }
	
	public static void main(String[] args) {
		int numRows =  5;
		System.out.println(generate(numRows));

	}

}
