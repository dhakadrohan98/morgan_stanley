package com.wissen.dsa2;

import java.util.*;
import java.util.Map.Entry;

public class CharacterWithTheirFreq {
	
	//TC: O(n)
	//SC: O(1)
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		Map<Character, Integer> hmap = new LinkedHashMap<>();
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			hmap.put(ch, hmap.getOrDefault(ch, 0)+1);
		}
		System.out.println(hmap);
		
		for(Entry<Character, Integer> map: hmap.entrySet()) {
			System.out.print(map.getKey() + "" + map.getValue() + " ");
		}
		

	}

}
