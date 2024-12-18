package com.wissen.codingtemplate;

public class DFSOnTree {
	public static Node dfs(Node root, int target) {
	    if (root == null) return null;
	    if (root.val == target) {
	        return root;
	    }
	    Node left = dfs(root.left, target);
	    if (left != null) {
	        return left;
	    }
	    return dfs(root.right, target);
	}

}
