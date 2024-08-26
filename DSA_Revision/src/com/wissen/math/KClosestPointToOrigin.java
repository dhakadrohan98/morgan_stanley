package com.wissen.math;

import java.util.*;

class Pair {
	int x;
	int y;
	double ed;

	public Pair(int x, int y, double ed) {
		this.x = x;
		this.y = y;
		this.ed = ed;
	}
}

public class KClosestPointToOrigin {
	//TC: O(n * (k + logk) )
	//SC: O(k) max heap size + O(k) result array
	public static int[][] kClosest(int[][] arr, int k) {
//		Build the Max heap because we want greatest eclidean distance at the top, So we can compare 
//		with curr elements ed & if curr ed is less than top element's ed then 
//		remove top element from heap & put this new element into our max heap. 
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, (a, b) -> Double.compare(b.ed, a.ed));
		int m = arr.length;

		//O(n * k(build the max heap upto k size) + 2*logk(poll & then offer element))
		for (int i = 0; i < m; i++) {
			int x = arr[i][0];
			int y = arr[i][1];

			double ed = Math.sqrt((x * x) + (y * y));

			if (pq.size() < k) {
				pq.offer(new Pair(x, y, ed));
			} else if (pq.peek().ed > ed) {
				Pair poll = pq.poll();
				pq.offer(new Pair(x, y, ed));
			}
		}

		int[][] res = new int[k][2];
		int i = 0;
		//O(k)
		while (pq.size() > 0 && i < k) {
			Pair pair = pq.poll();
			res[i][0] = pair.x;
			res[i][1] = pair.y;
			i++;
		}

		return res;
	}

	public static void main(String[] args) {
		int[][] arr = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		int k=2;
		int[][] kClosest = kClosest(arr, 2);
		for(int[] temp : kClosest) {
			for(int val : temp) {
				System.out.print(val + " ");
			}
			System.out.println();
		}

	}

}
