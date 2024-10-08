package com.wissen;

import java.util.*;

public class PrintCharactersFreq {
	//TC: < O(2n)
	//SC: O(1)
	public static void printCharacterFreq(String str) {
		LinkedHashMap<Character, Integer> hmap = new LinkedHashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			hmap.put(ch, hmap.getOrDefault(ch, 0)+1);
		}
		
		for(char key: hmap.keySet()) {
			System.out.print(key +""+ hmap.get(key)+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		String str1 = "elephant";
		printCharacterFreq(str);
		printCharacterFreq(str1);
	}

}
