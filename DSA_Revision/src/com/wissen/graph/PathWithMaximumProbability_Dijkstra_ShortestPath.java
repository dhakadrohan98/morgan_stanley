package com.wissen.graph;

import java.util.*;

class Pair {
	int node;
	double probability;

	public Pair(int node, double probability) {
		this.node = node;
		this.probability = probability;
	}
}

public class PathWithMaximumProbability_Dijkstra_ShortestPath {

	public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		// build the adjacency list for graph
		Map<Integer, List<Pair>> adj = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			double pathProb = succProb[i];
			// u ----{pathProb} v
			if(!adj.containsKey(u)) {
				adj.put(u, new ArrayList<>());
			}
			
			adj.get(u).add(new Pair(v, pathProb));
			
			// v-----{pathProb} u
			if(!adj.containsKey(v)) {
				adj.put(v, new ArrayList<>());
			}
			adj.get(v).add(new Pair(u, pathProb));
		}
		
		//result array to store maximum probability to reach each node from the 0th node
		double[] maxProb = new double[n];
		//prob to reach 0 node from 0 node will be 1
		maxProb[start] = 1d;
		
		//Max-heap priority queue(based on probability value) to explore the highest probability first
		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.probability, a.probability));
		
		pq.offer(new Pair(start, 1.0));
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			double currProb = p.probability;
			int currNode = p.node;
			
			//if the current node is the end node, return the probability
			if(currNode == end) {
				return currProb;
			}
			
			//Explore the neighbors
			if(adj.containsKey(currNode)) {
				for(Pair next : adj.get(currNode)) {
					int nextNode = next.node;
					double pathProb = next.probability;
					
					//update the probability if a higher one if found
					if(currProb * pathProb > maxProb[nextNode]) {
						maxProb[nextNode] = currProb * pathProb;
						pq.offer(new Pair(nextNode, maxProb[nextNode]));
					}
				}
			}
		}
		
		//if end node is not reachable then return 0
		return 0d;
	}

	public static void main(String[] args) {
		int[][] edges = {{0,1}, {1,2}, {0,2}};
		double[] succProb = {0.5, 0.5, 0.3};
		//no. of vertxes
		int n = 3;
		int start = 0;
		int end = 2;
		double ans = maxProbability(n, edges, succProb, start, end);
		System.out.println(ans);
	}
}
