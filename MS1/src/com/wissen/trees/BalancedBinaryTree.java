package com.wissen.trees;

public class BalancedBinaryTree {
	// TC: O(n)
	// SC: O(n)
	public boolean isBalanced(TreeNode root) {
		int res = dfs(root);
		if (res == -1) { // it is not a balanced binary tree.
			return false;
		} else
			return true;
	}

	private int dfs(TreeNode root) {
		// base case
		if (root == null) {
			return 0;
		}
		// find left & right height of the tree
		int left = dfs(root.left);
		int right = dfs(root.right);
		// twisted logic
		// any one height is -1 then it is not a balanaced binary tree.
		if (left == -1 || right == -1) {
			return -1;
		}
		if (Math.abs(left - right) > 1) {
			return -1;
		}

		return 1 + Math.max(left, right);
	}
}
