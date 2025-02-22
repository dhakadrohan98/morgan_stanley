package com.codeship.graphproblems;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
	
	private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis,
		    Stack<Integer> st) {
		        //mark current node as visited as usual in dfs
		        vis[node] = true;
		        //traverse through adjacent nodes (neighbours)
		        for(int itr : adj.get(node)) {
		            if(!vis[itr]) {
		                dfs(itr, adj, vis, st);
		            }
		        }
		        //while backtrack from a particular path, add current node into stack
		        st.push(node);
		    }
		    
		    // Function to return list containing vertices in Topological order.
		    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
		        int V = adj.size();
		        boolean[] vis = new boolean[V];
		        Stack<Integer> st = new Stack<>();
		        //Apply multi source DFS
		        for(int i = 0; i < V; i++) {
		            if(!vis[i]) {
		                dfs(i, adj, vis, st);
		            }
		        }
		        //now store stack values into ans list
		        ArrayList<Integer> ans = new ArrayList<>();
		        int i = 0;
		        while(!st.isEmpty()) {
		            ans.add(st.pop());
		        }
		        return ans;
		    }
		    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
