package org.wissen.DP;

import java.util.*;

public class AllSubsequencesOfString {

	public static List<String> printSubsequences(String str) {
		int n = str.length();
		List<String> list = new ArrayList<>();
		rec(str, "", 0, list);
		Collections.sort(list);
		return list;
	}

	private static void rec(String str, String res, int indx, List<String> list) {
		// base case
		if (indx == str.length()) {
			if (res != "") {
				list.add(res);
			}
			return;
		}

		// include
		rec(str, res + str.charAt(indx), indx + 1, list);
		// exclude
		rec(str, res, indx + 1, list);

	}

	public static void main(String[] args) {
		String str = "abc";
		System.out.println(printSubsequences(str));

	}

}
