package com.wissen.heap;

import java.util.*;
import java.util.Map.Entry;
//import java.util.stream.Stream;

public class TopKFrequentElements_Revisited {
	
	//TC: O(n) to build hashmap + O(k * logk) to build the Priority Queue & maintaining it
	//SC: O(n) hmap + O(k) PQ + O(k) result array 

	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> lmap = new LinkedHashMap<>();
		// store elements in linked hash map
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			lmap.put(nums[i], lmap.getOrDefault(nums[i], 0) + 1);
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>(k, (a, b) -> a.freq - b.freq);
		//TC: O(n)
		for (Map.Entry<Integer, Integer> map : lmap.entrySet()) {
			int key = map.getKey();
			int freqVal = map.getValue();

			if (pq.size() < k) {
				pq.offer(new Pair(key, freqVal));
			} else if (pq.peek().freq < freqVal) {
				pq.poll();
				pq.offer(new Pair(key, freqVal));
			}
		}

		//store priority queue elements(top k with its frquence) in result array
		int[] res = new int[k];
		int i=0;
		while(pq.size() > 0 && i < k) {
			res[i++] = pq.poll().num;
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3, 1, 2 };
		int k = 2;
		int[] ans = topKFrequent(nums, k);
		for(int val : ans) {
			System.out.print(val + " ");
		}

	}
}
