package com.wissen.trees;

import java.util.*;

public class BalanceABinarySearchTree {
	// TC: O(n)
	// SC: O(n)
	private void inorder(TreeNode root, List<Integer> list) {
		// base case
		if (root == null) {
			return;
		}
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
	}

	private TreeNode solve(int low, int high, List<Integer> list) {
		// base case
		if (low > high) {
			return null;
		}

		int mid = (low + high) / 2;

		TreeNode newRoot = new TreeNode(list.get(mid));
		newRoot.left = solve(low, mid - 1, list);
		newRoot.right = solve(mid + 1, high, list);
		return newRoot;
	}

	public TreeNode balanceBST(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		TreeNode temp = root;
		inorder(temp, list);
		System.out.println(list);
		return solve(0, list.size() - 1, list);
	}

}
