package com.wissen.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Map<Integer, Integer> hmap = new HashMap<>();
		Stack<Integer> st = new Stack<Integer>();
		int m = nums1.length;
		int n = nums2.length;
		int[] res = new int[m];
		
		hmap.put(nums2[n-1], -1);
		//push current element to stack
		st.push(nums2[n-1]);
		for(int i=n-2; i>=0; i--) {
			int currElement = nums2[i];
			if(!st.isEmpty() && currElement < st.peek()) {
				hmap.put(nums2[i], st.peek());
			} else {
				// pop elements from stack while currentElement is greater than or equal to the st.top
				//or stack becomes empty
				while(!st.isEmpty() && currElement >= st.peek()) {
					st.pop();
				}
				//stack is not empty & curr element is less than stack top
				if(st.size() > 0) {
					hmap.put(nums2[i], st.peek());
				} else { //Either stack has become empty or curr element is greater than or equal to the stack top
					hmap.put(nums2[i], -1);
				}
			}
			st.push(currElement);
		}
		System.out.println(hmap);
	
		for(int i=0; i<m; i++) {
			res[i] = hmap.get(nums1[i]);
		}
		
		return res;
	}

	public static void main(String[] args) {
		int[] nums1 = {4,1,2};
		int[] nums2 = {1,3,4,2};
		
		int[] nums11 = {3,1,5,7,9,2,6};
		int[] nums22 = {1,2,3,5,6,7,9,11};
		
		int[] res = nextGreaterElement(nums11, nums22);
		for(int val : res) {
			System.out.print(val+" ");
		}
		

	}

}

//[3,1,5,7,9,2,6]
//[1,2,3,5,6,7,9,11]
