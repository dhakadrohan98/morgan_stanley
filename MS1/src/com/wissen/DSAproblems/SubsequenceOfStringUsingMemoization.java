package com.wissen.DSAproblems;

import java.util.*;

public class SubsequenceOfStringUsingMemoization {

	static Map<String, List<String>> hmap = new HashMap<>();
	
	public static List<String> longestPalindromeSubseq(String s) {
        int i = 0;
        String result = "";
        return generateSubsequences(s, i, result, hmap);
    }
	
	public static List<String> generateSubsequences(String s, int i, String result, Map<String, List<String>> hmap) {
		List<String> subsequences = new ArrayList<String>();
		
		String key = i+result;
        //base case
        if(i >= s.length()) {
        	 subsequences.add(result);
             return subsequences;
        }
        
        if(hmap.containsKey(key)) {
        	return hmap.get(key);
        }

        //Include the current character (pick)
       List<String> pick = generateSubsequences(s, i+1, result + s.charAt(i), hmap);
       if(!hmap.containsKey(key)) {
    	   hmap.put(key, pick);
       }
       subsequences.addAll(pick);
       //Exclude the current character (not pick)
       List<String> notpick = generateSubsequences(s, i+1, result, hmap);
       if(!hmap.containsKey(key)) {
    	   hmap.put(key, notpick);
       }
       subsequences.addAll(notpick);
       //List<String> subsequences
       return subsequences;
        
    }
	
	public static void main(String[] args) {
		String s = "bbbab";
		List<String> subsequences = longestPalindromeSubseq(s);
		System.out.println(hmap);
		for(String str:subsequences) {
			System.out.println(str);
		}

	}

}
