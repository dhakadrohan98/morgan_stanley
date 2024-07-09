package com.wissen.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class SortMatrixBasedOnFirstField {

	public static void main(String[] args) {
		String[][] mat = { { "shubham", "55" }, { "shivam", "68" }, { "shubham", "97" }, { "ritika", "97" } };

		Arrays.sort(mat, new Comparator<String[]>() {

			@Override
			public int compare(String[] first, String[] second) {
				return first[0].compareToIgnoreCase(second[0]);
			}
		});

		// Print the sorted array
		for (String[] row : mat) {
			System.out.println(Arrays.toString(row));
		}
	}
}
