package com.wissen.stack;

import java.util.*;
class Pair {
	char character;
	int count;

	Pair(char character, int count) {
		this.character = character;
		this.count = count;
	}
}

//TC: O(n)
//SC: O(n)
public class RemoveAllAdjacentDuplicatesInStringII {

	public static String removeDuplicates(String s, int k) {
		Stack<Pair> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if(!st.isEmpty() && st.peek().character == ch) {
				st.peek().count++;
				
				if(st.peek().count == k) {
					st.pop();
				}
			} else {
				st.push(new Pair(ch, 1));
			}
		}
		
		while(!st.isEmpty()) {
			Pair pair = st.pop();
			for(int j = 0; j < pair.count; j++) {
				sb.append(pair.character);
			}
		}
		
		//reverse a strigbuilder & then return as a string
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String str = "deeedbbcccbdaa";
		int k = 3;
		
		String str1 = "pbbcggttciiippooaais";
		int k1 = 2;
		
		System.out.println(removeDuplicates(str1, k1));
	}

}
