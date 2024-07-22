package com.wissen.trees;

public class CheckBST {
	public boolean isValidBST(TreeNode root) {
        //base case
        if(root.left == null & root.right == null) {
            return true;
        }
        
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        
        return rec(root, min, max);
    }
    
    public boolean rec(TreeNode root, long min, long max) {
        //base case
        if(root == null) {
            return true;
        }
        //check for current node val with min & max
        if(root.val <= min || root.val >= max) {
            return false;
        }
        
        //left subtree recursive call
        boolean leftSubtree = rec(root.left, min, root.val);
        //right subtree recursive call
        boolean rightSubtree = rec(root.right, root.val, max);
       
        return leftSubtree && rightSubtree;
    }
}

// 79/85 test cases passed
/*
 * public boolean isValidBST(TreeNode root) { //base case if(root.left == null &
 * root.right == null) { return true; }
 * 
 * return rec(root, (int)-Math.pow(10,9), (int)Math.pow(10,9)); }
 * 
 * public boolean rec(TreeNode root, int min, int max) { //base case if(root ==
 * null) { return true; } //check for current node val with min & max
 * if(root.val <= min || root.val >= max) { return false; }
 * 
 * //left subtree recursive call boolean leftSubtree = rec(root.left, min,
 * root.val); //right subtree recursive call boolean rightSubtree =
 * rec(root.right, root.val, max);
 * 
 * return leftSubtree && rightSubtree; }
 */


//65/85 test cases passed
/*
 * boolean checkBST(Node root) { //edge case if(root == null) { return false; }
 * return solve(root); }
 * 
 * public boolean solve(Node root) { //base case if(root == null) { return true;
 * } //left subtree check if(root.left != null) { if(root.left.data < root.data)
 * { solve(root.left); } else { return false; } } //right subtree check
 * if(root.right != null) { if(root.right.data > root.data) { solve(root.right);
 * } else { return false; } } return true; }
 */