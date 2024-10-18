package com.wissen.CollectionsFramework;

import java.util.*;

public class PriorityQueueImpl {

	public static void main(String[] args) {
		Queue<Integer> pq = new PriorityQueue<Integer>((e1, e2) -> e2 - e1);
		pq.add(10);
		pq.add(8);
		pq.add(7);
		pq.add(12);
		System.out.println(pq);
		System.out.println(pq.peek());
		pq.poll();
		System.out.println(pq);
		System.out.println(pq.peek());

	}

}
