package com.wissen.trees;



/*Maximum depth of BT: A binary tree's maximum depth is the number of nodes along the longest path 
from the root node down to the farthest leaf node.*/
public class MaxDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
	       //base case
	        if(root == null) {
	            return 0;
	        }
	        
	        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
