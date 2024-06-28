package com.wissen.trees;

import java.util.*;
public class ZigZagLevelOrderTraversal {
	// TC: O(n)
	// SC: O(n)
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		// base case
		if (root == null) {
			return res;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean isReversed = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				list.add(temp.val);
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
			}
			if (isReversed) {
				Collections.reverse(list);
			}
			isReversed = !isReversed;
			res.add(new ArrayList<>(list));
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
