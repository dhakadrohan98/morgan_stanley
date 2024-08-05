package com.wissen.heap;

import java.util.*;

public class FindMedianfromDataStream {
	private PriorityQueue<Integer> leftMaxHeap;
	private PriorityQueue<Integer> rightMinHeap;

	public FindMedianfromDataStream() {
	        leftMaxHeap =new PriorityQueue<>(Collections.reverseOrder());
	        rightMinHeap = new PriorityQueue<>();    
	    }

	public void addNum(int num) {
		if (leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()) {
			leftMaxHeap.offer(num);
		} else {
			rightMinHeap.offer(num);
		}

		// always maintain leftMaxHeap size one greater than rightMinHeap size
		// or both sizes equal
		if(leftMaxHeap.size() > rightMinHeap.size() + 1) {
			rightMinHeap.offer(leftMaxHeap.poll());
		} else if (leftMaxHeap.size() < rightMinHeap.size()) {
			leftMaxHeap.offer(rightMinHeap.poll());
		}
	}

	public double findMedian() {
		// if both heap sizes are equal
		if (leftMaxHeap.size() == rightMinHeap.size()) {
			// even number of elements
			return (double) (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
		}

		// odd number of elements
		return leftMaxHeap.peek();
	}
	
//	Input
//	["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//	[[], [1], [2], [], [3], []]
//	Output
//	[null, null, null, 1.5, null, 2.0]
}
