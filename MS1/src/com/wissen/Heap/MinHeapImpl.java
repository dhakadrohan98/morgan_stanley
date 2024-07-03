package com.wissen.Heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinHeapImpl {

	public static void main(String[] args) {
		Queue<Integer> pq  = new PriorityQueue<>();
		pq.offer(10);
		pq.offer(50);
		pq.offer(30);
		pq.offer(20);
		pq.offer(75);
		pq.offer(65);
		System.out.println(pq);
		pq.poll();
		System.out.println(pq);

	}

}
