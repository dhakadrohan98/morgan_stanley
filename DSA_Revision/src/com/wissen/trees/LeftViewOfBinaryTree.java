package com.wissen.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {

	// Function to return list containing elements of left view of binary tree.
	// TC: O(n)
	// SC: O(n) in worst case
	public ArrayList<Integer> leftView(Node root) {
		ArrayList<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int n = queue.size();
			for (int i = 0; i < n; i++) {
				Node temp = queue.poll();
				// Add the first node of each level to the list
				if (i == 0) {
					list.add(temp.data);
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
