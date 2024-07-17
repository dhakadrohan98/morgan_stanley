package com.wissen.two.pointers;

import java.util.*;

class Pair {
    int prefixSum;
    int index;
    
    Pair(int prefixSum, int index) {
        this.prefixSum = prefixSum;
        this.index = index;
    }

	@Override
	public String toString() {
		return "Pair [prefixSum=" + prefixSum + ", index=" + index + "]";
	}
    
}

public class ShortestSubarrayWithSumAtleastK {
	//hard problem on leetcode
	public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int prefixSum = 0;
        
        
        Deque<Pair> dq = new ArrayDeque<>();
        
        //add (0,-1) into dq
        dq.addFirst(new Pair(0,-1));
        
        for(int i=0; i<n; i++) {
        	System.out.println("i - " + i);
            prefixSum += nums[i];
            while(!dq.isEmpty() && prefixSum <=  dq.peekLast().prefixSum) {
//            	System.out.println("prefixsum: " + prefixSum+ "lastelement prefixSum: " + dq.peekLast().prefixSum);
            	dq.pollLast();
            }
            int checker = prefixSum - k;
            while(!dq.isEmpty() && checker >= dq.peekFirst().prefixSum) {
            	System.out.println("checker: " + checker + " ---- first.prefixSum: " + dq.peekFirst().prefixSum);
            	System.out.println("res: " + res +  " i - first.index = " + (i - dq.peekFirst().index));
            	res = Math.min(res, i - dq.peekFirst().index);
            	dq.pollFirst();
            }
            dq.offerLast(new Pair(prefixSum, i));
            System.out.println(dq);
            System.out.println("----------------------------");
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {3,5,2,1,-6,7,1,8};
		int k = 8;
		
		System.out.println("shortest subarray length with sum at least k: " + shortestSubarray(nums, k));

	}

}

//{"Name: "John", "Age":"31", "Gender":"Male"}
//{"Name: "Emma", "Age":"27", "Gender":"Female"}
//{"Name: "Ronald", "Age":"17", "Gender":"Male"}
