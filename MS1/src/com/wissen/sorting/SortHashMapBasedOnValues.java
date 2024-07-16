package com.wissen.sorting;

import java.util.*;
public class SortHashMapBasedOnValues {

	public static void main(String[] args) {
		HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 100);
        hashMap.put("B", 80);
        hashMap.put("C", 60);
        hashMap.put("D", 40);
        hashMap.put("E", 20);
        
        hashMap.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
        .forEach(hmap -> System.out.println(hmap.getKey() + " : " + hmap.getValue()));
        
        

	}

}
