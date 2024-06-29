package com.wissen.FixedSizeSlidingWindow;

import java.util.*;

public class FirstNegativeInEveryWindowOfSizeKVersion_2 {
	public long[] printFirstNegativeInteger(long[] arr, int n, int k)
    {
        long[] ans = new long[n-k+1];
        int i=0, j=0, cnt=0;
        List<Long> ds = new ArrayList<>();
        
        while(j < n) {
            if(arr[j] < 0) {
                ds.add(arr[j]);
            }
            if(j-i+1 < k) {
                j++;
            } else if(j-i+1 == k) {
                //check whether a element is present in ds or not 
                if(ds.size() > 0) {
                    ans[cnt] = ds.get(0);
                    cnt++;
                } else {
                   ans[cnt] = 0l; 
                   cnt++;
                }
                if(ds.contains(arr[i])) {
                    ds.remove(arr[i]);
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
