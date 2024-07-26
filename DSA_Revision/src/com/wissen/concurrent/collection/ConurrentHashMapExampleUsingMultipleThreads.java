package com.wissen.concurrent.collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.*;

public class ConurrentHashMapExampleUsingMultipleThreads {

	public static void main(String[] args) {
		// Create a ConcurrentHashMap
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

		// Add initial key-value pairs
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
	
		// Simulate multiple threads updating the map
		Runnable updateTask = () -> {
			String key = "A"; // Choose a key for update
			int newValue = map.get(key) + 10; // Increment the value
			map.put(key, newValue); // Update the value
		};

		// Create and start multiple threads
		for (int i = 0; i < 5; i++) {
			new Thread(updateTask).start();
		}

		// Print the final map
		System.out.println("Final map: " + map);

	}

}
