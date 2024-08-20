package com.wissen.trees;

import java.util.*;

public class RecoverBST_NaiveApproach {
	public void recoverTree(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		// Make a list using Inorder traversal
		storeNodes(root, list);
		// Sort the list
		Collections.sort(list);
		// Modify the tree nodes to match the sorted list
		modifyNodes(root, list, new int[] { 0 });
	}

	private void storeNodes(TreeNode root, List<Integer> list) {
		// Base case
		if (root == null) {
			return;
		}
		storeNodes(root.left, list);
		list.add(root.val);
		storeNodes(root.right, list);
	}

	private void modifyNodes(TreeNode root, List<Integer> list, int[] indx) {
		// Base case
		if (root == null) {
			return;
		}
		modifyNodes(root.left, list, indx);
		if (list.get(indx[0]) != root.val) {
			root.val = list.get(indx[0]);
		}
		indx[0]++;
		modifyNodes(root.right, list, indx);
	}

}
