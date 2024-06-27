package com.wissen.trees;

public class MaxDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        return helper(root, 1);
    }
    
    public int helper(TreeNode root, int level) {
        //base case
        if(root == null) {
            level--;
            return level;
        }
        
        int left = helper(root.left, level+1);
        int right = helper(root.right, level+1);
        return Math.max(left, right);
    }
}
