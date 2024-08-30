package com.wissen.graph;

public class MostStonesRemovedWithSameRowOrColumn {

	// TC: O(n*2)
	// SC: O(n) visited array + O(n*2) stack space in worst case
	public int removeStones(int[][] stones) {
		int n = stones.length;
		int group = 0;
		boolean[] visited = new boolean[n];

		// explore all indexes
		for (int index = 0; index < n; index++) {
			if (visited[index] == false) {
				// new group is found
				dfs(stones, visited, index);
				group++;
			}
		}

		return n - group;
	}

	private void dfs(int[][] stones, boolean[] visited, int index) {
		// make curr index as visited
		visited[index] = true;

		for (int i = 0; i < stones.length; i++) {
			// /row & col of index(which is visited just previously)
			int row = stones[index][0];
			int col = stones[index][1];
			// check if curr row or col or both equlas to index's row & col
			// it shows that curr stones is in same row or same col of its previous stones
			// If it is so, it means curr stone is also part of the same group, perform dfs
			// on curr index(i) to explore stones of same group
			if (visited[i] == false && (stones[i][0] == row || stones[i][1] == col)) {
				dfs(stones, visited, i);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
