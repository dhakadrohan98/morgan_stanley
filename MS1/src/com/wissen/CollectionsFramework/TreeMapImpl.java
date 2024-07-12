package com.wissen.CollectionsFramework;

import java.util.*;
import java.util.SortedMap;

public class TreeMapImpl {

	public static void main(String[] args) {
		SortedMap<String, Integer> tmap = new TreeMap<>(Collections.reverseOrder());
		tmap.put("zakhir", 3);
		tmap.put("rahul", 2);
		tmap.put("sakshi", 10);
		System.out.println(tmap);

	}

}
