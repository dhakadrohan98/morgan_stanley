package com.wissen;

public class LongestPalindromicSubstring {

	//TC: O(n^2)
    //SC: O(1)
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        int n = s.length();
        
        for(int i=0; i<n; i++) {
            int len1 = expandFromCenter(s,i,i+1);//for even length of string
            int len2 = expandFromCenter(s,i,i);//for odd length of string
            int maxLen = Math.max(len1, len2);
            if(end - start < maxLen) {
                start = i - (maxLen - 1)/2;
                end = i + maxLen/2;
            }
        }
        return s.substring(start, end+1);
    }
    
    public int expandFromCenter(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j-i-1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
