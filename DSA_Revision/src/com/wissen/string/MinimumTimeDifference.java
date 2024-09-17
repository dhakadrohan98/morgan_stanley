package com.wissen.string;

import java.util.*;
public class MinimumTimeDifference {
	
	//TC : O(n^2 due to quick sort)
	//SC : O(n)
	public static int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] minutes = new int[n];

        // Convert timePoints to minutes
        for (int i = 0; i < n; i++) {
            String time = timePoints.get(i);
            String[] parts = time.split(":");

            int hours = Integer.parseInt(parts[0]);
            int mins = Integer.parseInt(parts[1]);

            minutes[i] = hours * 60 + mins;
        }

        // Sort the minutes array
        Arrays.sort(minutes);

        // Initialize result with the maximum possible value
        int result = Integer.MAX_VALUE;

        // Find the minimum difference between adjacent times
        for (int i = 1; i < n; i++) {
            result = Math.min(result, minutes[i] - minutes[i - 1]);
        }

        // Check the circular case (between the first and last times)
        result = Math.min(result, (24 * 60 - minutes[n - 1]) + minutes[0]);
        return result;
    }
	
	public static void main(String[] args) {
		String[] str = {"05:00", "11:00", "07:34", "07:00", "11:30"};
		String[] str1 = {"23:59","00:00"};
		
		List<String> minutes = Arrays.asList(str1);
		System.out.println(findMinDifference(minutes));

	}

}
