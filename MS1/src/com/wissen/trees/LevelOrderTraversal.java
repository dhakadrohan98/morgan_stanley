package com.wissen.trees;

import java.util.*;

public class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //base case
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                tempList.add(node.val);
                //add left node
                if(node.left != null) {
                    queue.offer(node.left);
                }
                //add right node
                if(node.right != null) {
                    queue.offer(node.right);
                }   
            }
            res.add(new ArrayList<>(tempList));
        }
        return res;
    }
}
