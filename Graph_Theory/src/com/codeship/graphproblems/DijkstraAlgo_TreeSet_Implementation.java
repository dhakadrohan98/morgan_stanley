package com.codeship.graphproblems;

import java.util.*;

public class DijkstraAlgo_TreeSet_Implementation {
	
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
        TreeSet<Pair> set = new TreeSet<Pair>(new Comparator<Pair>() {
            
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
        //set 0 dist for src node  in dist array
        dist[src] = 0;
        set.add(new Pair(0, src));
        
        while(!set.isEmpty()) {
            Pair pair = set.pollFirst();
            int currDist = pair.dist;
            int node = pair.node;
 //         [[[1, 1], [2, 6]]]
 //         iPair = [adjNnode, edgeWeight]
            //[[1, 1], [2, 6]]
            
            for(iPair inner : adj.get(node)) {
                int adjNode = inner.first;
                int edgeWeight = inner.second;
                
                if(currDist + edgeWeight < dist[adjNode]) {
                    //remove dist[adjNode] from the set, it means this node is visited previously through a another path from the src node
                    if(dist[adjNode] != (int)1e9) {
                        set.remove(new Pair(dist[adjNode], adjNode));
                    }
                    
                    //update dist array with new less distance
                    dist[adjNode] = currDist + edgeWeight;
                    //insert the this new minDist pair into pq
                    set.add(new Pair(dist[adjNode], adjNode));
                    
                }
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < dist.length; i++) {
           res.add(dist[i]);
        }
        return res;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
