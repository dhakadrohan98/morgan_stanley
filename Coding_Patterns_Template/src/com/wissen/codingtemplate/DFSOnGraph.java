package com.wissen.codingtemplate;

public class DFSOnGraph {
	public void dfs(Node root, Set<Node> visited) {
	    for (Node neighbor : node.neighbors) {
	        if (visited.contains(node)) {
	            continue;
	        }
	        visited.add(neighbor);
	        dfs(neighbor, visited);
	    }
	}
}
