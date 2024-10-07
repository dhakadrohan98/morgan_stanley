package com.wissen.hashmap.keys_values_sorting.internalworking;

import java.util.*;

//sort the hashmap based on values in descending order
public class SortHashMapOnValuesEx2 {

	public static void main(String[] args) {
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("A", 100);
		hashMap.put("B", 20);
		hashMap.put("C", 60);
		hashMap.put("D", 40);
		hashMap.put("E", 15);
		System.out.println("Unsorted map: " + hashMap);
		
		List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());
		
		Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
		
		Map<String, Integer> lhmap = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> entry : list) {
			lhmap.put(entry.getKey(), entry.getValue());
		}
		
		System.out.println("Sorted map: " + lhmap);

	}

}
