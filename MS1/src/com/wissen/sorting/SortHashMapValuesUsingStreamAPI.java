package com.wissen.sorting;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SortHashMapValuesUsingStreamAPI {

	public static void main(String[] args) {
		Map<String, Integer> hmap = new HashMap<>();
		hmap.put("book1", 2);
		hmap.put("book2", 4);
		hmap.put("a", 6);
		hmap.put("A", 8);
		hmap.put("book5", 3);
		hmap.put("book6", 5);
		hmap.put("book7", 7);
		hmap.put("book8", 1);
		
		Map<String, Integer> lhs = new LinkedHashMap<>();
		
		hmap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey().reversed())
		.forEach(entry -> lhs.put(entry.getKey(), entry.getValue()));
		
		System.out.println(lhs);
	}
}
