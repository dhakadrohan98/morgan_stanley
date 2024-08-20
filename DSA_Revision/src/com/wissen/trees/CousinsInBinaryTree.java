package com.wissen.trees;

import java.util.*;
public class CousinsInBinaryTree {
	
	//TC: O(n)
    //SC: O(w) maximu width of the tree or O(n) in worst case
    public boolean isCousins(TreeNode root, int A, int B) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean isAExist = false;
            boolean isBExist = false;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.val == A) isAExist = true;
                if(node.val == B) isBExist = true;
                
                if(node.left != null & node.right != null) {
                    if(A == node.left.val && B == node.right.val) {
                        return false;
                    }
                    if(B == node.left.val && A == node.right.val) {
                        return false;
                    }
                }
                
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            if(isAExist && isBExist) return true;
        }
        //if A & B doesn't exist
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
