package com.wissen.trees;

//below method is modified version of finding height/depth of binary tree
public class DiameterOfBinaryTree {
	//TC: O(n)
	//SC: O(n)
	public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        helper(root, diameter);
        return diameter[0];
    }
     
    private int helper(TreeNode root,int[] diameter) {
        //base case
        if(root == null) {
            return 0;
        }
        int left = helper(root.left, diameter);
        int right = helper(root.right, diameter);
        diameter[0] = Math.max(diameter[0], left+right);
        return 1 + Math.max(left,right);
    }
}
