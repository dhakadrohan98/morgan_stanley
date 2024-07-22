package com.wissen.trees;

public class DiameterOfBinaryTree {
	//TC: O(n)
    //SC: O(h)
    int maxi = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxi;
    }
    
    private int dfs(TreeNode root) {
        //base case
        if(root == null) {
            return 0;
        }
        
        //call to left subtree
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        maxi = Math.max(maxi, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
