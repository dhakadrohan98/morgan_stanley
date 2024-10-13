//Sort2DArrayInterval
package com.wissen.sorting;

import java.util.Arrays;

public class Sort2DArrayInterval {

	public static void main(String[] args) {
        int[][] intervals = {
            {5, 10},
            {6, 8},
            {1, 5},
            {2, 3},
            {1, 10}
        };

        // Sort the 2D array based on the starting point of each interval
        Arrays.sort(intervals, (a, b) -> {
        	if(a[0] == b[0]) {
        		return a[1] - b[1];
        	}
        	return a[0] - b[0];
        });

        // Print the sorted 2D array
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
