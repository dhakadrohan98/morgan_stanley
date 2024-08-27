package com.wissen.graph;

import java.util.*;

class CustomPair {
	int node;
	int distance;
	
	public CustomPair(int node, int distance) {
		this.node = node;
		this.distance = distance;
	}
}

public class Dijkstra_ShortestPath_Undirected_Heap {
	
	public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
		//min heap to store shortest distance pair at the top
		PriorityQueue<CustomPair> pq = new PriorityQueue<>((a, b) -> Integer
				.compare(a.distance, b.distance));
		//result array store shortest distance to each vertex from source/start vertex
		int[] result = new int[V];
		//Initially distance to reach each vertex from src vertex is Integer max value
		Arrays.fill(result, Integer.MAX_VALUE);
		//to reach src vertex from src verted, distance will be zero
		result[src] = 0;
		//add the src node pair at the starting to the priority queue
		pq.offer(new CustomPair(src, 0));
		
		while(!pq.isEmpty()) {
			//take the top of this queue 
			CustomPair p = pq.poll();
			int currNode = p.node;
			int currDist = p.distance;
			//currNode = 2
			ArrayList<ArrayList<Integer>> mostOuterList = adj.get(currNode);
			//{{1, 3}, {0, 6}}
			for(ArrayList<Integer> neighbor : mostOuterList) {
				//neighbor1 -> {1,3}
				//neighbor2 -> {0,6}
				int adjNode = neighbor.get(0);
				int dist = neighbor.get(1);
				
				if(currDist + dist < result[adjNode]) {
					result[adjNode] = currDist + dist;
					pq.offer(new CustomPair(adjNode, dist + currDist));
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int V = 3;
        int src = 2;

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        // Adding edges for vertex 0
        ArrayList<ArrayList<Integer>> edges0 = new ArrayList<>();
        ArrayList<Integer> edge0_1 = new ArrayList<>();
        edge0_1.add(1); // destination vertex
        edge0_1.add(1); // weight
        edges0.add(edge0_1);

        ArrayList<Integer> edge0_2 = new ArrayList<>();
        edge0_2.add(2);
        edge0_2.add(6);
        edges0.add(edge0_2);

        adj.add(edges0);

        // Adding edges for vertex 1
        ArrayList<ArrayList<Integer>> edges1 = new ArrayList<>();
        ArrayList<Integer> edge1_2 = new ArrayList<>();
        edge1_2.add(2);
        edge1_2.add(3);
        edges1.add(edge1_2);

        ArrayList<Integer> edge1_0 = new ArrayList<>();
        edge1_0.add(0);
        edge1_0.add(1);
        edges1.add(edge1_0);

        adj.add(edges1);

        // Adding edges for vertex 2
        ArrayList<ArrayList<Integer>> edges2 = new ArrayList<>();
        ArrayList<Integer> edge2_1 = new ArrayList<>();
        edge2_1.add(1);
        edge2_1.add(3);
        edges2.add(edge2_1);

        ArrayList<Integer> edge2_0 = new ArrayList<>();
        edge2_0.add(0);
        edge2_0.add(6);
        edges2.add(edge2_0);

        adj.add(edges2);
        
        int[] result = dijkstra(V, adj, src);
        for(int val : result) {
        	System.out.print(val + " ");
        }
		
	}
	
}
//	adj -> {    {{1, 1}, {2, 6}},
//	{{2, 3}, {0, 1}}, 
//	{{1, 3}, {0, 6}}
// }
// V=3, S=2

