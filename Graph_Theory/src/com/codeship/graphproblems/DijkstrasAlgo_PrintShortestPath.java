package com.codeship.graphproblems;

import java.util.*;
public class DijkstrasAlgo_PrintShortestPath {
	
	class Pair {
        int dist;
        int node;
        Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }
    
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<Pair>> adjList = new ArrayList<>();
        //Creating Adjacency list for u->v with w weight & v->u{w}
        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adjList.get(u).add(new Pair(w, v));
            adjList.get(v).add(new Pair(w, u));
        }
        
         PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
            
            @Override
            public int compare(Pair p1, Pair p2) {
                if(p1.dist == p2.dist) {
                    return p1.node - p2.node;
                }
                return p1.dist - p2.dist;
            }
        });
        //because store nodes from 1 to n
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        int src_node = 1;
        //mark dist[] with infinity(very large integer value)
        //parent[] = {1, 2, 3, ...., n};
        for(int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
            parent[i] = i;
        }
        dist[src_node] = 0;
        pq.offer(new Pair(0, 1));
        
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int distance = pair.dist;
            
            for(Pair itr: adjList.get(node)) {
                int adjNode = itr.node;
                int edgeWeight = itr.dist;
                
                if(distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWeight;
                    pq.offer(new Pair(dist[adjNode], adjNode));
                    //making parent of adjNode as Node from where it is adjNode coming from
                    parent[adjNode] = node;
                }
            }
        }
        
        List<Integer> path = new ArrayList<>();
        //if no path exists from 1 to n
        if(dist[n] == 1e9) {
            path.add(-1);
            return path;
        }
        int node = n;
        //O(N)
        while(parent[node] != node) {
            path.add(node);
            node = parent[node]; 
        }
        //add 1 at the last because it was not added & it is src vertex
        path.add(1);
        //add weight of the path
        path.add(dist[n]);
        Collections.reverse(path);
        return path;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
