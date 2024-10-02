package com.wissen.treemap.treeset;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {
		Map<String, Integer> tmap = new TreeMap<>((a,b) -> a.compareToIgnoreCase(b));
		tmap.put("Apple", 10);
		tmap.put("Orange", 80);
		tmap.put("Papaya", 55);
		tmap.put("cocunut", 45);
		tmap.put("banana", 62);
		System.out.println(tmap);

	}

}
