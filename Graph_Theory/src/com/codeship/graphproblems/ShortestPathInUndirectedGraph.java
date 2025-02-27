package com.codeship.graphproblems;

import java.util.*;

public class ShortestPathInUndirectedGraph {
	
	public int[] shortestPath(ArrayList<ArrayList<Integer>> inpuAdj, int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        //n - no. of vertices or nodes
        int n = inpuAdj.size();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());    
        }
        //making adjcency list
        for(int i = 0; i < n; i++) {
            int u = i;
            for(int j = 0; j < inpuAdj.get(i).size(); j++) {
                int v = inpuAdj.get(i).get(j);
                //u -> v
                adj.get(u).add(v);
                //v -> u
                adj.get(v).add(u);
            }
        }
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        //initial configuration for BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int itr : adj.get(node)) {
                if(dist[node] + 1 < dist[itr]) {
                    dist[itr] = dist[node] + 1;
                    //add current updated node into queue
                    queue.offer(itr);
                }
            }
        }
        //mark unvisited node dist with -1
        for(int i = 0; i < n; i++) {
            if(dist[i] ==  (int)1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
