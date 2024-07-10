package com.wissen.DP;

public class MinDistance {

	public int minDistance(String s1, String s2) {
		int indx1 = 0;
		int indx2 = 0;
		int ans = rec(indx1,indx2, s1, s2);
		return ans;
	}

	private static int rec(int indx1, int indx2, String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		//base case
		if (indx1 == n1)
			return n2;
		if (indx2 == n2)
			return n1;

		if (s1.charAt(0) == s2.charAt(0))
			return rec(indx1+1, indx2+1, s1, s2);

		int remove = 1 + rec(indx1+1,indx2,s1,s2);
		int insert = 1 + rec(indx1, indx2+1, s1, s2);
		int replace = 1 + rec(indx1+1,indx2+1,s1,s2);

		return Math.min(remove, Math.min(insert, replace));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
