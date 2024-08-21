package com.wissen.graph;

import java.util.*;

public class TopologicalSort {

	public static int[] topoSort(List<List<Integer>> adj, int n) {
		int[] ans = new int[n];
		Stack<Integer> st = new Stack<>();
		boolean[] visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				topo(i, visited, adj, st);
			}
		}
		// pop element from stack & put into ans array
		int k = 0;
		while (!st.isEmpty()) {
			ans[k] = st.pop();
			k++;
		}
		return ans;
	}

	private static void topo(int i, boolean[] visited, List<List<Integer>> adj, Stack<Integer> st) {
		visited[i] = true;
		List<Integer> list = adj.get(i);
		if (list != null) {
			for (int x : list) {
				if (!visited[x]) {
					topo(x, visited, adj, st);
				}
			}
		}
		// while coming back reaching last node of dfs way(same component)
		st.push(i);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<List<Integer>> graphNodes = new ArrayList<>();
		int n = 9;
		for (int i = 0; i < n; i++) {
			List<Integer> list = new ArrayList<>();
			System.out.println("Enter number of adjacent nodes for " + i + "th node");
			int k = sc.nextInt();
			for (int j = 0; j < k; j++) {
				int adjacentNodes = sc.nextInt();
				list.add(adjacentNodes);
			}
			graphNodes.add(list);
		}

		// call topological sort method
		int[] res = topoSort(graphNodes, n);
		for (int val : res) {
			System.out.print(val + " ");
		}
	}
}

//1 1
//
//1 2
//
//1 3
//
//1 4
//
//0
//
//1 3
//
//2 1 5
//
//1 8
//
//0
