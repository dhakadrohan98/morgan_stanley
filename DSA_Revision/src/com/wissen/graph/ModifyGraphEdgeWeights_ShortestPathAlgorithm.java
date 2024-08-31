package com.wissen.graph;

import java.util.*;

//TC: O((V+E) * logV)
//SC: O(V+E)

public class ModifyGraphEdgeWeights_ShortestPathAlgorithm {
	private static final int LARGE_VALUE = (int) 2e9;
	private static final int[][] empty_arr = new int[][] {};

	// TC: O((V+E) * logV)
	// Dijkstra's algorithm to find the shortest path
	private long dijkstraAlgo(int[][] edges, int n, int src, int dest) {
		// Create adjacency list excluding edges with -1 weight
		Map<Long, List<long[]>> adj = new HashMap<>();
		for (int[] edge : edges) { // TC: O(E+V) -> The adjacency list stores all edges.
			if (edge[2] != -1) {
				int u = edge[0];
				int v = edge[1];
				int wt = edge[2];

				adj.putIfAbsent((long) u, new ArrayList<>());
				adj.putIfAbsent((long) v, new ArrayList<>());
				// u -> {v, wt}
				adj.get((long) u).add(new long[] { v, wt });
				// v -> {u, wt}
				adj.get((long) v).add(new long[] { u, wt });
			}
		}
		// PQ< new long[]{distance, node} >
		PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0])); //The priority queue stores at most (V) elements. O(V)
		long[] result = new long[n]; // shortest path distance from src to each node
		// keep track of visited node
		boolean[] visited = new boolean[n];
		Arrays.fill(result, Long.MAX_VALUE); // Initialize distances as infinity from src to each node
		result[src] = 0; // Distance from src to src is 0
		pq.offer(new long[] { 0, src }); // (distance, node)

		while (!pq.isEmpty()) {
			long[] curr = pq.poll();
			long currDist = curr[0];
			int currNode = (int) curr[1];
			// if curr node is already visited then don't visit
			if (visited[currNode])
				continue;
			// mark curr node as visited
			visited[currNode] = true;

			// if no adjacent node are there to current node, we can't visit its child n
			if (!adj.containsKey((long) currNode))
				continue;

			for (long[] neighbor : adj.get((long) currNode)) {
				int nbr = (int) neighbor[0];
				long weight = neighbor[1];

				if (result[nbr] > currDist + weight) {
					result[nbr] = currDist + weight;
					pq.offer(new long[] { result[nbr], nbr });
				}
			}
		}

		return result[dest];

	}

	public int[][] modifiedGraphEdges(int n, int[][] edges, int src, int dest, int target) {
		long currShortestDist = dijkstraAlgo(edges, n, src, dest);

		// SP -> shortest path
		// case 1: SP < target
		// modifying edges doesn't make any sense(Already shortest path less than the
		// target is present)
		if (currShortestDist < target) {
			return empty_arr;
		}

		// case 2:SP == target
		boolean matchedTarget = (currShortestDist == target);

		if (matchedTarget == true) {
			for (int[] edge : edges) {
				// if edge weight is negative then assign large values[1, 2 * 10^9] to those
			    //negative edge weight
				if (edge[2] == -1) {
					edge[2] = LARGE_VALUE;
				}
			}
			return edges;
		}

		// TC: O(E * ((V+E) * log(V)))
		// case 3 when SP > target
		for (int[] edge : edges) {
			// if curr edge weight is -ve then only check for new shortest path or assgining
			// them LARGE_VALUE according to this case algorithm
			if (edge[2] == -1) {
				// if new SP is less than or equal to target, assign (2 * 10^9) to negative edge
				// weight
				edge[2] = (matchedTarget == true) ? LARGE_VALUE : 1;
				// if new SP is still greater target
				if (!matchedTarget) {
					long newShortestDist = dijkstraAlgo(edges, n, src, dest);
					// if new SP is less or equal to than target, then flag matchedTarget to true
					// and
					// assign curr edge weight with target - newShortestDist;
					if (newShortestDist <= target) {
						matchedTarget = true;
						edge[2] += target - newShortestDist;
					}
				}
			}
		}
		// ans is not possible, return empty array
		if (!matchedTarget) {
			return empty_arr;
		}
		// ans is found, return original edges[][] array because their negative weights
		// has been
		// modified to +ve values
		return edges;
	}
}
