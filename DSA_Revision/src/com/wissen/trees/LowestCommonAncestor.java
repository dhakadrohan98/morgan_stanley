package com.wissen.trees;

public class LowestCommonAncestor {
	
	//TC: O(n)
	//SC: O(Height of the tree)
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//base case
		if(root == p || root == q || root == null) {
			return root;
		}
		
		TreeNode leftSide = lowestCommonAncestor(root.left, p, q);
		TreeNode rightSide = lowestCommonAncestor(root.right, p, q);
		
		if(leftSide == null) {
			return rightSide;
		} else if(rightSide == null) {
			return leftSide;
		} else {  //leftSide != null && rigtSide != null
			return root;
		}
	}
}
