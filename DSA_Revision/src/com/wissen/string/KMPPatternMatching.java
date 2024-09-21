package com.wissen.string;

public class KMPPatternMatching {
	
	//TC: O(n + 3*n)
	//SC: O(n)
	//LPS: length of the longest proper prefix which is also a proper suffix.
	public static int[] computerLPSArray(String str) {
		int n = str.length();
		int[] lps = new int[n];
		
		int len = 0;
		int i = 1;
		
		lps[0] = 0;
		
		while(i < n) {
			if(str.charAt(i) == str.charAt(len)) {
				len++; // lps[i-1] + 1;
				lps[i] = len;
				i++;
			}
			else {
				if(len > 0) {
					len = lps[len-1];
				}
				else {
					lps[i] = 0; //no lps is forming when current character is included
					i++;
				}
			}
		}
		return lps;
	}
	
	//TC: O(n + 3*n)
	//SC: O(n)
	public static int KMPSearch(String text, String pat) {
		// pat#text
		String concated = pat+"#"+text;
		int[] lps = computerLPSArray(concated);
		
		int count = 0;
		int patLength = pat.length();
		int textLen = text.length();
		
		for(int i=0; i < lps.length; i++) {
			if(lps[i] == patLength) {
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		String text = "ABABDABACDABABCABAB";
		String pat = "ABAB";
		System.out.println(KMPSearch(text, pat));
	}
}
