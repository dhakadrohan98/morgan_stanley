package com.wissen.string;

public class DIStringMatch {
	
	//TC: O(n)
	//SC: O(n+1) to store ans
	public int[] diStringMatch(String s) {
        int n = s.length();
        int low = 0, high = n;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == 'I') 
                ans[i] = low++;
            else 
                ans[i] = high--;
        }

        ans[n] = high;
        return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
