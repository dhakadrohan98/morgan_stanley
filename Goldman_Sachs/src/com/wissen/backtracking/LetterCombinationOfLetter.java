package com.wissen.backtracking;

import java.util.*;
public class LetterCombinationOfLetter {
	
	//TC: O(n * 4^n) loop + recursion tree
    //SC: O(n) stack space
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> ans = new ArrayList<>();
        if(n == 0) {
            return ans;
        }
        Map<Character, String> hmap = new HashMap<>();
        hmap.put('2', "abc");
        hmap.put('3', "def");
        hmap.put('4', "ghi");
        hmap.put('5', "jkl");
        hmap.put('6', "mno");
        hmap.put('7', "pqrs");
        hmap.put('8', "tuv");
        hmap.put('9', "wxyz");
        //start with 0 index of String
        backtrack(digits, 0, hmap, new StringBuilder(), ans);
        return ans;
    }
    
    private static void backtrack(String digits, int i, Map<Character, String> hmap, StringBuilder sb, List<String> ans) {
        //base case, if i reached end of string
        if(i == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        
        //store current digits string into curr to iterate over through 
        String curr = hmap.get(digits.charAt(i));
        //abc
        //def
        // a -> d, e, f
        // b -> d, e, f
        //c -> d, e, f
        //3*3 combinations will be generated
        for(int k=0; k < curr.length(); k++) {
            sb.append(curr.charAt(k));
            //move one step ahead on current digit's character
            backtrack(digits, i+1, hmap, sb, ans);
            //remove last character from StringBuilder while backtrack
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
