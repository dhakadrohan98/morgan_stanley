package com.wissen.sorting;

import java.util.*;
import java.util.Map.Entry;

class Sorting implements Comparator<Map.Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> hmap1, Entry<String, Integer> hmap2) {
		return hmap2.getValue() - hmap1.getValue();
	}
	
}
public class SortHashMapValues {

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
		List<Map.Entry<String, Integer>> list = new ArrayList<>(hmap.entrySet());
		Collections.sort(list, new Sorting());
		//copy from list to LinkedHashMap to maintain the order
		Map<String, Integer> lhs = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> map: list) {
			lhs.put(map.getKey(), map.getValue());
		}
		System.out.println(lhs);

	}
}
