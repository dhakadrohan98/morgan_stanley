package com.wissen.graph;

public class NoOfProvinces {
	// TC: O(V+E)
	// SC: O(V)
	// Count total no. of components of a graph
	public int findCircleNum(int[][] isConnected) {
		int provinces = 0;
		int n = isConnected.length;
		boolean[] visited = new boolean[n];
		for (int sr = 0; sr < n; sr++) {
			// first node of new component of a graph
			if (!visited[sr]) {
				provinces++;
				dfs(sr, isConnected, visited);
			}
		}
		return provinces;
	}

	private void dfs(int sr, int[][] mat, boolean[] visited) {
		int n = mat.length;
		visited[sr] = true;
		for (int i = 0; i < n; i++) {
			if (mat[sr][i] == 1 && visited[i] == false) {
				dfs(i, mat, visited);
			}
		}
	}
}
