package com.wissen.FixedSizeSlidingWindow;

import java.util.*;
public class CountOccurencesOfAnagram50_90_TCPasses {
	
	public int search(String pat, String txt) {
        int count = 0;
        int len1 = txt.length();
        int len2 = pat.length();
        int k = len2;
        int i=0, j=0;
        List<String> list = new ArrayList<>();
        
        while(j < len1) {
            String ch = txt.charAt(j) + "";
            if(pat.contains(ch)) {
                list.add(ch);
            }
            
            if(j-i+1 < k) {
                j++;
            }
            else if(j-i+1 == k) {
                //calculate ans
                if(list.size() == len2) {
                    count++;
                }
                //remove calculations for i
                String anotherch = txt.charAt(i) + "";
                if(list.contains(anotherch)) {
                    list.remove(anotherch);
                }
                i++;
                j++;
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
