package com.wissen.sorting;

import java.util.Map.Entry;
import java.util.*;

//sorting in descending order
public class SortHashMapOnValuesLambdaExpression {

	public static void main(String[] args) {
		HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 100);
        hashMap.put("B", 80);
        hashMap.put("C", 60);
        hashMap.put("D", 40);
        hashMap.put("E", 20);

        for(Entry<String, Integer> map: hashMap.entrySet()) {
        	map.getValue();
        	map.getKey();
        }
        // Create a list from the HashMap entries
        List<Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());

        // Sort the list by values
        Collections.sort(list, (o1, o2) -> o1.getValue()-  o2.getValue());

        // Create a new HashMap from the sorted list
        HashMap<String, Integer> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }

        // Print the sorted HashMap
        for (Map.Entry<String, Integer> entry : sortedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

	}

}
