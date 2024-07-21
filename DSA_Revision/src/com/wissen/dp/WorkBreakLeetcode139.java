package com.wissen.dp;

import java.util.*;

//TC: O(2^n)
//SC: O(n) stack space + O(n) dp space
public class WorkBreakLeetcode139 {

	static int n;

	public static boolean wordBreak(String s, List<String> list) {
		n = s.length();
		Boolean[] dp = new Boolean[n];
		return solve(0, s, list, dp);
	}

	private static boolean solve(int indx, String s, List<String> list, Boolean[] dp) {
		// base case
		if (indx == n) {
			return true;
		}
		
		if(dp[indx] != null) {
			return dp[indx];
		}

		for (int l = indx + 1; l <= n; l++) {
			String substr = s.substring(indx, l);
			if (list.contains(substr) && solve(l, s, list, dp)) {
				dp[indx] = true;
				return true;
			}
		}
		dp[indx] = false;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

/*
 * {path : 'product', component: ProductComponent, canActivate :
 * [AuthGuardService], canActivateChild : [AdminGuardService], children: [
 * {path: 'view/:id', component: ViewComponent}, {path: 'edit/:id', component:
 * EditComponent} ]
 * 
 * }
 */








