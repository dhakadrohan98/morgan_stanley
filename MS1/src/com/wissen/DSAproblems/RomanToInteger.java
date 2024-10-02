package com.wissen.DSAproblems;

import java.util.*;

public class RomanToInteger {

	public int romanToInt(String s) {
        Map<String, Integer> hmap = new HashMap<>();
        hmap.put("I", 1);
        hmap.put("V",5);
        hmap.put("X",10);
        hmap.put("L",50);
        hmap.put("C", 100);
        hmap.put("D", 500);
        hmap.put("M", 1000);
        hmap.put("IV", 4);
        hmap.put("IX", 9);
        hmap.put("XL", 40);
        hmap.put("XC", 90);
        hmap.put("CD", 400);
        hmap.put("CM", 900);
        int n = s.length();
        int res = 0;
        
        for(int i=0; i<n; i++) {
            char ch1 = s.charAt(i);
            char ch2 = 'z';
            if(i+1 < n) {
                ch2 = s.charAt(i+1);
            }
            if(ch2 != 'z') {
                String concat = ch1+""+ch2;
                if(hmap.containsKey(concat)) {
                    res = res + hmap.get(concat);
                    i++;
                }
                else {
                   res = res + hmap.get(ch1+""); 
                }
            }
            else {
                res = res + hmap.get(ch1+"");
            }
            
        }
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
