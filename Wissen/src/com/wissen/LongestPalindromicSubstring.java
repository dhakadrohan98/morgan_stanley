package com.wissen;

public class LongestPalindromicSubstring {
	//TC: O(n^2)
	//SC: O(n)
	public String longestPalindrome(String str) {
        int max = 0;
        String result = "";
        
        for(int i=0; i<str.length(); i++) {
            for(int j=i+1; j <= str.length(); j++) {
                String substr = str.substring(i,j);
                if(isPalindrome(substr)) {
                    if(substr.length() > max) {
                        max = substr.length();
                        result = substr;
                    }
                }
            }
        }
        return result;
    }
    
    public static boolean isPalindrome(String str) {
        int n = str.length();
        for(int i=0, j=n-1; i <= str.length()/2; i++, j--) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
