package com.wissen.heap;

import java.util.PriorityQueue;

public class CustomMaxHeapUsingComparator {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 -n1);
		
		pq.offer(19);
		pq.offer(17);
		pq.offer(16);
		pq.offer(21);
		pq.offer(81);
		pq.offer(14);
		
		System.out.println(pq);
		pq.poll();
		System.out.println(pq);

	}

}
