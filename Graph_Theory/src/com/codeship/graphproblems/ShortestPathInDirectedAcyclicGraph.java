package com.codeship.graphproblems;

import java.util.*;
public class ShortestPathInDirectedAcyclicGraph {
	
	 class Pair {
	        int first;
	        int second;
	        Pair(int _first, int _second) {
	            this.first = _first;
	            this.second = _second;
	        }
	    }

	    private void topoSort(int node, List<List<Pair>> adj, boolean[] vis, 
	    Stack<Integer> st) {
	        //mark curr node as visited
	        vis[node] = true;
	        //apply dfs on neighbors nodes if not visited
	        for(Pair pair : adj.get(node)) {
	            int v = pair.first;
	            if(!vis[v]) {
	                topoSort(v, adj, vis, st);
	            }
	        }
	        //while backtrack push the curr node into the stack
	        st.push(node);
	    }
	    
	    public int[] shortestPath(int V, int E, int[][] edges) {
	        List<List<Pair>> adj = new ArrayList<>();
	        for(int i = 0; i < V; i++) {
	            adj.add(new ArrayList<Pair>());
	        }
	        //step1: make the adjacency list from edges[][] array
	        for(int i = 0; i < E; i++) {
	            int u = edges[i][0];
	            int v = edges[i][1];
	            int wt = edges[i][2];
	            adj.get(u).add(new Pair(v, wt));
	        }
	        //Step1: find the toposort
	        boolean[] vis = new boolean[V];
	        Stack<Integer> st = new Stack<>();
	        for(int i = 0; i < V; i++) {
	            if(!vis[i]) {
	                topoSort(i, adj, vis, st);
	            }
	        }
	        
	        //step2: do the distance calculation for a node taken out one by one from the stack
	        int[] dist = new int[V];
	        //initially assign infinity as dist to each node
	        Arrays.fill(dist, (int)1e9);
	        //0 is the source vertex
	        int srcVertex = 0;
	        dist[srcVertex] = 0;
	        while(!st.isEmpty()) {
	            int node = st.pop();
	            
	            for(Pair pair : adj.get(node)) {
	                int v = pair.first;
	                int wt = pair.second;
	                
	                if((dist[node] + wt) < dist[v]) {
	                    dist[v] =  wt + dist[node];         
	                }
	            }
	        }
	        //assign -1 that node where reach is not possible
	        for(int i = 0; i < V; i++) {
	            if(dist[i] == (int)1e9) {
	                dist[i] = -1; 
	            }
	        }
	        
	        return dist;
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
