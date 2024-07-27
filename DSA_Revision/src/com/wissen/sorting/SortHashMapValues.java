package com.wissen.sorting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortHashMapValues {

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
		
		LinkedHashMap<String, Integer> lhs = new LinkedHashMap<String, Integer>();
		//		for(Map.Entry<String, Integer> map: hmap.entrySet()) {
//			System.out.println(map.getKey() + " : " + map.getValue());
//		}
		
		hmap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).
		forEach(m -> lhs.put(m.getKey(), m.getValue()));
		
		System.out.println(lhs);

	}

}
