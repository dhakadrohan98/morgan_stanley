package com.wissen;

import java.util.*;
//TC: O(n^2)
//SC: O(n^2)
//Note: last three test cases on LC didn't pass
public class CountTotalPalindromeSubstringRohanSolution {

	public static int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        Map<String, Boolean> hmap = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++){
                if(isPalindrome(s, i, j, hmap)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private static boolean isPalindrome(String s,int i,int j,Map<String, Boolean> hmap) {
        String key = i+""+j;
        //base case
        if(i >= j) {
            return true;
        }
        //checking into hmap for the key(i,j)
        if(hmap.containsKey(key)) {
            return hmap.get(key);
        }
        
        if(s.charAt(i) ==  s.charAt(j)) {
            boolean palindrome = isPalindrome(s, i+1, j-1, hmap);
            //memoization using hmap
            hmap.put(key, palindrome);
            return palindrome;
        }
        else {
            //memoization using hmap
            hmap.put(key, false);
            return false;
        }
        
    }
    
	public static void main(String[] args) {
		String str = "madam";
		System.out.println(countSubstrings(str));

	}

}
