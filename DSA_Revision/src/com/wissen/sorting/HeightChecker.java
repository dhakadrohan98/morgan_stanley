package com.wissen.sorting;

import java.util.Arrays;

public class HeightChecker {
	// optimal approach
	// TC: O(4*n)
	// SC: O(n+ |max+1|) clone arr & freq map
	public static int heightChecker(int[] heights) {
		int n = heights.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		// find min & max
		for (int i = 0; i < n; i++) {
			min = Math.min(min, heights[i]);
			max = Math.max(max, heights[i]);
		}
		// build freq map
		int[] freqMap = new int[max + 1];
		for (int i = 0; i < n; i++) {
			freqMap[heights[i]]++;
		}
		//clone the original array heights
		int[] expected = new int[n];
		for (int i = 0; i < n; i++) {
			expected[i] = heights[i];
		}
		//Building sorting sequence
		int i = 0;
		while (min < freqMap.length) {
			while (freqMap[min] != 0 && i < n) {
				expected[i] = min;
				i++;
				freqMap[min]--;
			}
			min += 1;
		}
		int count = 0;
		for (int k = 0; k < n; k++) {
			if (heights[k] != expected[k]) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = {1,1,4,2,1,7};
		System.out.println(heightChecker(nums));
		
		int[] nums2 = {5,1,2,3,4};
		System.out.println(heightChecker(nums2));
		
		int[] nums3 = {1,2,3,4,5};
		System.out.println(heightChecker(nums3));
	}
}

//Brute approach
//TC: O(n^2) + O(2^n)
//SC: O(2n)
//public int heightChecker(int[] heights) {
//    int n = heights.length;
//    int[] nums = new int[n];
//    for(int i=0; i<n; i++) {
//        nums[i]= heights[i];
//    }
//    Arrays.sort(nums);
//    
//    int count = 0;
//    for(int i=0; i<n; i++) {
//        if(heights[i] != nums[i]) {
//            count++;
//        }
//    }
//    return count;
//}

//The time complexity of Arrays.sort() in Java depends on the data type of the array:
//For primitive arrays (e.g., int[], double[]):
//Arrays.sort() uses a Dual-Pivot Quicksort algorithm, which has an average time complexity of O(n log n).
//The worst-case time complexity is O(n^2), but this is rare.
//For object arrays (e.g., Integer[], String[]):
//Arrays.sort() uses a TimSort algorithm, which is a hybrid of Merge Sort and Insertion Sort.
//It has a time complexity of O(n log n) in all cases, making it more stable than Quicksort.
//In summary, the average time complexity of Arrays.sort() in Java is O(n log n), which makes it an efficient sorting algorithm for most use cases.
