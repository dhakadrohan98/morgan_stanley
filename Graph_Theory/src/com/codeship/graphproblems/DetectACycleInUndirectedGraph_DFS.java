package com.codeship.graphproblems;

import java.util.*;

//TC: O(N + 2E) + O(N) for loop to visit all component of a graph
//SC: O(N) vis + O(N) recursion stack space
public class DetectACycleInUndirectedGraph_DFS {

	private boolean dfs(int node, int parent, boolean[] vis, 
		    ArrayList<ArrayList<Integer>> adj) {
		        //mark current node as visited
		        vis[node] = true;
		        //peform dfs on its adjacent nodes
		        for(int adjNode : adj.get(node)) {
		            if(!vis[adjNode]) {
		                //pass adjNode & node as parent one
		                if(dfs(adjNode, node, vis, adj)) {
		                    return true;
		                }
		            }
		            //adjNode is visited already
		            else if(parent != adjNode) {
		                return true;
		            }
		        }
		        return false;
		    }
		    
		    // Function to detect cycle in an undirected graph.
		    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
		        int V = adj.size();
		        boolean[] vis = new boolean[V];
		        for(int i = 0; i <  V; i++) {
		            if(!vis[i]) {
		                if(dfs(i, -1, vis, adj)) {
		                    return true;
		                }
		            }
		        }
		        return false;
		    }

}
