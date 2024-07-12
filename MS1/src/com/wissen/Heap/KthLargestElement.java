package com.wissen.Heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

	public static int findKthLargest(int[] arr, int k) {
		Queue<Integer> pq = new PriorityQueue<Integer>();
		//build min heap of size k
		for(int i=0; i<k; i++) {
			pq.offer(arr[i]);
		}
		
		for(int i=k; i<arr.length; i++) {
			if(arr[i] > pq.peek()) {
				//remove top element of queue & then add current element of arr
				pq.poll();
				pq.add(arr[i]);
			}
		}
		return pq.peek();
	}

	public static void main(String[] args) {
		int[] arr = {3,2,1,5,6,4};
		int k = 2;
		int ans = findKthLargest(arr, k);
		System.out.println(ans);

	}

}
