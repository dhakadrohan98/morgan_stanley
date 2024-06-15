package com.wissen;

public class PalindromicSubstringExpandFromCenterApproach {

	//TC: O(n)
    //SC: O(1)
    public int countSubstrings(String s) {
        int count1 = 0;
        int count2 = 0;
        int n = s.length();
        for(int i=0; i<n; i++) {
            count1 += expandFromCenter(s, i, i); //odd length string
            count2 += expandFromCenter(s, i, i+1); //even length string   
        }
        
        return count1 + count2;
    }
    
    private int expandFromCenter(String s,int left,int right) {
       int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
