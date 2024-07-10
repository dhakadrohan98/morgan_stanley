package com.wissen.twopointers;

public class CheckWhetherAwordIsSubsequenceOfStringsOrNot {
	
	static boolean found = false;
	public static void longestWord(String s, String w) {
		StringBuilder curr = new StringBuilder();
		rec(0, curr, s, w);
	}

	public static void rec(int indx, StringBuilder curr, String s, String w) {
		// base cases
		if(found == true) {
			return;
		}
		
		// if curr string equals to w then print it & return from here
		if (curr.toString().equals(w)) {
			System.out.println(curr);
			System.out.println(curr.length());
			found = true;
			return;
		}
		//if indx is out of bound s.length() or >
		if (indx >= s.length()) {
			return;
		}

		// include curr character
		rec(indx + 1, curr.append(s.charAt(indx)), s, w);
		curr.deleteCharAt(curr.length() - 1);
		// exclude curr character
		rec(indx + 1, curr, s, w);
	}
	
	public static void main(String[] args) {
		String s = "abpcplea";
		String w = "apple";
		longestWord(s, w);
	}
}
