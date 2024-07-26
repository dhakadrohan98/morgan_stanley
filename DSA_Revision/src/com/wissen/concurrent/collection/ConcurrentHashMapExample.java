package com.wissen.concurrent.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapExample {

	public static void main(String[] args) {
		Map<Integer, String> hmap = new ConcurrentHashMap<>();
		
		hmap.put(1, "Alice");
		hmap.put(2, "Bob");
		hmap.put(3, "Charlie");

		System.out.println("Size: " + hmap.size());
		// Retrieve a value by key
        System.out.println("Value for key 2: " + hmap.get(2));
        hmap.put(2, "Updated Bob");
        System.out.println(hmap);
        
        //remove key 2
        hmap.remove(2);
        System.out.println("Size: " + hmap.size());
        System.out.println(hmap);
        
        String zeroKey = hmap.remove(0);
        System.out.println(zeroKey);

	}

}
