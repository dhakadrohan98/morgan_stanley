package com.wissen.trees;

public class RecoverBST_OptimalSol {
	// TC: O(n)
	// SC: O(n) stack space
	private TreeNode prev;
	private TreeNode first;
	private TreeNode middle;
	private TreeNode last;

	private void inorder(TreeNode root) {
		// base case
		if (root == null) {
			return;
		}

		inorder(root.left);

		// main buisness
		if (prev != null && (root.val < prev.val)) {
			// if this is the first violation, mark these two nodes as 'first' & 'middle'
			if (first == null) {
				first = prev; // first node is the prev node for 1st violation
				middle = root; // middle is the current node
			}
			// if this is 2nd violation, makr curr node as last node
			else {
				last = root;
			}
		}

		// make curr node as prev node for next inorder call
		prev = root;
		inorder(root.right);
	}

	public void recoverTree(TreeNode root) {
		first = middle = last = null;
		prev = new TreeNode(Integer.MIN_VALUE);
		// peform inOrder traversal & write main business logic here
		inorder(root);
		// last logic
		// If 2 violation took place, it means swap the first & last node
		if (first != null && last != null) {
			int t = first.val;
			first.val = last.val;
			last.val = t;
		}
		// If 1 violation took place, it means swap the first & middle node
		else if (first != null && middle != null) {
			// swap the first & middle node
			int t = first.val;
			first.val = middle.val;
			middle.val = t;
		}
	}
}
