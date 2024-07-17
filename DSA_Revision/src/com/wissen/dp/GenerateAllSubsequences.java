package com.wissen.dp;


//for n length string, 2^n subsequences are possible for all unique characters.
public class GenerateAllSubsequences {
	//TC: O(2^n)
	//SC: O(n) stack space
	public static void generate(String str) {
		int n = str.length();
		int[] count = new int[1];
		rec(n-1, "", str, count);
	}
	
	private static void rec(int indx, String res, String str, int[] count) {
		//base case
		if(indx < 0) {
			count[0]++;
			System.out.println(res + ": count - " + count[0]);
			return;
		}
		
		//picked
		rec(indx-1, res+str.charAt(indx), str, count);
		
		//not picked
		rec(indx-1, res, str, count);
	}
	
	public static void main(String[] args) {
		String str = "abc";
		generate(str);

	}

}
