package com.wissen.blind75;

import java.util.*;

public class ValidAnagram {

	//TC: O(2n+m)
    //SC: O(n+m)
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        //base case
        if(n1 != n2) {
            return false; 
        }
        
        Map<Character, Integer> hmap1  = new HashMap<>();
        Map<Character, Integer> hmap2 = new HashMap<>();
        
        for(int i=0; i<n1; i++) {
            char ch = s.charAt(i);
            hmap1.put(ch, hmap1.getOrDefault(ch,0)+1);
        }
        
        for(int i=0; i<n2; i++) {
            char ch = t.charAt(i);
            hmap2.put(ch, hmap2.getOrDefault(ch,0)+1);
        }
        
        for(int i=0; i<n1; i++) {
            char chs = s.charAt(i);
            if(hmap2.containsKey(chs)) {
                int freqs = hmap1.get(chs);
                int freqt = hmap2.get(chs);
                if(freqs != freqt) {
                    return false;
                }
                
            }
            else {
                return false;
            }
        }
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
