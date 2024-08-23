package com.wissen.graph;

import java.util.ArrayList;
public class DetectACycleInDirectedGraph_DFSApproach {
	
	//TC: O(V+E)
	//SC: O(2V)
	// Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] helper = new boolean[V];
        for(int i = 0; i < V; i++) {
            //start from one node of each component
            if(visited[i] == false) {
                boolean ans = DFS(adj, i, visited, helper);
                if(ans == true) return true;
            }
        }
        //no cycle is detected
        return false;
    }
    
    private boolean DFS(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, boolean[] helper) {
        visited[i] = true;
        helper[i] = true;
        
        ArrayList<Integer> neighbours = adj.get(i);
        for(int k = 0; k < neighbours.size(); k++) {
            int curr = neighbours.get(k);
            //if current node is visited in current DFS, it means cycle exists in current component
            if(helper[curr] == true) return true;
            // if curr node is not visited then peform dfs on it
            if(visited[curr] == false) {
                boolean ans = DFS(adj, curr, visited, helper);
                //cycle is found
                if(ans == true) return true;
            }
        }
        //makr node unvisited in helper array while backtrack
        helper[i] = false;
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
