package com.wissen.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreaterElementToRight {

	public static List<Integer> nextGreaterToRight(int[] nums) {
		List<Integer> list = new ArrayList<>();
		Stack<Integer> st = new Stack<>();
		int n = nums.length;
		//add -1 for last element
		list.add(-1);
		//push current element to stack
		st.push(nums[n-1]);
		
		for(int i=n-2; i>=0; i--) {
			int currElement = nums[i];
			if(!st.isEmpty() && currElement < st.peek()) {
				list.add(st.peek());
			} else {
				// pop elements from stack while currentElement is greater than or equal to the st.top
				//or stack becomes empty
				while(!st.isEmpty() && currElement >= st.peek()) {
					st.pop();
				}
				//if stack is not empty & curr element is less than stack top
				if(st.size() > 0 && currElement < st.peek()) {
					list.add(st.peek());
				} else { //Either stack has become empty or curr element is greater than or equal to the stack top
					list.add(-1);
				}
			}
			st.push(currElement);
		}
		Collections.reverse(list);
		return list;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,3};
		System.out.println(nextGreaterToRight(nums));

	}

}
