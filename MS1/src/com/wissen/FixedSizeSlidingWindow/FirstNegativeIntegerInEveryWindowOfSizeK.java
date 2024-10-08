package com.wissen.FixedSizeSlidingWindow;

import java.util.*;
public class FirstNegativeIntegerInEveryWindowOfSizeK {

	public long[] printFirstNegativeInteger(long arr[], int n, int k)
    {
        long[] ans = new long[n-k+1];
        int i=0, j=0, a=0;
        List<Long> list = new ArrayList<>();
        
        while(j < n) {
            if(arr[j] < 0) {
                list.add(arr[j]);
            }
            if(j-i+1 < k) {
                j++;
            }
            else if(j-i+1 == k) {
                //calculations for answer
                if(list.size() >= 1) {
                    ans[a++] = list.get(0);
                }
                else {
                    ans[a++] = 0l;
                }
                
                if(arr[i] < 0) {
                    list.remove(0);
                }
                i++;
                j++;
            }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
