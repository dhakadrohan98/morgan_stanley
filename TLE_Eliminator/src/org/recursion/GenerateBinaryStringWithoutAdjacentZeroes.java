package org.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringWithoutAdjacentZeroes {
	//TC: O(2^n)
    //SC: O(n)
	
	private static void rec(int n, String s, List<String> list) {
		//base case
		if(n == 0) {
			list.add(s);
			return;
		}
//		if string is empty or last character of string is 1, then i can explore further the part of binary 
//		string by appending 0 only otherwise i need to append 1 to avoid from condition that i can not have two 
//		consecutive zeroes in my binary string 
		if(s.isEmpty() == true || s.charAt(s.length()-1) == '1') {
			rec(n-1, s+"0", list);
			rec(n-1, s+"1", list);
		} else {
			rec(n-1, s+"1", list);
		}
	}
	
	public static void main(String[] args) {
		int num = 3;
		String s = "";
		List<String> list = new ArrayList<>();
		rec(num, s, list);
		System.out.println(list);

	}

}
