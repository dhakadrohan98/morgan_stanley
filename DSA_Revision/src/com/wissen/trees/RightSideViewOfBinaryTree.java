package com.wissen.trees;

import java.util.*;

public class RightSideViewOfBinaryTree {
	//TC: O(n)
	//SC: O(n) in worst case
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                // Add the first node of each level to the list
                if (i == n-1) {
                    list.add(temp.val);
                }
                // Add left node to queue
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                // Add right node to queue
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return list;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
