package com.wissen.two.pointers;

import java.util.*;
public class KthSmallestPairDistanceBruteForce {
	
	//TC: O(n^2 * logk)
	//SC: O(k) to  maintain max heap to get kth minimum element at top
	public int smallestDistancePair(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        
        // Generate all possible pairs and their absolute differences
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(nums[i] - nums[j]);
                if (minHeap.size() < k) {
                    minHeap.offer(distance);
                } else if (distance < minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(distance);
                }
            }
        }
        
        // The k-th smallest distance will be at the top of the min-heap
        return minHeap.peek();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
