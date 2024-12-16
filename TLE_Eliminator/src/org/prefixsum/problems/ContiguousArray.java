package org.prefixsum.problems;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	
	//TC: O(n * logn(hmap worst case))
    //SC: O(1)
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int sum = 0;
        Map<Integer, Integer> hmap = new HashMap<>();
        int ans = 0;
        
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                sum -= 1;
            } else {
                sum += 1;
            }
            
            if(sum == 0) {
                ans = i+1;
            }
            else {
                if(hmap.containsKey(sum)) {
                    ans = Math.max(ans,  i - hmap.get(sum));
                }
                else {
                    hmap.put(sum, i);
                }
            }
        }
        
        return ans;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
