package com.wissen.Heap;

import java.util.*;

public class MaxHeap {

	public static void main(String[] args) {
		Queue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		pq.offer(10);
		pq.offer(8);
		pq.offer(7);
		System.out.println(pq);

	}

}
