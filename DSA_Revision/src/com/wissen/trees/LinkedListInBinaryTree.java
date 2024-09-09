package com.wissen.trees;

public class LinkedListInBinaryTree {

	// perform preorder traversal, root -> left subtree -> right subtree
	// TC: O(n*m) n -> no. of nodes in binary tree & m is no. of nodes in linked list
	// SC: O(max height of the tree) stack space
	public boolean isSubPath(ListNode head, TreeNode root) {
		if (root == null)
			return false;
		if (root.val == head.val) {
			if (dfs(head, root)) {
				return true;
			}
		}
		return isSubPath(head, root.left) || isSubPath(head, root.right);
	}

	public boolean dfs(ListNode head, TreeNode node) {
		if (head == null)
			return true;
		if (node == null)
			return false;
		if (head.val != node.val)
			return false;
		return dfs(head.next, node.left) || dfs(head.next, node.right);
	}

}
