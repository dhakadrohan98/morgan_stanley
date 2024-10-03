package com.wissen.hashmap.keys_values_sorting.internalworking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortHashMapOnValuesWithoutUsingStreamAPI {

	public static void main(String[] args) {
		Map<String, Integer> hmap = new HashMap<>();
		hmap.put("book1", 2);
		hmap.put("book2", 4);
		hmap.put("book3", 6);
		hmap.put("book4", 8);
		hmap.put("book5", 3);
		hmap.put("book6", 5);
		hmap.put("book7", 7);
		hmap.put("book8", 1);
		//print unsorted Map entry set
		System.out.println("Before sorting");
		for(Map.Entry<String, Integer> map : hmap.entrySet()) {
			System.out.println("key : " + map.getKey() + " | value : " + map.getValue());
		}
		System.out.println();
		
		//Sort the map based on values in descending order
		List<Map.Entry<String, Integer>> list = new ArrayList<>(hmap.entrySet());
		//sort the map based on values using comparator and 
		Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
		//Store sorted map entries into new LinkedHashMap to maintain the sort order.
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> map : list) {
			sortedMap.put(map.getKey(), map.getValue());
		}
		
		System.out.println("After sorting");
		for(Map.Entry<String, Integer> map : sortedMap.entrySet()) {
			System.out.println("key : " + map.getKey() + " | value : " + map.getValue());
		}
	}
}
