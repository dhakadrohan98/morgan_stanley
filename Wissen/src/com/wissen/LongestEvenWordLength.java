package com.wissen;

import java.util.*;

public class LongestEvenWordLength {

	public static void main(String[] args) {
		String str = "str= “Be not afraid of greatness, some are born great, some achieve greatness, "
				+ "and some have greatness, and some have greatness thrust upon them";
		int longest = 0;
		String[] s = str.split(" ");
		List<String> res = new ArrayList<String>();
		
		for(int i=0; i<s.length; i++) {
			String tempStr = s[i];
			int length = tempStr.length();
			if(tempStr.contains(",")) {
				length--;
			}
			if(length % 2 == 0) {
				res.add(tempStr);
				longest = Math.max(longest, length);
			}
		}
		System.out.println(longest);
		System.out.println(res);

	}

}
