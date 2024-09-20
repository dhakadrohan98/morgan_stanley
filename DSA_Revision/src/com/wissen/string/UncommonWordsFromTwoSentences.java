package com.wissen.string;

import java.util.*;

public class UncommonWordsFromTwoSentences {

	// TC: O(s1 + s2 + 2*k), where k is no. of Uncommon Words from Two Sentences
	// SC: O(2*k)
	public static String[] uncommonFromSentences(String s1, String s2) {
		Map<String, Integer> hmap = new HashMap<>();
		String[] str1 = s1.split(" ");
		String[] str2 = s2.split(" ");

		for (String word : str1) {
			hmap.put(word, hmap.getOrDefault(word, 0) + 1);
		}

		for (String word : str2) {
			hmap.put(word, hmap.getOrDefault(word, 0) + 1);
		}

		List<String> result = new ArrayList<>();

		for (Map.Entry<String, Integer> entry : hmap.entrySet()) {
			if (entry.getValue() == 1) {
				result.add(entry.getKey());
			}
		}
		System.out.println(result);

//        Creating an Array: The new String[0] part creates a new array of String with a length of 0. This is just a placeholder to tell the toArray method the type of array to return.
//        Filling the Array: The toArray method then creates a new array of the same type and size as the List and fills it with the elements from the List.
		return result.toArray(new String[0]);
	}

	public static void main(String[] args) {
		String s1 = "this sweet apple is sweet";
		String s2 = "this apple is sour";
		String[] uncommonFromSentences = uncommonFromSentences(s1, s2);
		for (String s : uncommonFromSentences) {
			System.out.println(s + " ");
		}
	}
}
