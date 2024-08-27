package com.wissen.graph;

import java.util.*;


public class PathWithMaximumProbability {
	
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		// Build the graph
		Map<Integer, List<Pair>> graph = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0], v = edges[i][1];
			double pathProb = succProb[i];

			if (!graph.containsKey(u)) {
				graph.put(u, new ArrayList<>());
			}
			graph.get(u).add(new Pair(v, pathProb));

			if (!graph.containsKey(v)) {
				graph.put(v, new ArrayList<>());
			}
			graph.get(v).add(new Pair(u, pathProb));
		}

		// Array to store the maximum probability to reach each node
		double[] maxProb = new double[n];
		maxProb[start] = 1d;

		// Max-heap priority queue to explore the highest probability first
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			public int compare(Pair a, Pair b) {
				return Double.compare(b.probability, a.probability);
			}
		});
		pq.add(new Pair(start, 1.0));

		while (!pq.isEmpty()) {
			Pair cur = pq.poll();
			double curProb = cur.probability;
			int curNode = cur.node;

			// If the current node is the end node, return the probability
			if (curNode == end) {
				return curProb;
			}

			// Explore the neighbors
			if (graph.containsKey(curNode)) {
				for (Pair nxt : graph.get(curNode)) {
					int nxtNode = nxt.node;
					double pathProb = nxt.probability;

					// Update the probability if a higher one is found
					if (curProb * pathProb > maxProb[nxtNode]) {
						maxProb[nxtNode] = curProb * pathProb;
						pq.add(new Pair(nxtNode, maxProb[nxtNode]));
					}
				}
			}
		}

		// If the end node is not reachable, return 0
		return 0d;
	}
}
