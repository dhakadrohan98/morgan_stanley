package com.wissen.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxHeap {

	public static void main(String[] args) {
		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		pq.add(10);
		pq.add(8);
		pq.add(9);
		pq.add(4);
		pq.add(5);
		pq.add(2);
		pq.add(3);
		System.out.println(pq);

	}

}
