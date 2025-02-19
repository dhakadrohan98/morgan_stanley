package com.codeship.graphproblems;

import java.util.*;
public class CycleInADirectedGraph {

	private boolean dfs(int node, boolean[] vis, int[] pathVis, ArrayList<ArrayList<Integer>> adj) {
		vis[node] = true;
		pathVis[node] = 1;

		// traverse through neighbours(adjacent nodes)
		for (int itr : adj.get(node)) {
			// if node is not visited then definitely we have to visit this node
			if (!vis[itr]) {
				if (dfs(itr, vis, pathVis, adj) == true) {
					return true;
				}
			}
			// this node is visited previously & again we are visiting the same node
			// on the same path
			else if (pathVis[itr] == 1) {
				return true;
			}
		}
		// while backtrack from the last node of a path, make pathVis of curr node as 0.
		pathVis[node] = 0;
		return false;

	}

	// Function to detect cycle in a directed graph.
	public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
		int V = adj.size();
		boolean[] vis = new boolean[V];
		int pathVis[] = new int[V];
		// like a multi source DFS
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				if (dfs(i, vis, pathVis, adj) == true) {
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
