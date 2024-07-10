package com.wissen.slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

public class LongestUniformSubstring {
	//TC: O(n)
	//SC: O(1)
	public static int[] longestUniformSubstring(String str) {
		
		//base case if str length is 0 or 1
		if(str.length() == 0) {
			return new int[]{0,-1};
		}
		if(str.length() == 1) {
			return new int[]{1, 0};
		}
		
		int[] res = new int[2];
		int n = str.length();
		int i=0, j=0;
		int longest = 0;
		int longestIndex = -1;
		Queue<Character> queue = new LinkedList<>();
		
		while(j < n) {
			char ch = str.charAt(j);
			if(!queue.contains(ch)) {
				queue.offer(ch);
			}
			if(queue.size() == 1) {
				j++;
			}
			else if(queue.size() > 1) {
				if(longest < j-i) {
					longestIndex = i;
					longest = j-i;
				}
				char peek = queue.peek();
				
				while(peek == str.charAt(i)) {
					if(queue.size() > 1 && queue.contains(str.charAt(i))) {
						queue.poll();
					}
					i++;
				}
				j++;
			}
			
		}
		
		res[0] = longest;
		res[1] = longestIndex;
		return res;
	}
	
	public static void main(String[] args) {
		String str = "aabbbbcde";
		String str2 = "a";
		int[] res = longestUniformSubstring(str2);
		for(int val : res) {
			System.out.println(val);
		}

	}

}
