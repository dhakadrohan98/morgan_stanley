package com.wissen.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentElement_StreamAPI {

	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> hmap = new HashMap<>();
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
		}
		
		return hmap.entrySet().stream()
			.sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
			.map(e -> e.getKey())
			.limit(k)
			.mapToInt(Integer::intValue)
			.toArray();
		
//		return collect.stream().mapToInt(Integer::intValue).toArray();
		
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3}, 2)));

	}

}
