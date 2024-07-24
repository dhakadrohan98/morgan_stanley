package com.wissen.graph;

import java.util.ArrayList;

public class DetectCycleInUndirectedGraph {

	//TC: O(V+E)
	//SC: O(V)
	public static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[v];
		for(int i=0; i<v; i++) {
			if(!visited[i]) {
				//send first node of disconnected component & passed parent as -1
				if(DFS(adj, i, visited, -1) == true) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean DFS(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, int parent) {
		visited[src] = true;
		ArrayList<Integer> list = adj.get(src);
		for (int v : list) {
			if (!visited[v]) {
				if (DFS(adj, v, visited, src) == true) {
					return true;
				}
			} else if (v != parent) {
				return true;
			}
		}
		return false;
	}
}
