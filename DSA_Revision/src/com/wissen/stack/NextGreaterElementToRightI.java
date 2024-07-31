package com.wissen.stack;

import java.util.*;
public class NextGreaterElementToRightI {
	
	public static long[] nextLargerElement(long[] arr, int n)
    { 
        long[] ans = new long[n];
        Stack<Long> st = new Stack<>();
        
        for(int i = n-1; i >= 0; i--) {
            //if stack is empty
            if(st.isEmpty()) {
                ans[i] = -1;
            } else if(!st.isEmpty() && st.peek() > arr[i]) {
                ans[i] = st.peek();
            } else if(!st.isEmpty() && st.peek() <= arr[i]){
                while(!st.isEmpty() && st.peek() <= arr[i]) {
                    st.pop();
                }
                //if stack is not empty means we found greater element on the top of stack
                if(!st.isEmpty()) {
                    ans[i] = st.peek();
                } else { //stack is empty, greater element is not present there
                    ans[i] = -1;
                }
            }
            st.push(arr[i]);
        }
        return ans;
    } 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
