package com.wissen.DSAproblems;

import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters {

	//TC: O(n)
    //SC: O(n)
    public int lengthOfLongestSubstring(String str) {
        //base case
        if(str.length() <= 1) {
            return str.length();
        }
        Set<Character> set= new HashSet<>();
        int longest = Integer.MIN_VALUE;
        int i=0, j=0;
        
         while (j < str.length()) {
            if (!set.contains(str.charAt(j))) {
                set.add(str.charAt(j));
                longest = Math.max(longest, j - i + 1);
                j++;
            } else {
                set.remove(str.charAt(i));
                i++;
            }
        }
        return longest;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
