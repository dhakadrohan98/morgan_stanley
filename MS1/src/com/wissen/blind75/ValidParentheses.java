package com.wissen.blind75;

import java.util.*;

public class ValidParentheses {
	// TC: O(n)
	// SC: O(n)
	public static boolean isValid(String s) {
		if (s.length() == 1) {
			return false;
		}

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			} else if (!st.isEmpty()) {
				char popped = st.pop();
				if (ch == ')' && popped != '(') {
					return false;
				} else if (ch == '}' && popped != '{') {
					return false;
				} else if (ch == ']' && popped != '[') {
					return false;
				}
			}
			//if any first character is closing bracket(from three types) then return false;
			else if (ch == ')' || ch == '}' || ch == ']') {
				return false;
			}
		}

		if (st.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		String str = "()";
		System.out.println(isValid(str));

	}

}
