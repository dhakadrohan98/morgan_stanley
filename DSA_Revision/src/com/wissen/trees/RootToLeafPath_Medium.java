package com.wissen.trees;

import java.util.*;

public class RootToLeafPath_Medium {
	public static ArrayList<ArrayList<Integer>> Paths(Node root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		//if root is null
		if(root == null) {
			return res;
		}
		ArrayList<Integer> list = new ArrayList<>();
		dfs(root, list, res);
		return res;
	}

	private static void dfs(Node root, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
		// base case
		if (root != null && root.left == null && root.right  == null) {
			// add current node element to the list
			list.add(root.data);
			//add list to final res list
			res.add(new ArrayList<>(list));
			//backtrack: remove last element from list for one step back
			list.remove(list.size()-1);
			return;
		}
		
		if(root == null) {
		    return;
		}
		// add current node element to the list
		list.add(root.data);
		//rec.. call to left subtree
		dfs(root.left, list, res);
		//rec.. call to right subtree
		dfs(root.right, list, res);
		//backtrack: remove last element from list when left & right subtree traversal is completed for give node
		list.remove(list.size()-1);
	}
}

//correct code

/*
 * private static void dfs(Node root, ArrayList<Integer> list,
 * ArrayList<ArrayList<Integer>> res) { // base case if (root == null) { return;
 * } // add current node data list.add(root.data); // if it's a leaf node, add
 * the current path to the result if (root.left == null && root.right == null) {
 * res.add(new ArrayList<>(list)); } else { // otherwise, continue to explore
 * left and right subtrees dfs(root.left, list, res); dfs(root.right, list,
 * res); } // backtrack: remove the current node data list.remove(list.size() -
 * 1); }
 */
