package com.wissen.stack;

import java.util.*;
public class DailyTemparature {
	
	class Pair {
        int num;
        int i;
        
        public Pair(int num, int i) {
            this.num = num;
            this.i = i;
        }
    }
    
    //TC: O(n)
    //SC: O(n)
    public int[] dailyTemperatures(int[] nums) {
        Stack<Pair> st = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        res[n-1] = 0;
        st.push(new Pair(nums[n-1], n-1));
        //start from (i-2)th till 0th index
        for(int i = n-2; i >= 0; i--) {
            int curr = nums[i];
            if(!st.isEmpty() && st.peek().num > curr) {
                Pair pair = st.peek();
                int indx = pair.i;
                //store next days difference at ith index in res array
                res[i] = indx -  i;
            } 
            else if(!st.isEmpty() && st.peek().num <= curr) {
                while(!st.isEmpty() && st.peek().num <= curr) {
                    st.pop();
                }
                //if stack is not empty then we got the greater elem in stack
                if(!st.isEmpty()) {
                    Pair pair = st.peek();
                    int elem = pair.num;
                    int indx = pair.i;
                    //store diff index at ith index in res
                    res[i] = indx -  i;
                } else { //stack become empty, no greater element is found in the stack
                    res[i] = 0;
                }
            }
            st.push(new Pair(curr, i));
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
