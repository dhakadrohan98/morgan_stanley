package com.wissen.trees;

import java.util.*;
public class LevelOrderTraversal {
	//TC: O(n)
    //SC: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
       Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(queue.size() > 0){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            level++;
            for(int i=0; i<size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                //add left subtree root/top node if exists
                if(temp.left != null) {
                    queue.offer(temp.left);
                }
                 //add right subtree root/top node if exists
                if(temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            res.add(list);
            System.out.println("Curr Level: " + level);
        }
        return res;
    }
}
