package com.wissen.stack;

import java.util.*;

public class DailyTempratures {

	//TC: O(n)
    //SC: O(n)
    public int[] dailyTemperatures(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        //next greater to right approach is used
        for(int i=n-1; i>=0; i--) {
            int val = nums[i];
            if(!st.isEmpty() && nums[st.peek()] > val) {
                res[i] = st.peek()- i;
            } else {
                while(!st.isEmpty() && nums[st.peek()] <= val) {
                    st.pop();
                }
                if(!st.isEmpty() && nums[st.peek()] > val) {
                  res[i] = st.peek() - i;  
                }
            }
            st.push(i);
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
