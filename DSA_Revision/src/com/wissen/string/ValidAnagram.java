package com.wissen.string;

import java.util.*;
public class ValidAnagram {
	
	//TC: O(m+n)
	//SC: O(n)
	public boolean isAnagram(String s, String t) {
        Map<Character, Integer> hmap = new HashMap<>();
        
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
        }
        
        for(int i=0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!hmap.containsKey(ch)) {
                return false;
            }
            hmap.put(ch, hmap.get(ch) - 1);
            if(hmap.get(ch) == 0) {
                hmap.remove(ch);
            }
        }
        
        if(hmap.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
