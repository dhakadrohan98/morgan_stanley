package com.wissen.twopointers;

import java.util.*;

//Longest Word in Dictionary through Deleting  
//Given a string s and a string array dictionary, return the longest string in the 
//dictionary that can be formed by deleting some of the given string characters. 
//If there is more than one possible result, return the longest word with the smallest 
//lexicographical order. If there is no possible result, return the empty string. 
// 
//Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"] 
//Output: "apple" 
//Input: s = "abpcplea", dictionary = ["a","b","c"] 
//Output: "a" 

public class LongestWordInDictionary {

	 public static String findLongestWord(String s, List<String> dictionary) {
			int longest = 0;
			String res = "";
			int j = 0;
			while (j < dictionary.size()) {
				String word = dictionary.get(j);
				int i = 0, k = 0;
				if(isSubsequence(s, word)) {
	                if (longest < word.length() || (word.length() == longest && word.compareTo(res) < 0)) {
					    longest = Math.max(longest, word.length());
					    res = word;
				    }   
	            }
				j++;
			}
	        return res;
	    }
	    
	    private static boolean isSubsequence(String s,String word) {
	        int i=0;
	        for(char ch : s.toCharArray()) {
	            if(i < word.length() && ch == word.charAt(i)) {
	                i++;
	            }
	        }
	        return i == word.length();
	    }

	public static void main(String[] args) {
		String s = "abpcplea";
		List<String> list = Arrays.asList("ale", "apple", "monke", "plea");

		String s1 = "abce";
		List<String> list1 = Arrays.asList("abe", "abc");
		String longestWord = findLongestWord(s, list);
		System.out.println(longestWord);

	}

}

//List<Dictionary> list = new ArrayList<Dictionary>();
//for(int i=0; i<str.length; i++) {
//	int len = str[i].length();
//	Dictionary d = new Dictionary(str[i], len);
//	list.add(d);
//}
//
//Collections.sort(list, new DictionaryComparator());
////required word to match
//Dictionary dd = list.get(0);
//String mat = dd.word;

//public static void longestWord(String s, String mat) {
//	int m = s.length();
//	int n = mat.length();
//	StringBuilder sb = new StringBuilder();
//	rec(m-1, sb, s, mat);
//}
//
//private static void rec(int indx, String temp, String s, String mat) {
//	// base case
//	if(indx < 0) {
//		return;
//	}
//	
//	//include current character
//	temp += s.charAt(indx) + rec(indx-1, sb, s, mat);
//	//if current string builder is equal to mat then print it & return from here.
//	if(mat.equals(sb.toString())) {
//		System.out.println("Matching string: " + sb.toString());
//		System.out.println("Longest length: " + mat.length());
//	}
//	
//	//exclude current character
//	temp += rec(indx-1, sb, s, mat);
//}
//
//public static void main(String[] args) {
//	String s = "abpcplea";
//	String[] str = {"ale","apple","monke","plea"};
//	List<Dictionary> list = new ArrayList<Dictionary>();
//	for(int i=0; i<str.length; i++) {
//		int len = str[i].length();
//		Dictionary d = new Dictionary(str[i], len);
//		list.add(d);
//	}
//	
//	Collections.sort(list, new DictionaryComparator());
//	//required word to match
//	Dictionary dd = list.get(0);
//	String mat = dd.word;
//	
//	longestWord(s, mat);
//	
//}
