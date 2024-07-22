package com.wissen.trees;

import java.util.*;

public class RootToNodePath_Medium {
	
	public List<Integer> getPath(TreeNode root, int target) {
		List<Integer> list = new ArrayList<>();
		if(root == null) {
			return list;
		}
		boolean ans = solve(root, list, target);
		if(ans == true) {
			return list;
		} else {
			return new ArrayList<>();
		}
	}

	private boolean solve(TreeNode root, List<Integer> list, int target) {
		//base case
		if(root == null) {
			return false;
		}
		
		list.add(root.val);
		//current root is target, then return true.
		if(root.val == target) {
			return true;
		}
		
		if(solve(root.left, list, target) || solve(root.right, list, target)) {
			return true;
		}
		list.remove(list.size()-1);
		return false;
	}
}
