package com.wissen.trees;

public class ValidateBinarySearchTree {
	
	public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        
        return dfs(root, min, max);
    }
    
    private boolean dfs(TreeNode root, long min, long max) {
        //base case
        if(root == null) {
            return true;
        }
        
        //min & max check on curr node val
        if(root.val <= min || root.val >= max) {
            return false;
        }
        
        boolean leftSubtree = dfs(root.left, min, root.val);
        boolean rightSubtree = dfs(root.right, root.val, max);
        
        return leftSubtree && rightSubtree;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
