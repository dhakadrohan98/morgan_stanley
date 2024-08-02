package com.wissen.slidingwindow;

import java.util.*;

public class FindAllAnagramsInaString55_65 {

	// 55/65 test cases have been passed
	public static List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int k = p.length();
        Map<Character, Integer> hmap1 = new HashMap<>();
        
        for(int i=0; i<k; i++) {
        	char ch = p.charAt(i);
        	hmap1.put(ch, hmap1.getOrDefault(ch, 0) + 1);
        }
           
        int i=0, j=0;
        Map<Character, Integer> hmap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        
        while(j < n) {
            char chJ = s.charAt(j);
            if(p.contains(chJ+"")) {
                hmap.put(chJ, hmap.getOrDefault(chJ, 0) + 1);
            }
            if(j - i + 1 < k) {
                j++;
            } else if(j -i + 1 == k) { //window is hitted
                //cal. for ans
            	int total = 0;
            	for(int val: hmap.values()) {
            		total += val;
            	}
            	
                if(hmap.size() == hmap1.size() && total == k) {
                    ans.add(i);
                }
                //remove cal. for i
                char chI = s.charAt(i);
                if(hmap.containsKey(chI)) {
                    hmap.put(chI, hmap.get(chI) - 1);
                    //check if key val becomes 0
                    if(hmap.get(chI) == 0) {
                        hmap.remove(chI);
                    }
                }
                //slide the window
                i++;
                j++;
            }
        }
        return ans;
    }

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";

		String s1 = "baa";
		String p1 = "aa";

		String s3 = "ababababab";
		String p3 = "aab";

		System.out.println(findAnagrams(s, p));

	}

}
