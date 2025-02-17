package com.codeship.graphproblems;

import java.util.*;

//TC: O(V + 2E) + O(N) for multi component of a graph
//SC: O(V) visited array + O(V) queue
public class DetectACycleInUndirectedGraph {
	
	class Pair {
        int node;
        int parent;
        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    
    private boolean checkForCycle(int src, ArrayList<ArrayList<Integer>> adj, 
    boolean[] visited) {
        visited[src] = true;
        Queue<Pair> queue = new LinkedList<>();
        //current src node with parent as -1.
        queue.offer(new Pair(src, -1));
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            int node = p.node;
            int parent = p.parent;
            //traverse in bfs fashion through its adjacent nodes
            for(int adjNode : adj.get(node)) {
                if(!visited[adjNode]) {
                    visited[adjNode] = true;
                    //add {curr_node, parent_node} into queue
                    queue.offer(new Pair(adjNode, node));
                }
                else if(parent != adjNode) {
                    return true;
                }
            }
        }
        return false;
    }
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        //call bfs on each starting node of a disconnected component
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(checkForCycle(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
