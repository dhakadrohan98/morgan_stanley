package com.codeship.representation;

import java.util.*;

//TC: O(v) + O(2*E) for undirected graph (summation of degree of a graph)
//SC: O(v) visited array + O(v) recursion stack space in case of skew graph + O(v) to store ans
public class DFSOfGraph {
	
	// Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size(); //5
        boolean[] visited = new boolean[v];
        //mark starting node as visited before starting dfs on it
        visited[0] = true;
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0, visited, adj, ans);
        return ans;
    }
    
    private static void dfs(int node, boolean[] visited, 
    ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans) {
        //mark current node as visited
        visited[node] = true;
        ans.add(node);
        
        //traverse through adjacency list for each node depth wise
        for(int itr: adj.get(node)) {
            if(!visited[itr]) {
                dfs(itr, visited, adj, ans);
            }
        }
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
