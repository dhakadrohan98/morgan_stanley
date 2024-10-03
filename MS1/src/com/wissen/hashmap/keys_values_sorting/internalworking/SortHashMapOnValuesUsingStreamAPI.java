package com.wissen.hashmap.keys_values_sorting.internalworking;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

//sorting into reverse order
/*
Explanation of above code:

1.Create a HashMap with your desired key-value pairs.
2.Use the entrySet().stream() method to get a stream of the map entries.
3. Sort the stream by values using the sorted() method and the comparingByValue() comparator.
4. If you want the sorting order to be reversed (descending), you can use .reversed().
5. Limit the results to the top N entries (e.g., top 10) using .limit(N).
6. Finally, use a terminal operation (e.g., forEach) to process the sorted entries.
 
 */
public class SortHashMapOnValuesUsingStreamAPI {

	public static void main(String[] args) {
		HashMap<String, Integer> hmap = new HashMap<>();
		hmap.put("A", 12);
		hmap.put("B", 33);
		hmap.put("C", 46);
		hmap.put("D", 56);
		hmap.put("E", 87);

		// Sort by values in descending order and limit to top 10 entries
		hmap.entrySet().stream().sorted(Entry.<String, Integer>comparingByValue().reversed())
		.forEach(entry -> System.out.println(entry.getKey() +" = " + entry.getValue()));
	}
}
