package com.wissen.dp.strings;

import java.util.*;

public class DifferentWaysToAddParentheses {

	public List<Integer> diffWaysToCompute(String exp) {
		return dfs(0, exp.length() - 1, exp);
	}

	private List<Integer> dfs(int i, int j, String exp) {

		List<Integer> result = new ArrayList<>();

		for (int k = 0; k <= j; k++) {
			char ch = exp.charAt(k);
			if (ch == '+' || ch == '-' || ch == '*') {
				List<Integer> leftResult = dfs(i, k - 1, exp);
				List<Integer> rightResult = dfs(k + 1, j, exp);

				// Apply for loop in left results & right results List to find all possible
				// answers.
				for (int left : leftResult) {
					for (int right : rightResult) {
						if (ch == '+') {
							result.add(left + right);
						} else if (ch == '-') {
							result.add(left - right);
						} else { // if ch == '*
							result.add(left * right);
						}
					}
				}
			}
		}

		// corner case(if no operator is in the expression)
		if (result.isEmpty()) {
			result.add(Integer.parseInt(exp.substring(i, j + 1)));
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
