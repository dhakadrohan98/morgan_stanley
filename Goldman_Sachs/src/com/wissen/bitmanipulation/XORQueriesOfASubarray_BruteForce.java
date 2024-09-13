package com.wissen.bitmanipulation;

public class XORQueriesOfASubarray_BruteForce {
	
	//TC: O(n*q)
	//SC: O(1)
	public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int q = queries.length;
        int[] res = new int[q];
        int indx = 0;
        
        for(int[] temp : queries) {
            int start = temp[0];
            int end = temp[1];
            
            if(start == end) {
                res[indx++] = arr[start];
            }
            else {
                int ans = 0;
                for(int j = start; j <= end; j++) {
                    ans ^= arr[j];
                }
                res[indx++] = ans;
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
