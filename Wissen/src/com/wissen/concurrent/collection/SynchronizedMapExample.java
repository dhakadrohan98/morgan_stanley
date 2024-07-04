package com.wissen.concurrent.collection;

//Java program to demonstrate 
//synchronizedMap() method 
//for <String, String> Value 

import java.util.*;

public class SynchronizedMapExample {
	public static void main(String[] argv) throws Exception {

		try {

			// creating object of Map<String, String>
			Map<String, String> map = new HashMap<String, String>();

			// populate the map
			map.put("Value1", "20");
			map.put("Value2", "30");
			map.put("Value3", "40");

			// printing the Collection
			System.out.println("Map : " + map);

			// create a synchronized map
			Map<String, String> synmap = Collections.synchronizedMap(map);

			// printing the Collection
			System.out.println("Synchronized map is : " + synmap);
		}

		catch (IllegalArgumentException e) {
			System.out.println("Exception thrown : " + e);
		}
	}
}
