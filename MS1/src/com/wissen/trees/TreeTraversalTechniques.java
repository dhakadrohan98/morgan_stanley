package com.wissen.trees;

public class TreeTraversalTechniques {

	// InOrder
	public void inOrder(TreeNode root) {

		// base case
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}

	// PostOrder
	public void postOrder(TreeNode root) {
		// base case
		if (root == null) {
			return;
		}
		//visit left subtree & then right subtree & then visit the root node
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.val + " ");
	}

	// preorder
	public void preOrder(TreeNode root) {
		// base case
		if (root == null) {
			return;
		}
		//visit the root node then visit left subtree & then right subtree
		System.out.println(root.val + " ");
		postOrder(root.left);
		postOrder(root.right);
	}
	
	//LevelorderTraversal
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
