package com.wissen.codingtemplate;

public class BFSOnTree {

	public Node bfs(Node root) {
	    ArrayDeque<Node> queue = new ArrayDeque<>();
	    queue.add(root);
	    while (queue.size() > 0) {
	        Node node = queue.poll();
	        for (Node child : node.children) {
	            if (isGoal(child)) {
	                return FOUND(child);
	            }
	            queue.add(child);
	        }
	    }
	    return NOT_FOUND;
	}

}
