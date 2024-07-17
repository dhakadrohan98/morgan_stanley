package com.wissen.two.pointers;

import java.util.*;
public class LongestWordInDictionaryThroughDeleting {
    //TC: O(m*n), m-> length of s & n-> max length of dictionary words
    //SC: O(1)
	public static String findLongestWord(String s, List<String> dictionary) {
		int maxi = 0;
		int len = 0;
		int n = dictionary.size();
		int n1 = s.length();
		String res = "";
		
		for(int i=0; i<n; i++) {
			String str =dictionary.get(i);
			int j=0, k=0;
			int count = 0;
			while(j < n1 && k < str.length()) {
				if(s.charAt(j) == str.charAt(k)) {
					count++;
					k++;
					j++;
				} else {
					j++;
				}
			}
			
			//calculate for larger length & lexicographically small if lengths are same
			if(count == str.length()) {
				if(maxi < count) {
					res = str;
					maxi = count;
				} else if(maxi == count) {
					//if res string is greater than current dictionary word
					if(res.compareTo(str) < 0) {
						res = res;
					} else {
						res = str;
					}
				}
			}
			
		}
		return res;
	}

	public static void main(String[] args) {
		String str = "abpcplea";
		List<String> list = Arrays.asList("ale", "apple", "abpcl", "plea");
		
		List<String> list1 = Arrays.asList("a", "b", "c");
		String longestWord = findLongestWord(str, list1);
		System.out.println(longestWord);
	}

}
