package com.wissen.trees;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

class Tuple {
	TreeNode node;
	int vertical;
	int level;
	
	public Tuple(TreeNode node, int vertical, int level) {
		this.node = node;
		this.vertical = vertical;
		this.level = level;
	}
}

public class VerticalOrderTraversal {

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tmap = new TreeMap<>();
		Queue<Tuple> q = new LinkedList<>();
		//add root, 0(vertical), 0(level)
		q.offer(new Tuple(root, 0, 0));
		
		while(!q.isEmpty()) {
			Tuple tuple = q.poll();
			TreeNode node = tuple.node;
			int vertical = tuple.vertical;
			int level = tuple.level;
			
			if(!tmap.containsKey(vertical)) {
				tmap.put(vertical, new TreeMap<>());
			}
			
			if(!tmap.get(vertical).containsKey(level)) {
				tmap.get(vertical).put(level, new PriorityQueue<>());
			}
			//add node val at vertical -> level -> node.val
			tmap.get(vertical).get(level).offer(node.val);
			
			if(node.left != null) {
				q.offer(new Tuple(node.left, vertical-1, level+1));
			}
			
			if(node.right != null) {
				q.offer(new Tuple(node.right, vertical+1, level+1));
			}
		}
		
		List<List<Integer>> ans = new ArrayList<>();
		//For every vertical i will iterate through its all levels(increasing order).
		for(TreeMap<Integer, PriorityQueue<Integer>> ys : tmap.values()) {
			ArrayList<Integer> list = new ArrayList<>();
			//iterate through all nodes of a level of each vertical
			for(PriorityQueue<Integer> nodes : ys.values()) {
				while(!nodes.isEmpty()) {
					list.add(nodes.poll());
				}
			}
            ans.add(list);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
