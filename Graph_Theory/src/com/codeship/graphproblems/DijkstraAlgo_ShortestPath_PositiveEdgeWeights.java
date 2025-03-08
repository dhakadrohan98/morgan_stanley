package com.codeship.graphproblems;

import java.util.*;

public class DijkstraAlgo_ShortestPath_PositiveEdgeWeights {

	class iPair {
	    int first, second;

	    iPair(int first, int second) {
	        this.first = first;
	        this.second = second;
	    }
	}
	
	class Pair {
        int dist;
        int node;
        
        public Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }
    
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        //declare min_heap, do sorting based on dist first if dist are equal then sort based on the node value
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
            
            @Override
            public int compare(Pair p1, Pair p2) {
                if(p1.dist == p2.dist) {
                    return p1.node - p2.node;
                }
                return p1.dist - p2.dist;
            }
        });
        //initial configuration for BFS in finding shortest path
        //fill dist array with infinite weights(very large integer values)
        int[] dist = new int[adj.size()];
       
        for(int i = 0; i < dist.length; i++) {
            dist[i] = (int) 1e9;
        }
        //set 0 dist for src node 
        dist[src] = 0;
        pq.offer(new Pair(0, src));
        
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            int currDist = pair.dist;
            int node = pair.node;
 //         [[[1, 1], [2, 6]]]
 //         iPair = [adjNnode, edgeWeight]
            //[[1, 1], [2, 6]]
            
            for(iPair inner : adj.get(node)) {
                int adjNode = inner.first;
                int edgeWeight = inner.second;
                
                if(currDist + edgeWeight < dist[adjNode]) {
                    //update dist array with new less distance
                    dist[adjNode] = currDist + edgeWeight;
                    //insert the this new minDist pair into pq
                    pq.offer(new Pair(currDist + edgeWeight, adjNode));
                    
                }
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < dist.length; i++) {
           res.add(dist[i]);
        }
        return res;
        
    }

}
