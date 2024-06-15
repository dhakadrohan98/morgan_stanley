package com.wissen.FlatternedArray;

import java.util.*;
public class ArrayFlatterner {

	public static List<Integer> flattern(Integer[][] nums){
		List<Integer> result = new ArrayList<Integer>();
		
		for(Integer[] secondArr : nums) {
			  result.addAll(Arrays.asList(secondArr));
		}
		return result;
	}
	public static void main(String[] args) {
		Integer[][] nums = {{1, 2, 3}, {4, 5}, {6, 7, 8}};
		System.out.println(flattern(nums));
	}

}